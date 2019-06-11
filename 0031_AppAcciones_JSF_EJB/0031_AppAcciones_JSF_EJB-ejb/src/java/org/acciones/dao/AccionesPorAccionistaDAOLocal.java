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
import org.acciones.modelo.AccionDeAccionista;

/**
 *
 * @author david
 */
@Local
public interface AccionesPorAccionistaDAOLocal {
    
    public List<AccionDeAccionista> getAccionesAccionista(Connection conn, int idAccionista) throws SQLException;
    public void guardarCompra(Connection conn, int idAccion, int idAccionista, int cantidad, double valorTotal) throws SQLException;
}
