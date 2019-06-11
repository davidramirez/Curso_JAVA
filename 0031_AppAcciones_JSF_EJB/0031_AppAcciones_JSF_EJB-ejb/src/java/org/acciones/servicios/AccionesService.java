/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import org.acciones.dao.AccionesDAOLocal;
import org.acciones.dao.AccionesPorAccionistaDAOLocal;
import org.acciones.modelo.Accion;
import org.acciones.modelo.AccionDeAccionista;
import org.acciones.servicios.excepciones.AccionException;
import org.acciones.servicios.excepciones.BDException;

/**
 *
 * @author david
 */
@Stateless
public class AccionesService implements AccionesServiceLocal {

    private static Logger log = Logger.getLogger("AccionesService");

    @Resource(name = "java:app/jdbc/accionesderbydb")
    //@Resource(name = "java:app/env/accionesclassdb")
    private DataSource ds;

    @EJB
    private AccionesDAOLocal dao;
    @EJB
    private AccionesPorAccionistaDAOLocal daoAccionesAccionista;

    @Override
    public List<Accion> listarAcciones() throws BDException {
        try {
            Connection conn = ds.getConnection();
            List<Accion> l = dao.listarAcciones(conn);
            conn.close();
            return l;

        } catch (SQLException ex) {
            log.severe("Al listar las acciones disponibles. Error de BD. " + ex.getMessage());
            //ex.printStackTrace();
            throw new BDException("Error al listar las acciones. Contacte con el administrador", "accionesListarBDError");
        }
    }

    @Override
    public List<AccionDeAccionista> listarAccionesAccionista(int idAccionista) throws BDException {
        try {
            Connection conn = ds.getConnection();
            List<AccionDeAccionista> l = daoAccionesAccionista.getAccionesAccionista(conn, idAccionista);
            conn.close();
            return l;

        } catch (SQLException ex) {
            log.severe("Al listar las acciones del accionista. Error de BD. " + ex.getMessage());
            //ex.printStackTrace();
            throw new BDException("Error al listar las acciones del accionista. Contacte con el administrador", "AccionesAccionistaListarBDError");
        }
    }

    /**
     * 
     * @param idAccion
     * @param idAccionista
     * @param cantidad
     * @return el coste total de la compra de las acciones
     * @throws BDException 
     * @throws AccionException 
     */
    @Override
    public double comprarAccion(int idAccion, int idAccionista, int cantidad) throws BDException, AccionException {
        try {
            double valorTotal = 0.0;
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            valorTotal = dao.consultarPrecioAccion(conn, idAccion) * cantidad;
            daoAccionesAccionista.guardarCompra(conn, idAccion, idAccionista, cantidad, valorTotal);
            conn.commit();
            conn.close();
            return valorTotal;

        } catch (SQLException ex) {
            log.severe("Al comprar accion "+ idAccion +" el accionista "+ idAccionista + " . Error de BD. " + ex.getMessage());
            //ex.printStackTrace();
            throw new BDException("Error al comprar acciones. Contacte con el administrador", "AccionesComprarBDError");
        }
    }
}
