/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.web.filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationCase;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.acciones.mbeans.SesionManagedBean;

/**
 *
 * @author david
 */
@WebFilter(filterName = "usuarioLogueado")//, urlPatterns = {"/user/*", "/faces/user/*"})
public class UsuarioLogueadoFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("doFiltro");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        SesionManagedBean sesionMB = (SesionManagedBean) session.getAttribute("sesion");

        //revisar condiciones, que no va
        if (sesionMB == null || sesionMB.getUsuario() == null) {
            String msg = "Acceso denegado. Inicia sesión para acceder.";
            //System.out.println(msg);
            sesionMB.setErrorMessage(msg);
            
            resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Iniciando filtro usuarios logueados");
    }

    @Override
    public void destroy() {
    }

}
