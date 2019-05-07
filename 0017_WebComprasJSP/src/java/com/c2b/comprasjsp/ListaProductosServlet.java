/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.comprasjsp;

import com.c2b.comprasjsp.dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "ListaProductosServlet", urlPatterns = {"/listaProductos"}, loadOnStartup = 0)
public class ListaProductosServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //ámbito aplicacion, va a estar disponible desde el inicio
        System.out.println("...cargando atributos de aplicación...");
        this.getServletContext().setAttribute("tituloAPP", "Aplicacion ventas");
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
        //Ejemplo de atributos en diferentes ámbitos
        //ambito de petición
        request.setAttribute("usuario1", new Usuario("Luis", "12345"));
        
//        //include de un servlet
//        request.getRequestDispatcher("pag").include(request, response);
//        //sigue despues ejecutandose este método
        
        
        
        List<String> listaProductos = new ArrayList();
        listaProductos.add("Zapato");
        listaProductos.add("Libro");
        listaProductos.add("Televisión");
        listaProductos.add("Ordenador");
        
        //guardar como atributo de petición
        request.setAttribute("productos", listaProductos);
        
        request.getRequestDispatcher("productos.jsp").forward(request, response);
        
    }

    
}
