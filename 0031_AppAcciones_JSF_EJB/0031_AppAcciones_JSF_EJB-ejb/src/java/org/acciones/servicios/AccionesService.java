/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.acciones.modelo.Accion;
import org.acciones.modelo.AccionDeAccionista;
import org.acciones.modelo.Accionista;
import org.acciones.servicios.excepciones.AccionException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@Stateless
public class AccionesService implements AccionesServiceLocal {

    private static Logger log = Logger.getLogger("AccionesService");

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Accion> listarAcciones() throws BDException {
        try {
            List<Accion> l = em.createNamedQuery("Accion.findAll").getResultList();
            return l;

        } catch (Exception ex) {
            log.severe("Al listar las acciones disponibles. Error de BD. " + ex.getMessage());
            ex.printStackTrace();
            throw new BDException("Error al listar las acciones. Contacte con el administrador", "accionesListarBDError");
        }
    }

    @Override
    public List<AccionDeAccionista> listarAccionesAccionista(int idAccionista) throws BDException {
        try {
            Query q = em.createNamedQuery("Accion.findAccionesByAccionista");
            q.setParameter("idAccionista", idAccionista);
            List<AccionDeAccionista> l = q.getResultList();
            //System.out.println("Lista de acciones del accionista obtenida \n " + l);
            return l;

        } catch (Exception ex) {
            log.severe("Al listar las acciones del accionista. Error de BD. " + ex.getMessage());
            ex.printStackTrace();
            throw new BDException("Error al listar las acciones del accionista. Contacte con el administrador", "AccionesAccionistaListarBDError");
        }
    }

    /**
     *
     * @param idAccion
     * @param idAccionista
     * @param cantidad
     * @return el coste total de la compra de las acciones
     * @throws BDException
     * @throws AccionException
     */
    @Override
    public double comprarAccion(int idAccion, int idAccionista, int cantidad) throws BDException, AccionException {
        try {
            double valorTotal = 0.0;
            //Buscar la accion
            Accion a = em.find(Accion.class, idAccion);

            if (a == null) {
                throw new AccionException("No existe la acción con id " + idAccion, "AccionConsultaPrecioError");
            }

            //ValorTotal a devolver
            valorTotal = a.getValor() * cantidad;
            //buscar AccionDeAccionista con idAccion idAccionista
            AccionDeAccionista compra = buscarAcciondeAccionistaPorId(idAccionista, idAccion);
            //Si existe, actualizarlo
            if (compra != null) {
                //sumar el valorTotal y la cantidad de la compra
                compra.setCantidad(compra.getCantidad() + cantidad);
                compra.setValorCompraTotal(compra.getValorCompraTotal() + valorTotal);
                em.merge(compra);
            } else {
                //Si no, crear uno nuevo
                compra = new AccionDeAccionista(idAccion, idAccionista, cantidad, valorTotal);
                em.persist(compra);
            }
            return valorTotal;

        } catch (Exception ex) {
            log.severe("Al comprar accion " + idAccion + " el accionista " + idAccionista + " . Error de BD. " + ex.getMessage());
            ex.printStackTrace();
            throw new BDException("Error al comprar acciones. Contacte con el administrador", "AccionesComprarBDError");
        }
    }

    @Override
    public List<Accionista> listarAccionistas() throws BDException {
        try {
            List<Accionista> l = em.createNamedQuery("Accionista.findAll").getResultList();
            return l;

        } catch (Exception ex) {
            log.severe("Al listar los accionistas disponibles. Error de BD. " + ex.getMessage());
            ex.printStackTrace();
            throw new BDException("Error al listar los accionistas. Contacte con el administrador", "accionistasListarBDError");
        }
    }

    @Override
    public List<Accionista> listarAccionistasSinId(int idNoListar) throws BDException {
        try {
            Query q = em.createNamedQuery("Accionista.findAllExceptId");
            q.setParameter("id", idNoListar);
            List<Accionista> l = q.getResultList();
            return l;

        } catch (Exception ex) {
            log.severe("Al listar los accionistas disponibles excepto el id indicado. Error de BD. " + ex.getMessage());
            ex.printStackTrace();
            throw new BDException("Error al listar los accionistas. Contacte con el administrador", "accionistasListarBDError");
        }
    }

    /**
     *
     * @param idAccionistaVende
     * @param idAccionistaCompra
     * @param idAccion
     * @param cantidad
     * @return el valortotal de la venta
     * @throws BDException
     * @throws AccionException
     */
    @Override
    public double venderAccionAAccionista(int idAccionistaVende, int idAccionistaCompra, int idAccion, int cantidad) throws BDException, AccionException {
        try {
            //Buscar el registro de AccionAccionista del que vende
            AccionDeAccionista regCompra = this.buscarAcciondeAccionistaPorId(idAccionistaVende, idAccion);
            //si no tiene cantidad para vender excepcion
            if (regCompra.getCantidad() < cantidad) {
                throw new AccionException("No hay suficientes acciones para vender", "ventaNoSuficienteCantidad");
            }

            //Coger el precio de la accion y sacar el valor total de venta
            double valorTotalVenta = regCompra.getValorActualAccion() * cantidad;

            //Actualizar el Accionaccionista de la venta quitando las acciones y el valor total según el precio de la accion
            regCompra.setCantidad(regCompra.getCantidad() - cantidad);
            regCompra.setValorCompraTotal(regCompra.getValorCompraTotal() - valorTotalVenta);

            //TODO comprobar valortotal negativo
            //Si no le quedan, eliminar el registro
            //Si le quedan acciones, actualizar el registro
            if (regCompra.getCantidad() == 0) {
                em.remove(regCompra);
            } else {
                em.merge(regCompra);
            }

            //llamar a comprarAccion con el idAccionistaCompra, idAccion y cantidad
            this.comprarAccion(idAccion, idAccionistaCompra, cantidad);

            return valorTotalVenta;

        } catch (NoResultException e) {
            throw new AccionException("No se pudo localizar el registro de compra solicitado", "ventaRegistroNoLocalizado");
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public AccionDeAccionista buscarAcciondeAccionistaPorId(int idAccionista, int idAccion) {
        Query q = em.createNamedQuery("AccionDeAccionista.findByIdAccionIdAccionista");
        q.setParameter("idAccionista", idAccionista);
        q.setParameter("idAccion", idAccion);
        return (AccionDeAccionista) q.getSingleResult();
    }

    @Override
    public Accion getAccionPorId(int idAccion) throws BDException, AccionException {
        try {
            Accion a = em.find(Accion.class, idAccion);
            if (a == null) {
                throw new AccionException("No se pudo encontrar la acción con ID " + idAccion, "accionPorIdNoEncontrada");
            }
            return a;

        } catch (Exception e) {
            log.severe("Al buscar una acción por id. Error de BD. " + e.getMessage());
            e.printStackTrace();
            throw new BDException("Error al buscar una acción por ID. Contacte con el administrador", "accionPorIdBDError");
        }
    }

    @Override
    public void modificarAccion(Accion accion) throws BDException, AccionException {
        try{
            em.merge(accion);
        } catch (OptimisticLockException e){
            throw new AccionException("Otro usuario ya ha modificado la acción", "accionOptimisticLock");
        } catch (Exception e){
            log.severe("Al modificar una acción. Error de BD. " + e.getMessage());
            e.printStackTrace();
            throw new BDException("Error al modificar una acción. Contacte con el administrador", "accionModificarBDError");
        }
    }

}
