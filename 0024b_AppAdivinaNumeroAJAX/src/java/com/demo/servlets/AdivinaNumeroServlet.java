/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "AdivinaNumeroServlet", urlPatterns = {"/adivina"})
public class AdivinaNumeroServlet extends HttpServlet {
    
    private int numero = 2;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //obtener el parámetro de la petición
        String num = request.getParameter("numero");
        String resultado = "Inténtalo de nuevo!";
        
        if(num != null && num.trim().length()>0 && num.matches("[0-9]*")){
            int n = Integer.parseInt(num);
            
            if(n == numero)
                resultado = "Has acertado!";
        }
        
        response.setHeader("access-control-allow-origin", "*");
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(resultado);
        }
    }

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
