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
@WebServlet(name = "ListaCarroServlet", urlPatterns = {"/listacarro"})
public class ListaCarroServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //mirar si pide delete = 1 y borrar carro
            String del = request.getParameter("delete");

            boolean carroVacio = false;
            LinkedHashMap<String, Integer> carro = null;

            Object o = request.getSession().getAttribute("carro");
            //Sacar el carro de la sesion si existe
            if (o == null) {
                carroVacio = true;
            } else {
                carro = (LinkedHashMap<String, Integer>) o;
                if(carro.isEmpty()){
                    carroVacio = true;
                }
            }

            //mirar si se pide borrar algo
            if (del != null && del.trim().length() > 0) {
                if (del.equals("1")) {
                    request.getSession().removeAttribute("carro");
                } else {
                    //si delete no es borrar todo el carro, buscar el elemento en el map y borrarlo
                    if (!carroVacio) {
                        carro.remove(del);
                        //si se ha vaciado el carro, actualiza el booleano
                        if (carro.size() == 0) {
                            carroVacio = true;
                        }
                    }
                }
            }

            out.println("<!doctype html>\n"
                    + "<html lang=\"en\">\n"
                    + "    <head>\n"
                    + "        <!-- Required meta tags -->\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                    + "\n"
                    + "        <!-- Bootstrap CSS -->\n"
                    + "        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
                    + "\n"
                    + "        <title>Carro de la tienda</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <ul class=\"nav nav-tabs\">\n"
                    + "            <li class=\"nav-item\">\n"
                    + "                <a class=\"nav-link\" href=\"compras.html\">Ir a comprar</a>\n"
                    + "            </li>\n"
                    + "            <li class=\"nav-item\">\n"
                    + "                <a class=\"nav-link active\" href=\"listacarro\">Ir al carro</a>\n"
                    + "            </li>\n"
                    + "        </ul>\n"
                    + "\n"
                    + "        <div class=\"container\">\n"
                    + "            <h1>Tu carro de la compra</h1>");

            //Coger el carro de la sesion. si esta vacio deccir que no hay nada
            //Crearlo si no existe
            if (carroVacio) {
                out.println("<div class=\"alert alert-warning\">Esto está vacío, <a href=\"compras.html\">ve a comprar algo</div>");
            } else {

                out.println("<ul class=\"list-group\">");
                for (String s : carro.keySet()) {
                    out.println("<li class=\"list-group-item d-flex justify-content-between align-items-center\">" + s
                            + "<span class=\"badge badge-primary badge-pill\">" + carro.get(s)
                            + "</span>"
                            + "<a class='btn btn-outline-danger' href='listacarro?delete=" + s + "'>Eliminar elemento</a></li>");
                }
                out.println("</ul>");
                out.println("<a class=\"btn btn-danger mt-1 d-block\" href=\"listacarro?delete=1\">Vaciar carro</a>");
            }

            out.println("</div>\n"
                    + "\n"
                    + "        <!-- Optional JavaScript -->\n"
                    + "        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n"
                    + "        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n"
                    + "    </body>\n"
                    + "</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
