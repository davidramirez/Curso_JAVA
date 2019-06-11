/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.web.filtros;

import com.sun.faces.util.MessageFactory;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import org.acciones.mbeans.SesionManagedBean;

/**
 *
 * @author david
 */
public class UsuarioLogueadoPhaseListener implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        //System.out.println("Fase " + event.getPhaseId());
        if (event.getPhaseId().equals(this.getPhaseId())) {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
            String url = req.getRequestURI();
            //System.out.println("Petición"+url);

            SesionManagedBean miSesionManagedBean = fc.getApplication().evaluateExpressionGet(fc, "#{sesion}", SesionManagedBean.class);

            //Comprobar el patron de la url
            if (url.matches(".*user/.*")) {
                //System.out.println("URL encaja");
                //Comprobaar que hay un usuario logueado
                if (miSesionManagedBean.getUsuario() == null) {
                    //ResourceBundle bundle = fc.getApplication().evaluateExpressionGet(fc, "#{msg}", ResourceBundle.class);
                    //String msg = bundle.getString("accesoDenegado");
                    //System.out.println(msg);
                    //fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
                    fc.addMessage(null, MessageFactory.getMessage(fc, "accesoDenegado", FacesMessage.SEVERITY_ERROR, null));

                    NavigationHandler nh = fc.getApplication().getNavigationHandler();
                    System.out.println("navigation handler" + nh);
                    nh.handleNavigation(fc, null, "login");
                    fc.renderResponse();
                }
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
