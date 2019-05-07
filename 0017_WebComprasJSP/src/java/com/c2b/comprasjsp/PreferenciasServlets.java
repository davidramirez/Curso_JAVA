/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.comprasjsp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "PreferenciasServlets", urlPatterns = {"/preferencias"})
public class PreferenciasServlets extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //leer parámetro
        String paramColor = request.getParameter("color");
        if(paramColor == null){
            paramColor = "blue";
        }
        
        Cookie c = new Cookie("color", paramColor);
        c.setMaxAge(3000);
        response.addCookie(c); 
        //cookie a response antes de empezar el body (para que vaya a la cabecera
        
        
        //Coger de donde viene y redirigir
        //request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        response.sendRedirect("index.jsp");
    }

}
