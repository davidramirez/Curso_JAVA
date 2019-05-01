/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
public class SaludoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("Iniciando el servlet saludo...................");
    }

    @Override
    public void destroy() {
        System.out.println("Cerrando el servlet.........");
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Atendiendo una peticion get");
        this.doPost(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Atendiendo una peticion post");
        
        
        String paramNombre = req.getParameter("nombre");
        
        if(paramNombre == null){
            paramNombre = "Amigo";
        }
        
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {//try with resource, cuando se sale del try se cierra
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Saludo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaludoServlet at " + req.getContextPath() + "</h1>");
            out.println("<p>Hola " + paramNombre + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

    
    
}
