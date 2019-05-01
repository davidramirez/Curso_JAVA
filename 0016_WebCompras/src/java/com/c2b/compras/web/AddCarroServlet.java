/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.compras.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "AddCarroServlet", urlPatterns = {"/addCarro"})
public class AddCarroServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener el parámetro
        String producto = request.getParameter("producto");
        if(producto == null || producto.trim().length() == 0){
            //TODO No has comprado nada
            //producto = "no has comprado nada";
            //request.getRequestDispatcher("compras.html").forward(request, response);
            response.sendRedirect("compras.html");
            return;
        }
        
        //Get el map de la sesion
        LinkedHashMap<String,Integer> carro;
        //Crearlo si no existe
        if(request.getSession().getAttribute("carro") == null){
            carro = new LinkedHashMap<String,Integer>();
            request.getSession().setAttribute("carro", carro);
        }else{
            carro = (LinkedHashMap<String,Integer>) request.getSession().getAttribute("carro");
        }
        
        //meter el producto (añadir o sumar)
        if(carro.containsKey(producto)){
            Integer i = carro.get(producto);
            carro.put(producto, ++i);
        }else{
            carro.put(producto, 1);
        }
        
        //Debug a consola
        for(String s:carro.keySet()){
            System.out.println("producto: "+ s +" "+ carro.get(s));
        }
        
        //request.getRequestDispatcher("compras.html").forward(request, response);
        response.sendRedirect("compras.html");
    }

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
        processRequest(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
