/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.web.managedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Named(value = "login")
@RequestScoped
public class LoginBean {

    @Size(min = 5, max = 15, message = "Tamaño incorrecto password")
    private String password;
    
    @Size(min = 5, max = 15, message = "Tamaño incorrecto confirmación")
    private String confirm;
    
    private String status = "";
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //Validación entre campos, validación cruzada
    //Aseguraa que este método devuelva true
    //Se ejecuta si o si
    @AssertTrue(message = "Las claves son diferentes")
    public boolean arePasswordsEqual(){
        return password.equals(confirm);
    }
    
    public void almacenarNuevaPassword(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La nueva clave se ha guardado"));
    }
}
