/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.servicio;

import app.fichajes.modelo.Empleado;
import app.fichajes.persistencia.EmpleadoDAO;
import app.fichajes.servicio.excepciones.EmpleadoExcepcion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 *
 * @author david
 */
@Named(value = "administracionServicio")
@SessionScoped
public class AdministracionServicio implements Serializable {

    private static Logger log = Logger.getLogger("AdministracionServicio");

//    @Resource(name = "java:app/jdbc/fichajes")
//    DataSource ds;
    private Connection conn;

    public AdministracionServicio() {
        try {
            this.conn = DBServicio.getDBServicio().obtenerConexionBD();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }
    }

//    public void setDs(DataSource ds) {
//        this.ds = ds;
//    }

    public Empleado autenticarEmpleadoAdmin(String dni, String clave) throws EmpleadoExcepcion {//AdminExcception?
        try {
            //Connection conn = ds.getConnection();
            EmpleadoDAO dao = new EmpleadoDAO(conn);
            return dao.autenticarAdmin(dni, clave);
        } catch (SQLException ex) {
            log.severe("Al autenticar un empleado en administración. Error de BD. "+ex.getMessage());
            throw new EmpleadoExcepcion("Error al realizar la autenticación del empleado");
        }

    }
}
