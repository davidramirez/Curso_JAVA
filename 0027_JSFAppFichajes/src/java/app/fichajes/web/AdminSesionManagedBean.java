/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.web;

import app.fichajes.modelo.Empleado;
import app.fichajes.servicio.AdministracionServicio;
import app.fichajes.servicio.excepciones.EmpleadoExcepcion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "adminSesion")
@SessionScoped
public class AdminSesionManagedBean implements Serializable {

    Empleado admin;

    @Inject
    private AdministracionServicio administracionServicio;

    /**
     * Creates a new instance of AdminSesionManagedBean
     */
    public AdminSesionManagedBean() {
        
    }

    public Empleado getAdmin() {
        return admin;
    }

    public void setAdministracionServicio(AdministracionServicio administracionServicio) {
        this.administracionServicio = administracionServicio;
    }

    public String autenticarAdmin(String dni, String clave) {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            this.admin = administracionServicio.autenticarEmpleadoAdmin(dni, clave);
            if (this.admin != null) {
                return "listadofichajes";
            } else {
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas", "Los datos de autenticación no son correctos"));
            }
        } catch (EmpleadoExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, ex.getMessage(), ex.getMessage()));
        }
        return null;
    }
}
