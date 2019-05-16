/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.servicio;

import app.fichajes.modelo.Fichaje;
import app.fichajes.persistencia.FichajeDAO;
import app.fichajes.servicio.excepciones.FichajeExcepcion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author david
 */
@Named(value = "gestionarFichajesService")
@SessionScoped
public class GestionarFichajesServicio implements Serializable{
    private static Logger log = Logger.getLogger("GestionarFichajesServicio");

    private Connection conn;
    private FichajeDAO fichajeDAO;

    public GestionarFichajesServicio() {
        try {
            this.conn = DBServicio.getDBServicio().obtenerConexionBD();
            this.fichajeDAO = new FichajeDAO(conn);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }
    }
    
    public Fichaje obtenerUltimoFichajeEmpleado(int idEmpleado) throws FichajeExcepcion{
        try {
            return this.fichajeDAO.obtenerUltimoFichajeEmpleado(idEmpleado);
        } catch (SQLException ex) {
            log.severe("Al obtener el último fichaje de un empleado. Error de BD. "+ex.getMessage());
            throw new FichajeExcepcion("No se pudo obtener el último fichaje del empleado con ID " +idEmpleado);
        }
    }
    
    public void guardarNuevoFichaje(Fichaje f) throws FichajeExcepcion{
        try {
            this.fichajeDAO.alta(f);
            this.conn.commit();
        } catch (SQLException ex) {
            log.severe("Al guardar un nuevo fichaje de un empleado. Error de BD. "+ex.getMessage());
            throw new FichajeExcepcion("No se pudo guardar el fichaje");
        }
    }
    
    @PreDestroy
    public void cierre(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            log.severe("Al cerrar la conexión de la BD. Error BD: " + ex.getMessage());
        }
    }
}
