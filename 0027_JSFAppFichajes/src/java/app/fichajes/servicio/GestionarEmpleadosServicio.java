/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.servicio;

import app.fichajes.modelo.Empleado;
import app.fichajes.modelo.comparators.EmpleadoComparatorPorNombre;
import app.fichajes.persistencia.EmpleadoDAO;
import app.fichajes.servicio.excepciones.EmpleadoExcepcion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author david
 */
@Named(value = "gestionarEmpleadosService")
@SessionScoped
public class GestionarEmpleadosServicio implements Serializable {

    private static Logger log = Logger.getLogger("GestionarEmpleadosServicio");

    private Connection conn;
    private EmpleadoDAO empleadoDAO;

    public GestionarEmpleadosServicio() {
        try {
            this.conn = DBServicio.getDBServicio().obtenerConexionBD();
            this.empleadoDAO = new EmpleadoDAO(this.conn);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }
    }

    public Empleado buscarEmpleadoPorClave(String clave) throws EmpleadoExcepcion {

        try {
            Empleado e = this.empleadoDAO.buscarPorClave(clave);
            this.conn.commit();
            return e;
        } catch (SQLException ex) {
            log.severe("Al buscar un empleado por clave. Error de BD. " + ex.getMessage());
            throw new EmpleadoExcepcion("No se pudo obtener el empleado por clave");
        }
    }

    public List<Empleado> getListaEmpleadosOrdenadoNombre() throws EmpleadoExcepcion {
        try {
            List<Empleado> lista = this.empleadoDAO.obtenerTodos();
            this.conn.commit();
            Collections.sort(lista, new EmpleadoComparatorPorNombre());
            return lista;
        } catch (SQLException ex) {
            log.severe("Al obtener la lista de empleados ordenada por nombre. Error de BD. " + ex.getMessage());
            throw new EmpleadoExcepcion("No se pudo obtener la lista de empleados ordenada por nombre");
        }
    }

    @PreDestroy
    public void cierre() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            log.severe("Al cerrar la conexión de la BD. Error BD: " + ex.getMessage());
        }
    }

    public Empleado buscarEmpleadoPorId(int id) throws EmpleadoExcepcion{
        try {
            Empleado e = this.empleadoDAO.buscarPorId(id);
            this.conn.commit();
            return e;
        } catch (SQLException ex) {
            log.severe("Al buscar un empleado por id. Error de BD. " + ex.getMessage());
            throw new EmpleadoExcepcion("No se pudo obtener el empleado por id");
        }
    }
}
