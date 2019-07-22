/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsa.web.beans;

import com.bolsa.dominio.Accionista;
import com.bolsa.excepciones.BrokerException;
import com.bolsa.servicios.BrokerServiceLocal;
import com.sun.faces.util.MessageFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author david
 */
@Named(value = "accionistasMB")
@ViewScoped
public class AccionistasManagedBean implements Serializable {

    //inyectar ejb BrokerService
    @EJB
    private BrokerServiceLocal brokerService;
    private List<Accionista> listaAccionistas;
    private Accionista nuevoAccionista;

    private Accionista accionistaModificar;
    private boolean modoEdicion;

    public AccionistasManagedBean() {
    }

    public List<Accionista> getListaAccionistas() {
        this.listaAccionistas = brokerService.getAllAccionistas();

        return listaAccionistas;
    }

    public Accionista getNuevoAccionista() {
        if (nuevoAccionista == null) {
            this.nuevoAccionista = new Accionista();
        }
        return nuevoAccionista;
    }

    public void setNuevoAccionista(Accionista nuevoAccionista) {
        this.nuevoAccionista = nuevoAccionista;
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public Accionista getAccionistaModificar() {
        return accionistaModificar;
    }

    public String btnInsertarAccionista() {
        try {
            this.nuevoAccionista.setClave("1234");
            brokerService.addAccionista(this.nuevoAccionista);
            //this.listaAccionistas.add(nuevoAccionista);
            nuevoAccionista = new Accionista();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error inesperado", "Error inesperado"));
            e.printStackTrace();//excepción inesperada, loguear el problema
        }
        return null;
    }

    public void btnBorrarAccionista(int id) {
        brokerService.deleteAccionista(id);
    }

    public String btnModificarNombreAccionista(Accionista a) {
        try {
            a.setNombre("Maria" + a.getNombre());
            brokerService.updateAccionista(a);
            
        } catch (BrokerException ex) {
            Logger.getLogger(AccionistasManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }

    public void btnEditar(int id) {
        this.modoEdicion = true;
        this.accionistaModificar = brokerService.buscaAccionistaPorId(id);
    }

    public void btnGrabarCambios() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            System.out.println("btngrabarcambios.......");
            brokerService.updateAccionista(this.accionistaModificar);
            this.modoEdicion = false;
            this.accionistaModificar = null;
        } catch (BrokerException ex) {
            fc.addMessage(null, MessageFactory.getMessage(ex.getMessage()));
        } catch (Exception e){
            fc.addMessage(null, MessageFactory.getMessage("error.inesperado"));
            e.printStackTrace();
        }
    }

}
