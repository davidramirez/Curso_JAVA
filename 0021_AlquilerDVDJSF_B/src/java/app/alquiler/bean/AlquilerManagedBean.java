/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.alquiler.bean;

import app.alquiler.modelo.DVDItem;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "alquiler")
@SessionScoped
public class AlquilerManagedBean implements Serializable {

    @Inject
    private AppManagedBean appManagedBean;
    private DVDItem dvd = new DVDItem();

    private boolean modoNuevo = false;
    private int idViejo;

    /**
     * Creates a new instance of AlquilerManagedBean
     */
    public AlquilerManagedBean() {

    }

    public void setAppManagedBean(AppManagedBean appManagedBean) {
        this.appManagedBean = appManagedBean;
    }

    public Collection<DVDItem> getLista() {
        return appManagedBean.getDvds().values();
    }

    public DVDItem getDvd() {
        return dvd;
    }

    public void setDvd(DVDItem dvd) {
        this.dvd = dvd;
    }

    public boolean isModoNuevo() {
        return modoNuevo;
    }

    public String alquilar(int id) {

        DVDItem d = this.buscar(id);
        if (d != null) {
            if (d.isAlquilado()) {
                //Error
            } else {
                d.setAlquilado(true);
            }
        }//else error

        return null;
    }

    public String devolver(int id) {
        DVDItem d = this.buscar(id);

        if (d != null) {
            if (d.isAlquilado()) {
                d.setAlquilado(false);
            } else {
                //Error
            }
        }//else error

        return null;
    }

    private DVDItem buscar(int id) {
        return appManagedBean.getDvds().get(id);
    }

    //para llamar desde boton
    public String altaDVD() {
        //preparo los datos del bean para hacer un alta
        this.modoNuevo = true;
        this.dvd = new DVDItem();
        return "crearDVD";
    }

    //para llamar desde boton
    public String modificarDVD(int id) {
        this.modoNuevo = false;
        this.dvd = this.buscar(id);
        this.idViejo = this.dvd.getId();
        return "crearDVD";//Se usa la misma página para las acciones de modificar y crear
    }

    //se le llama desde el formulario de guardado/modificación
    public String crearDVD() {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (modoNuevo) {
            if (this.buscar(dvd.getId()) == null) {
                appManagedBean.getDvds().put(dvd.getId(), dvd);
                dvd = new DVDItem();
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DVD añadido", "Se ha añadido el nuevo DVD con éxito"));//id del componente al que se asociaría y mensaje
            }else{
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id repetido", "El id proporcionado ya existe"));//id del componente al que se asociaría y mensaje
                return "crearDVD";
            }
        } else {
            if(this.buscar(dvd.getId()) == null){
                appManagedBean.getDvds().remove(this.idViejo);
                appManagedBean.getDvds().put(dvd.getId(), dvd);
                dvd = new DVDItem();
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DVD modificado", "Se ha modificado el DVD con éxito"));
            }else if(dvd.getId() == idViejo){
                appManagedBean.getDvds().put(idViejo, dvd);
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DVD modificado", "Se ha modificado el DVD con éxito"));
            }
            else{
                fc.addMessage("ERROR", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id repetido", "El id proporcionado ya existe"));
                return "crearDVD";
            }
        }

        return "alquiler";
    }
}
