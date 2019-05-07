/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.compras.web.filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebFilter(filterName = "AutenticacionFilter", urlPatterns = {"/*"})
public class AutenticacionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Iniciando el filtro de autenticacion..........");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Interceptado por el filtro de autenticacion..........");

        HttpServletRequest peticion = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
//        System.out.println("Peticion a " + peticion.getRequestURI());
        
        boolean permitir = false;
        //Permitir peticiones al login.html, al inicio (que es login.html) y al servlet que lo gestiona (login)
        if (peticion.getRequestURI().equals("/compras/login.html") || peticion.getRequestURI().equals("/compras/") || peticion.getRequestURI().equals("/login")) {

            if (peticion.getSession().getAttribute("usuario") != null) {
                //hay alguien logueado, dejar entrar
                permitir = true;
                System.out.println("true");
            }

            if (permitir) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect("login.html");
            }
        }else{
            chain.doFilter(request, response);
        }

        System.out.println("Te he interceptado a la vuelta..........");
    }

    @Override
    public void destroy() {
        System.out.println("Destruyendo el filtro de autenticacion..........");
    }

}
