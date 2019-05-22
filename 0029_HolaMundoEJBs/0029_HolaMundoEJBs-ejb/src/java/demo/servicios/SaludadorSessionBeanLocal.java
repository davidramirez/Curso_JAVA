/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author david
 */
@Local
@Remote
public interface SaludadorSessionBeanLocal {
    
    public String saludar(String nombre);
    
}
