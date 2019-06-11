/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import java.util.List;
import javax.ejb.Local;
import org.acciones.modelo.Accion;
import org.acciones.modelo.AccionDeAccionista;
import org.acciones.servicios.excepciones.AccionException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@Local
public interface AccionesServiceLocal {
    
    public List<Accion> listarAcciones() throws BDException;
    public List<AccionDeAccionista> listarAccionesAccionista(int idAccionista) throws BDException;
    public double comprarAccion(int idAccion, int idAccionista, int cantidad) throws BDException, AccionException;
}
