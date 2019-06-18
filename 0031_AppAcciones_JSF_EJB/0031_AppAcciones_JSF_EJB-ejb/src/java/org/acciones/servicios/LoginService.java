/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import java.sql.Connection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.acciones.modelo.Accionista;
import org.acciones.servicios.excepciones.AccionistaException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@Stateless
public class LoginService implements LoginServiceLocal {

    private static Logger log = Logger.getLogger("LoginService");

    @PersistenceContext
    private EntityManager em;

    @Override
    public Accionista autenticarAccionista(String nombre, String clave) throws BDException, AccionistaException {
        try {
            Query q = em.createNamedQuery("Accionista.findByNombreClave");
            q.setParameter("nombre", nombre);
            q.setParameter("clave", clave);
            return (Accionista) q.getSingleResult();
        } catch (NoResultException e){
             throw new AccionistaException("El nombre o la clave son incorrectos", "loginIncorrecto");
        } catch (Exception ex) {
            log.severe("Al autenticar un accionista. Error de BD. " + ex.getMessage());
            ex.printStackTrace();
            throw new BDException("Error al realizar la autenticación. Contacte con el administrador", "loginBDError");
        }
    }
}
