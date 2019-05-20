/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.web;

import app.fichajes.modelo.Empleado;
import app.fichajes.modelo.Fichaje;
import app.fichajes.servicio.GestionarEmpleadosServicio;
import app.fichajes.servicio.GestionarFichajesServicio;
import app.fichajes.servicio.excepciones.EmpleadoExcepcion;
import app.fichajes.servicio.excepciones.FichajeExcepcion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "interfazFichaje")
@SessionScoped
public class interfazFichajeManagedBean implements Serializable {

    private String claveEmpleado = "";
    private boolean modoConfirmar = false;//para el modo de renderización de la página
    
    private Empleado empleado = null;
    private Fichaje fichaje = null;
    
    @Inject
    private GestionarEmpleadosServicio gestionarEmpleadosServicio;
    @Inject
    private GestionarFichajesServicio gestionarFichajesServicio;
    
    public interfazFichajeManagedBean() {
    }

    public void setGestionarEmpleadosServicio(GestionarEmpleadosServicio gestionarEmpleadosServicio) {
        this.gestionarEmpleadosServicio = gestionarEmpleadosServicio;
    }

    public void setGestionarFichajesServicio(GestionarFichajesServicio gestionarFichajesServicio) {
        this.gestionarFichajesServicio = gestionarFichajesServicio;
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Fichaje getFichaje() {
        return fichaje;
    }

    public boolean isModoConfirmar() {
        return modoConfirmar;
    }
    
    
    
    public String autenticarYPrepararFichaje(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            //Buscar al empleado y tratar si no se encuentra
            this.empleado = this.gestionarEmpleadosServicio.buscarEmpleadoPorClave(claveEmpleado);
            
            if(this.empleado == null){//TODO meter al servicio
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Clave incorrecta", "La clave dada no corresponde a ningún empleado"));
                return null;
            }
            //TODO meter al servicio
            //Buscar el último fichaje del empleado
            Fichaje ultimo = this.gestionarFichajesServicio.obtenerUltimoFichajeEmpleado(this.empleado.getId());
            //si no hay último o el último es de tipo salida, crear de tipo entrada
            if(ultimo == null || ultimo.getTipo() == 'S'){
                this.fichaje = new Fichaje(0, this.empleado.getId(), 'E', LocalDateTime.now());
            }else if(ultimo.getTipo() == 'E'){//Si el último es de tipo entrada, crear una salida
                this.fichaje = new Fichaje(0, this.empleado.getId(), 'S', LocalDateTime.now());
            }else{
                //Error??????
            }
            
            //Pasar a modo Confirmar 
            modoConfirmar = true;
            
            
        } catch (EmpleadoExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se pudo acceder al empleado", "No se pudo acceder al empleado. Error de sistema."));
        } catch (FichajeExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se pudo acceder al último fichaje", "No se pudo acceder al último fichaje del empleado. Error de sistema."));
        }
        
        return null;
    }
    
    public String confirmarFichaje(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            this.gestionarFichajesServicio.guardarNuevoFichaje(this.fichaje);
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fichaje realizado con éxito", "Se ha realizado con éxito el fichaje de " + this.fichaje.getTipoEnString()));
            //Limpiar datos y preparar para atender otra petición
            this.claveEmpleado = "";
            this.empleado = null;
            this.fichaje = null;
            this.modoConfirmar = false;
        } catch (FichajeExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se pudo guardar el fichaje", "No se pudo guardar el fichaje. Error de sistema."));
        }
        return null;
    }
    
}
