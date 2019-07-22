package com.bolsa.servicios;

import com.bolsa.dominio.Accion;
import com.bolsa.dominio.Accionista;
import com.bolsa.excepciones.BrokerException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author david
 */
@Stateless
public class BrokerService implements BrokerServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Accionista> getAllAccionistas() {
        Query q = em.createNamedQuery("Accionista.findAll");//Usa una query predefinida
        List<Accionista> lista = q.getResultList();
        return lista;
        //Query q2 = em.createNativeQuery("SELECT * FROM ACCIONISTAS");//Query normal
    }

    @Override
    public Accionista addAccionista(Accionista a) {
//        a.setFechaCreacion(new Date());
//        a.setFechaModificacion(new Date());
        em.persist(a);//Insert y 
        return a;
    }

    @Override
    public void deleteAccionista(int id) {
        //El id. Necesita que el objeto haya sido enconttrado previamente
        //Que esté sincronizado con la base de datos
        Accionista aBorrar = em.find(Accionista.class, id);
        em.remove(aBorrar);
    }

    /**
     * Modifica los datos del accionista. Si no existe lanza la excepción AccionistaException
     * @param a
     * @return
     * @throws AccionistaException 
     */
    @Override
    public Accionista updateAccionista(Accionista a) throws BrokerException {
        //a.setFechaModificacion(new Date());
        //Modo A
        //find, setter cambiar valores
//        System.out.println("....buscando accionista por ID");
//        Accionista aBD = em.find(Accionista.class, a.getIdAccionista());
//        if(aBD == null){
//            aBD.setNombre(a.getNombre());//a no está en un estado persistente, aBD sí
//            aBD.setFechaModificacion(new Date());
//            System.out.println("Cambio datos accionista");
//        }else{
//            throw new BrokerException("accionista.noExiste");//no es un error inesperado, es una notificacion de fallo,
//        }
//        return aBD;
        //Modo B
        //find y merge
        //a.setFechaModificacion(new Date());//No hace falta, gestionado en la entidad
        Accionista aBD = em.merge(a);
        //a sigue sin estar ssincronizado con BD
        //aBD está en el contexto de persistencia, se sincroiza (al hacer commit)
        return aBD;
        
        //commit automático cuando termina el método sin excepciones
    }

    @Override
    public Accionista buscaAccionistaPorId(int id) {
        return em.find(Accionista.class, id);
    }

    @Override
    public List<Accion> getAllAcciones() {
        Query q = em.createNamedQuery("Accion.findAll");//Usa una query predefinida
        List<Accion> lista = q.getResultList();
        return lista;
    }

    @Override
    public Accion addAccion(Accion accion) {
        em.persist(accion);//Insert y 
        return accion;
    }

    @Override
    public void deleteAccion(int id) throws BrokerException {
        Accion aBorrar = em.find(Accion.class, id);
        if(aBorrar != null)
            em.remove(aBorrar);
        else
            throw new BrokerException("accion.noEncontrada");
    }

    /**
     * Asume que todos los campos de la accion están establecidos
     * @param accion
     * @return
     * @throws BrokerException 
     */
    @Override
    public Accion updateAccion(Accion accion) throws BrokerException {
        Accion aBD = em.merge(accion);
        return aBD;
    }

    @Override
    public Accion buscaAccionPorId(int id) {
        return em.find(Accion.class, id);
    }
    
    
}
