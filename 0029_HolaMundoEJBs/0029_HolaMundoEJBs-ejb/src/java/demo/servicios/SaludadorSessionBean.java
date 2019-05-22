/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class SaludadorSessionBean implements SaludadorSessionBeanLocal {

    @EJB
    private AppSessionEJBLocal appService;
    
    @Override
    public String saludar(String nombre) {
        System.out.println("appService " + appService);
        appService.incrementar();
        return "¡¡Hola " + nombre + " !! " + appService.getContador();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
