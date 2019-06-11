/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios.scheduled;

import javax.ejb.Local;

/**
 *
 * @author david
 */
@Local
public interface ActualizarPreciosServiceLocal {
    
    public void myTimer();
    public void actualizarPrecios();
}
