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
import org.acciones.modelo.Accionista;
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
    public Accion getAccionPorId(int idAccion) throws BDException, AccionException;
    public void modificarAccion(Accion accion) throws BDException, AccionException;
    public void modificarAccionPessimistic(int idAccion, double valor) throws BDException, AccionException;
    
    public double getPrecioAccionPorNombre(String nombreAccion) throws BDException, AccionException;
    
    public List<Accionista> listarAccionistas() throws BDException;
    public List<Accionista> listarAccionistasSinId(int idNoListar) throws BDException;
    public double venderAccionAAccionista(int idAccionistaVende, int idAccionistaCompra, int idAccion, int cantidad) throws BDException, AccionException;
    
    public AccionDeAccionista buscarAcciondeAccionistaPorId(int idAccionista, int idAccion);
}
