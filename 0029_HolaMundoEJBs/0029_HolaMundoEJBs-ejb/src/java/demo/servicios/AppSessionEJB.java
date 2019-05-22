/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Singleton//Entorno threadsafe
//@Stateless
public class AppSessionEJB implements AppSessionEJBLocal {

    private int contador = 0;

    public AppSessionEJB() {
        System.out.println("Instanciando el ejb stateless appsessionEJB" + this);
    }
    
    
    
    @Override
    public void incrementar() {
            contador++;
    }
    
//    @Override //Prueba stateless
//    public void incrementar() {
//        try {
//            System.out.println("atiende " + this);
//            contador++;
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AppSessionEJB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public int getContador() {
        return contador;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
