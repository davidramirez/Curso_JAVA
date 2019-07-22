/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsa.web.beans;

import com.bolsa.dominio.Accion;
import com.bolsa.excepciones.BrokerException;
import com.bolsa.servicios.BrokerServiceLocal;
import com.sun.faces.util.MessageFactory;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author david
 */
@Named(value = "accionesMB")
@ViewScoped
public class AccionesManagedBean implements Serializable{
    
    private Accion nuevaAccion;
    
    private Accion modificarAccion;
    private boolean modoEdicion;
    
    @EJB
    private BrokerServiceLocal brokerService;

    /**
     * Creates a new instance of AccionesManagedBean
     */
    public AccionesManagedBean() {
    }

    public Accion getNuevaAccion() {
        if(this.nuevaAccion == null)
            this.nuevaAccion = new Accion();
        return nuevaAccion;
    }

    public Accion getModificarAccion() {
        return modificarAccion;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }
    
    public List<Accion> getListaAcciones(){
        return brokerService.getAllAcciones();
    }
    
    public void btnGuardarNuevo(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try{
            brokerService.addAccion(nuevaAccion);
            this.nuevaAccion = new Accion();
        } catch (Exception e){
            fc.addMessage(null, MessageFactory.getMessage("error.inesperado"));
            e.printStackTrace();
        }
    }
    
    public void btnPrepararModificar(int idAccion){
        this.modoEdicion = true;
        this.modificarAccion = brokerService.buscaAccionPorId(idAccion);
    }
    
    public void btnGuardarModificacion(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            brokerService.updateAccion(this.modificarAccion);
            this.modoEdicion = false;
            this.modificarAccion = null;
        } catch (BrokerException ex) {
            Logger.getLogger(AccionesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            fc.addMessage(null, MessageFactory.getMessage("error.inesperado"));
            e.printStackTrace();
        }
    }
    
    public void btnBorrar(int idAccion){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            brokerService.deleteAccion(idAccion);
            fc.addMessage(null, MessageFactory.getMessage("accion.borrada"));
        } catch (BrokerException ex) {
            Logger.getLogger(AccionesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            fc.addMessage(null, MessageFactory.getMessage("error.inesperado"));
            e.printStackTrace();
        }
        
    }
}
