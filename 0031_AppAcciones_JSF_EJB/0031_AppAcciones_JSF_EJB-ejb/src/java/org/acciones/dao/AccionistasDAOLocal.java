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
import org.acciones.modelo.Accionista;

/**
 *
 * @author david
 */
@Local
public interface AccionistasDAOLocal {
    public List<Accionista> listarAccionistas(Connection conn) throws SQLException;
    public Accionista autenticarAccionista(Connection conn, String nombre, String clave) throws SQLException;
}
