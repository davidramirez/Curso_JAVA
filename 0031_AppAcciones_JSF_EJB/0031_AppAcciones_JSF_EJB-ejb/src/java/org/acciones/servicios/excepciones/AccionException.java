/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios.excepciones;

import javax.ejb.ApplicationException;
import javax.xml.ws.WebFault;

/**
 *
 * @author david
 */
@ApplicationException(rollback = true)
@WebFault
public class AccionException extends MiExcepcion{
    
    public AccionException(String msg, String messageKey) {
        super(msg, messageKey);
    }
}
