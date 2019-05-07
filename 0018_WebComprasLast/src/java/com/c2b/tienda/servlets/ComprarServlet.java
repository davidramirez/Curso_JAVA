/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.tienda.servlets;

import com.c2b.tienda.dominio.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "ComprarServlet", urlPatterns = {"/comprar"}, loadOnStartup = 0)
public class ComprarServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ArrayList<Producto> productos = new ArrayList();
        productos.add(new Producto(1, "Zapatos", "Zapato de invierno muy cómodo", 20, 29.99));
        productos.add(new Producto(2, "Portatil Lenovo", "Core i5, 8GB de RAM, 500GB", 8, 499.99));
        productos.add(new Producto(3, "Lámpara", "De lectura", 15, 14.99));
        productos.add(new Producto(4, "Televisión", "32 pulgadas FullHD", 5, 249.99));
        
        this.getServletContext().setAttribute("productos", productos);
        System.out.println("Productos cargados....");
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
        String paramId = request.getParameter("producto");
        int id=0;
        if(paramId == null || paramId.trim().length() == 0){
            request.setAttribute("error", "No hay ningún producto seleccionado");
            request.getRequestDispatcher("compras.jsp").forward(request, response);
        }else{
            //comprobar que es numérico
            try{
                id = Integer.parseInt(paramId);
            }catch(NumberFormatException e){
                //No numerico
                request.setAttribute("error", "El ID de producto dado es incorrecto");
                request.getRequestDispatcher("compras.jsp").forward(request, response);
            }
        }
        
        ArrayList<Producto> productos = (ArrayList<Producto>) this.getServletContext().getAttribute("productos");
        
        Producto prod = null;
        for(Producto p:productos){
            if(p.getId()==id){
                prod = p;
            }
        }
        
        if(prod == null){
            //no se ha encontrado el producto
            request.setAttribute("error", "No se ha encontrado el producto con el ID dado");
            request.getRequestDispatcher("compras.jsp").forward(request, response);
        }
        
        //Comprobar disponibilidad
        if(prod.getStock()>0){
            Object o = request.getSession().getAttribute("carro");
            HashMap<Producto,Integer> carro;
            Double total = 0.0;
            if(o == null){
                //crear el carro y la var double total
                carro = new HashMap();
                request.getSession().setAttribute("carro", carro);
                request.getSession().setAttribute("total", total);
            }else{
                carro = (HashMap) o;
                total = (Double) request.getSession().getAttribute("total");
            }
            
            //Si el carro ya lo tiene, sumar
            if(carro.containsKey(prod)){
                carro.put(prod, carro.get(prod)+1);
            }else{
                //Añadir
                carro.put(prod, 1);
            }
            //restar stock y sumar total
            prod.restarStock();
            total += prod.getPrecio();
            
            //Modificar el total en la sesion
            request.getSession().setAttribute("total", total);
            //redireccionar al carrito
            request.getRequestDispatcher("carro.jsp").forward(request, response);
            
            
        }else{
            request.setAttribute("error", "El producto solicitado ya no está disponible");
            request.getRequestDispatcher("compras.jsp").forward(request, response);
        }
    }

   
}
