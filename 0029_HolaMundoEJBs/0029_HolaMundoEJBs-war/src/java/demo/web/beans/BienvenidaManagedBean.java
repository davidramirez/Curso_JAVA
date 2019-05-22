/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web.beans;

import demo.servicios.SaludadorSessionBeanLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author david
 */
@Named(value = "bienvenidaManagedBean")
@RequestScoped
public class BienvenidaManagedBean {

    @EJB
    private SaludadorSessionBeanLocal saludador;
    
    private String nombre = "David";
    /**
     * Creates a new instance of BienvenidaManagedBean
     */
    public BienvenidaManagedBean() {
    }
    
    public String getSaludo(){
        return saludador.saludar(nombre);
    }
    
}
