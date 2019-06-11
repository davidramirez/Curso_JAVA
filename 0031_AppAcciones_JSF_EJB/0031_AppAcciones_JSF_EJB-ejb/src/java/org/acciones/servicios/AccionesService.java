/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.acciones.modelo.Accion;
import org.acciones.modelo.AccionDeAccionista;
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
            Query q = em.createNamedQuery("AccionDeAccionista.findByIdAccionIdAccionista");
            q.setParameter("idAccionista", idAccionista);
            q.setParameter("idAccion", idAccion);
            AccionDeAccionista compra = (AccionDeAccionista) q.getSingleResult();
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
}
