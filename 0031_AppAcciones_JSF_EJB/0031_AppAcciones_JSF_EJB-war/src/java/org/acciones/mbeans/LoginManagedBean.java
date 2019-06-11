/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.mbeans;


import com.sun.faces.util.MessageFactory;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.acciones.servicios.LoginServiceLocal;
import org.acciones.servicios.excepciones.AccionistaException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
//@Named(value = "login")
//@RequestScoped
@ManagedBean(name = "login")
@RequestScoped
public class LoginManagedBean {

    private String usuario;
    private String clave;

    //@Inject
    @ManagedProperty(value = "#{sesion}")
    private SesionManagedBean sesionManagedBean;

    @EJB
    private LoginServiceLocal loginServiceLocal;

    public LoginManagedBean() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSesionManagedBean(SesionManagedBean sesionManagedBean) {
        this.sesionManagedBean = sesionManagedBean;
    }

    public String login() {
        FacesContext fc = FacesContext.getCurrentInstance();
//        System.out.println("messagebundle: "+ fc.getApplication().getMessageBundle());
//        ResourceBundle bundle2 = ResourceBundle.getBundle("javax.faces.Messages", fc.getViewRoot().getLocale());
//        System.out.println("bundle: " + bundle2);
        
        //FacesMessage f = MessageFactory.getMessage(fc, "ejemplo", FacesMessage.SEVERITY_ERROR, null);
        
        //ResourceBundle bundle = fc.getApplication().evaluateExpressionGet(fc, "#{msg}", ResourceBundle.class);
        try {
            sesionManagedBean.setUsuario(loginServiceLocal.autenticarAccionista(usuario, clave));
            return "misacciones";
        } catch (BDException ex) {
            fc.addMessage(null,MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_FATAL, null));// new FacesMessage(FacesMessage.SEVERITY_FATAL, bundle.getString(ex.getMesssageKey()), bundle.getString(ex.getMesssageKey())));
            return null;
        } catch (AccionistaException ex) {
            fc.addMessage(null, MessageFactory.getMessage(fc, ex.getMesssageKey(), FacesMessage.SEVERITY_ERROR, null));//new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(ex.getMesssageKey()), bundle.getString(ex.getMesssageKey())));
            return null;
        }
    }
}
