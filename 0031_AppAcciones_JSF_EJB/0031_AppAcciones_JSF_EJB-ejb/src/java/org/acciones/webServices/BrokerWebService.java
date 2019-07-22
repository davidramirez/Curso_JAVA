/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.webServices;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.acciones.servicios.AccionesService;
import org.acciones.servicios.AccionesServiceLocal;
import org.acciones.servicios.excepciones.AccionException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@WebService(serviceName = "BrokerWebService")
@Stateless()
public class BrokerWebService {

    @EJB
    private AccionesServiceLocal accionesService;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getPrecioAccionPorNombre")
    public double getPrecioAccion(@WebParam(name = "nombreAccion") String nombreAccion) throws BDException, AccionException {
        return accionesService.getPrecioAccionPorNombre(nombreAccion);
    }
}
