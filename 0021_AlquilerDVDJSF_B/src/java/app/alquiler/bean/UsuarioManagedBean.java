/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.alquiler.bean;

import app.alquiler.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author david
 */
@Named(value = "usuario")
@SessionScoped
public class UsuarioManagedBean implements Serializable{

    private Usuario usuario = new Usuario();
    private Usuario usuarioLogueado = null;
    
    private String idioma;
    
    @Inject
    private AppManagedBean appManagedBean;
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
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
        //this.idioma="es";//coger el de la aplicacion
    }
    
    public String ponerIdioma(String idioma){
        this.idioma = idioma;
        return null;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setAppManagedBean(AppManagedBean appManagedBean) {
        this.appManagedBean = appManagedBean;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }
    
    public String loguearUsuario(){
        System.out.println(this.usuario);
        if(appManagedBean.getUsuarios().contains(this.usuario)){
            this.usuarioLogueado = this.usuario;
            return null;//Me quedo en la página que esté
        }else{
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario incorrecto", "El nombre de usuaro o la contraseña no son correctos"));
            return null;
        }
    }
    
    public String cerrarSesion(){
        this.usuarioLogueado = null;
        return null;
    }
    
}
