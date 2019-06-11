/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios.scheduled;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import org.acciones.dao.AccionesDAOLocal;
import org.acciones.modelo.Accion;
import org.acciones.servicios.excepciones.AccionException;

/**
 *
 * @author david
 */
@Stateless
public class ActualizarPreciosService implements ActualizarPreciosServiceLocal {

    private static Logger log = Logger.getLogger("ActualizarPreciosService");

    @EJB
    private AccionesDAOLocal accionesDAOLocal;

    @Resource(name = "java:app/jdbc/accionesderbydb")
    private DataSource ds;

    //@Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*/10", second = "0")
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    //@Schedule(dayOfWeek = "*", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*/3", second = "0")
    @Override
    public void actualizarPrecios() {
        try {
            System.out.println("Actualizando precios");
            Connection conn = ds.getConnection();
            conn.setAutoCommit(true);
            //Aprovecho el listado para tener los ids de las acciones
            List<Accion> acciones = accionesDAOLocal.listarAcciones(conn);
            conn.commit();

            for (Accion a : acciones) {
                try {
                    //Cada actualización será una transacción, consultando el valor actual
                    //en la BD antes de actualizarlo
                    double multiplicador = Math.random() / 2 + 0.75;
                    double valor = accionesDAOLocal.consultarPrecioAccion(conn, a.getId());
                    valor = Math.round((valor * multiplicador)*1000)/1000.0;
                    accionesDAOLocal.actualizarPrecioAccion(conn, a.getId(), valor);
                    conn.commit();
                } catch (AccionException | SQLException ex) {
                    log.severe("Al actualizar el valor de la accion con id " + a.getId() + ex.getMessage());
                }
            }

            conn.close();
        } catch (SQLException ex) {
            log.severe("Al listar las acciones disponibles. Error de BD. " + ex.getMessage());
        }
    }

}
