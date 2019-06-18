/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.mbeans;

//import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.acciones.modelo.Accionista;

/**
 *
 * @author david
 */
//@Named(value = "sesion")
//@SessionScoped
@ManagedBean(name = "sesion")
@SessionScoped
public class SesionManagedBean implements Serializable {
    
    private Accionista usuario;
    
    private String idioma;

    /**
     * Creates a new instance of SesionManagedBean
     */
    public SesionManagedBean() {
        System.out.println("instanciando sesionmbean");
        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String idioma = req.getHeader("Accept-Language");
        System.out.println(idioma);
        int es = idioma.indexOf("es");
        int en = idioma.indexOf("en");
        
        if(es < 0)
            this.idioma = "en";//Por defecto si ninguno de los dos es pedido
        else if(en < 0)
            this.idioma = "es";
        else if(es < en)
            this.idioma = "es";
        else
            this.idioma = "en";
    }
    
    public String ponerIdioma(String idioma){
        this.idioma = idioma;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es", "ES"));
        return null;
    }

    public String getIdioma() {
        return idioma;
    }

    public Accionista getUsuario() {
        return usuario;
    }

    public void setUsuario(Accionista usuario) {
        this.usuario = usuario;
    }
    
    public String logOut(){
        this.usuario = null;
        return null;
    }
    
    private String eMsg;
    
    public void setErrorMessage(String msg){
        System.out.println("seterrormessage en mbean sesion");
        this.eMsg = msg;
    }
    
    public String getErrorMessage(){
        System.out.println("geterrormessage en mbean sesion");
        if(this.eMsg != null){
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, this.eMsg, this.eMsg));
            this.eMsg = null;
        }
        return "";
    }
}
