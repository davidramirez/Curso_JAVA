/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import javax.ejb.Local;
import org.acciones.modelo.Accionista;
import org.acciones.servicios.excepciones.AccionistaException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@Local
public interface LoginServiceLocal {
    public Accionista autenticarAccionista(String nombre, String clave) throws BDException, AccionistaException;
}
