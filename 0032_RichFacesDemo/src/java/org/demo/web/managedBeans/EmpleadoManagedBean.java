/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.web.managedBeans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Named(value = "empleadoBean")
@ViewScoped
public class EmpleadoManagedBean implements Serializable {

    @NotNull
    @Size(min = 9, max = 9)
    private String dni;
    @Size(min = 1, max = 20)
    private String Nombre;
    @Size(min = 1, max = 20)
    private String Apellidos;

    /**
     * Creates a new instance of EmpleadoManagedBean
     */
    public EmpleadoManagedBean() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void listenerExisteDni(AjaxBehaviorEvent ev) {
        UIInput input = (UIInput) ev.getComponent();
        //System.out.println("Dni validado es " + input.getValue());
        System.out.println("Dni validado es " + this.dni);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Después de ajax"));
    }

    public String btnGuardar() {
        System.out.println("Guardando " + dni + " "+ Nombre + " " + Apellidos);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Guardando " + dni + " "+ Nombre + " " + Apellidos));
        return null;
    }
}
