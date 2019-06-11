/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.mbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
public class accionesManagedBean {

    @EJB
    private AccionesServiceLocal accionesServiceLocal;
    //@Inject
    @ManagedProperty(value = "#{sesion}")
    private SesionManagedBean sesion;

    private int cantidad;

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
        ResourceBundle bundle = fc.getApplication().evaluateExpressionGet(fc, "#{msg}", ResourceBundle.class);

        try {
            double valorCompra = accionesServiceLocal.comprarAccion(accion.getId(), sesion.getUsuario().getId(), this.cantidad);
            String msg = bundle.getString("accCompraOk");
            msg = msg.replace("{0}", this.cantidad + "");
            msg = msg.replace("{1}", accion.getNombre());
            msg = msg.replace("{2}", valorCompra + "");
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        } catch (BDException ex) {
            String msg = bundle.getString(ex.getMesssageKey()).replace("{0}", accion.getId() + "");
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
        } catch (AccionException ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(ex.getMesssageKey()), bundle.getString(ex.getMesssageKey())));
        }

        this.cantidad = 0;
        return null;
    }

}
