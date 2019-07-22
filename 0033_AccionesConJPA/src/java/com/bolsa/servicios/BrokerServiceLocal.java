/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsa.servicios;

import com.bolsa.dominio.Accion;
import com.bolsa.dominio.Accionista;
import com.bolsa.excepciones.BrokerException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author david
 */
@Local
public interface BrokerServiceLocal {
    
    public List<Accionista> getAllAccionistas();
    
    public Accionista addAccionista(Accionista a);
    
    public void deleteAccionista(int id);
    
    public Accionista updateAccionista(Accionista a) throws BrokerException;

    public Accionista buscaAccionistaPorId(int id);
    
    
    public List<Accion> getAllAcciones();
    public Accion addAccion(Accion accion);
    public void deleteAccion(int id) throws BrokerException;
    public Accion updateAccion(Accion accion) throws BrokerException;
    public Accion buscaAccionPorId(int id);
            
}
