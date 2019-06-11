/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;
import org.acciones.modelo.Accion;
import org.acciones.servicios.excepciones.AccionException;

/**
 *
 * @author david
 */
@Local
public interface AccionesDAOLocal {
    public List<Accion> listarAcciones(Connection conn) throws SQLException;
    public Accion buscarId(Connection conn, int id) throws SQLException;
    public double consultarPrecioAccion(Connection conn, int idAccion) throws SQLException, AccionException;
    public void actualizarPrecioAccion(Connection conn, int idAccion, double valorNuevo) throws SQLException;
}
