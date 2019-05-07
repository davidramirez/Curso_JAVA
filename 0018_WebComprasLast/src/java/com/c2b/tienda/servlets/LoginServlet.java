/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.tienda.servlets;

import com.c2b.tienda.dominio.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


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
        
        String pass = request.getParameter("pass");
        String usuario = request.getParameter("nombre");
        
        if(pass == null || pass.trim().length() == 0 || usuario == null || usuario.trim().length() == 0){
            pass = "";
            usuario = "";
        }
        
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios.add(new Usuario("david", "1234"));
        listaUsuarios.add(new Usuario("pedro", "1234"));
        
        Usuario u = new Usuario(usuario, pass);
        
        if(listaUsuarios.contains(u)){
            request.getSession().setAttribute("usuario", u);
//            System.out.println("usuario guardado en sesion");
//            System.out.println(request.getSession().getAttribute("usuario"));
            //request.getRequestDispatcher("listaProductos").forward(request, response);
            response.sendRedirect("compras.jsp");
        }else{
            request.setAttribute("noValido", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
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
