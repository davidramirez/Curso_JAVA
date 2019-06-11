/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios.scheduled;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.acciones.modelo.Accion;
import org.acciones.servicios.AccionesServiceLocal;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@Stateless
public class ActualizarPreciosService implements ActualizarPreciosServiceLocal {

    private static Logger log = Logger.getLogger("ActualizarPreciosService");

    @PersistenceContext
    private EntityManager em;

    @EJB
    private AccionesServiceLocal accionesService;

    //@Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*/10", second = "0")
    @Override
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    //@Schedule(dayOfWeek = "*", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*/3", second = "0")
    @Override
    public void actualizarPrecios() {
        try {
            System.out.println("Actualizando precios");
            //Aprovecho el listado para tener los ids de las acciones
            List<Accion> acciones = accionesService.listarAcciones();

            for (Accion a : acciones) {
                double multiplicador = Math.random() / 2 + 0.75;
                double valor = a.getValor();
                valor = Math.round((valor * multiplicador) * 1000) / 1000.0;
                a.setValor(valor);
            }

        } catch (BDException ex) {
            log.severe("Al listar las acciones disponibles. Error de BD. " + ex.getMessage());
        } catch (Exception ex) {
            log.severe("Al actualizar los precios de las acciones. Error de BD. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
