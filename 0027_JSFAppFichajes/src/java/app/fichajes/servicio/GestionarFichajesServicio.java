/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.servicio;

import app.fichajes.modelo.Empleado;
import app.fichajes.modelo.Fichaje;
import app.fichajes.modelo.InformeFichajeItem;
import app.fichajes.persistencia.EmpleadoDAO;
import app.fichajes.persistencia.FichajeDAO;
import app.fichajes.servicio.excepciones.FichajeExcepcion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
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
@Named(value = "gestionarFichajesService")
@SessionScoped
public class GestionarFichajesServicio implements Serializable{
    private static Logger log = Logger.getLogger("GestionarFichajesServicio");

    private Connection conn;
    private FichajeDAO fichajeDAO;
    private EmpleadoDAO empleadoDAO;

    public GestionarFichajesServicio() {
        try {
            this.conn = DBServicio.getDBServicio().obtenerConexionBD();
            this.fichajeDAO = new FichajeDAO(conn);
            this.empleadoDAO = new EmpleadoDAO(conn);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "Error al conectar con la base de datos", ex);
        }
    }
    
    public Fichaje obtenerUltimoFichajeEmpleado(int idEmpleado) throws FichajeExcepcion{
        try {
            Fichaje f = this.fichajeDAO.obtenerUltimoFichajeEmpleado(idEmpleado);
            this.conn.commit();
            return f;
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
    
    public List<Fichaje> obtenerFichajesEmpleado(int idEmpleado) throws FichajeExcepcion{
        try {
            List<Fichaje> list = this.fichajeDAO.obtenerFichajesEmpleado(idEmpleado);
            this.conn.commit();
            return list;
        } catch (SQLException ex) {
            log.severe("Al obtener los fichajes de un empleado. Error de BD. "+ex.getMessage());
            throw new FichajeExcepcion("No se pudieron obtener los fichajes del empleado");
        }
    }
    
    public List<InformeFichajeItem> informeFichajesEmpleado(int idEmpleado) throws FichajeExcepcion{
        try {
            Empleado e = this.empleadoDAO.buscarPorId(idEmpleado);
            List<Fichaje> list = this.fichajeDAO.obtenerFichajesEmpleado(idEmpleado);
            this.conn.commit();
            
            List<InformeFichajeItem> informe = new LinkedList();
            Iterator<Fichaje> it = list.iterator();
            
            while(it.hasNext()){
                Fichaje fichEntrada = it.next();
                
                if(it.hasNext()){
                    Fichaje fichSalida = it.next();
                    informe.add(new InformeFichajeItem(fichEntrada.getFechaHora(), fichSalida.getFechaHora(), e));
                }else{
                    informe.add(new InformeFichajeItem(fichEntrada.getFechaHora(), null, e));
                }
            }
            
            return informe;
        } catch (SQLException ex) {
            log.severe("Al obtener el informe de fichajes de un empleado. Error de BD. "+ex.getMessage());
            throw new FichajeExcepcion("No se pudo obtener el informe de fichajes del empleado");
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
