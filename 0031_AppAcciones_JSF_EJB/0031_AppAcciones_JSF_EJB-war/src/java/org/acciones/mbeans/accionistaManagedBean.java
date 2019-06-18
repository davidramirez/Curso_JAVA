/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.acciones.modelo.AccionDeAccionista;
import org.acciones.servicios.AccionesServiceLocal;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
//@Named(value = "accionista")
//@RequestScoped
@ManagedBean(name = "accionista")
@ViewScoped
public class accionistaManagedBean implements Serializable{

    private List<AccionDeAccionista> listaAccionesAccionista;

    @EJB
    private AccionesServiceLocal accionesServiceLocal;

    //@Inject
    @ManagedProperty(value = "#{sesion}")
    private SesionManagedBean miSesionManagedBean;

    public accionistaManagedBean() {
    }

    @PostConstruct
    public void getListado() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle bundle = fc.getApplication().evaluateExpressionGet(fc, "#{msg}", ResourceBundle.class);

        try {
            this.listaAccionesAccionista = accionesServiceLocal.listarAccionesAccionista(miSesionManagedBean.getUsuario().getId());
        } catch (BDException ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, bundle.getString(ex.getMesssageKey()), bundle.getString(ex.getMesssageKey())));
            this.listaAccionesAccionista = new ArrayList<AccionDeAccionista>();
        }
    }

    public void setMiSesionManagedBean(SesionManagedBean miSesionManagedBean) {
        this.miSesionManagedBean = miSesionManagedBean;
    }

    public List<AccionDeAccionista> getListaAccionesAccionista() {
        return listaAccionesAccionista;
    }

    public void setAccionesServiceLocal(AccionesServiceLocal accionesServiceLocal) {
        this.accionesServiceLocal = accionesServiceLocal;
    }

}
