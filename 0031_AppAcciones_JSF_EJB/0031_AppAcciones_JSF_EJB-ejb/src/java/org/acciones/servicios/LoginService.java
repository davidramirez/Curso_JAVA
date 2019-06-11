/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import org.acciones.dao.AccionistasDAOLocal;
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

    @Resource(name = "java:app/jdbc/accionesdb")
    private DataSource ds;

    @EJB
    private AccionistasDAOLocal dao;

    @Override
    public Accionista autenticarAccionista(String nombre, String clave) throws BDException, AccionistaException {
        Connection conn = null;
        try {
            conn = ds.getConnection();
//            ResultSet r = conn.getMetaData().getTables(null, null, "%", null);
//
//            while (r.next()) {
//                System.out.println(r.getString(3) + " " + r.getString(4));
//            }

            Accionista a = dao.autenticarAccionista(conn, nombre, clave);
            conn.close();
            if (a != null) {
                return a;
            } else {
                throw new AccionistaException("El nombre o la clave son incorrectos", "loginIncorrecto");
            }
        } catch (SQLException ex) {
            log.severe("Al autenticar un accionista. Error de BD. " + ex.getMessage());
            throw new BDException("Error al realizar la autenticación. Contacte con el administrador", "loginBDError");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    log.severe("Al autenticar un accionista. Error de BD. " + ex.getMessage());
                    throw new BDException("Error al realizar la autenticación. Contacte con el administrador", "loginBDError");
                }
            }
        }
    }
}
