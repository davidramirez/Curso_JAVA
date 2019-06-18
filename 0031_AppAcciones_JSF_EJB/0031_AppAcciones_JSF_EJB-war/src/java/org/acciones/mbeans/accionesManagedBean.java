/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.mbeans;

import com.sun.faces.util.MessageFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.acciones.modelo.Accion;
import org.acciones.servicios.AccionesServiceLocal;
import org.acciones.servicios.excepciones.AccionException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
//@Named(value = "acciones")
//@RequestScoped
@ManagedBean(name = "acciones")
@ViewScoped
//@SessionScoped
public class accionesManagedBean implements Serializable{

    @EJB
    private AccionesServiceLocal accionesServiceLocal;
    //@Inject
    @ManagedProperty(value = "#{sesion}")
    private SesionManagedBean sesion;

    private int cantidad;
    
    private boolean modoEdicion = false;
    private Accion accionEditar;

    public accionesManagedBean() {
    }

    public List<Accion> getListaAcciones() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle bundle = fc.getApplication().evaluateExpressionGet(fc, "#{msg}", ResourceBundle.class);

        try {
            return accionesServiceLocal.listarAcciones();
        } catch (BDException ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, bundle.getString(ex.getMesssageKey()), bundle.getString(ex.getMesssageKey())));
            return new ArrayList<Accion>();
        }
    }

    public void setAccionesServiceLocal(AccionesServiceLocal accionesServiceLocal) {
        this.accionesServiceLocal = accionesServiceLocal;
    }

    public void setSesion(SesionManagedBean sesion) {
        this.sesion = sesion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String btnComprarAccion(Accion accion) {
        FacesContext fc = FacesContext.getCurrentInstance();

        try {
            double valorCompra = accionesServiceLocal.comprarAccion(accion.getId(), sesion.getUsuario().getId(), this.cantidad);
            fc.addMessage(null, MessageFactory.getMessage(fc, "accCompraOk", FacesMessage.SEVERITY_INFO, new Object[]{this.cantidad+"", accion.getNombre(), valorCompra+""}));
        } catch (BDException ex) {
            fc.addMessage(null, MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_FATAL, new Object[]{accion.getId()}));
        } catch (AccionException ex) {
            fc.addMessage(null, MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_ERROR, new Object[]{accion.getId()}));
        }

        this.cantidad = 0;
        return null;
    }
    
    public void editarAccion(int idAccion){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            this.accionEditar = accionesServiceLocal.getAccionPorId(idAccion);
            this.modoEdicion = true;
        } catch (BDException ex) {
            fc.addMessage(null, MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_FATAL, new Object[]{idAccion}));
        } catch (AccionException ex) {
            fc.addMessage(null, MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_ERROR, new Object[]{idAccion}));
        }
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    public Accion getAccionEditar() {
        return accionEditar;
    }

    public void grabarAccion(){
        System.out.println("llama grabar++++++++++++++++++++");
        FacesContext fc = FacesContext.getCurrentInstance();
        try{
            accionesServiceLocal.modificarAccion(accionEditar);
            this.modoEdicion = false;
            this.accionEditar = null;
            fc.addMessage(null, MessageFactory.getMessage(fc, "accModificarOk", FacesMessage.SEVERITY_INFO));
        } catch (BDException ex) {
            fc.addMessage(null, MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_FATAL, null));
        } catch (AccionException ex) {
            fc.addMessage(null, new FacesMessage(ex.getMessage()));//TODO MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_ERROR, null));
        }
    }
}
