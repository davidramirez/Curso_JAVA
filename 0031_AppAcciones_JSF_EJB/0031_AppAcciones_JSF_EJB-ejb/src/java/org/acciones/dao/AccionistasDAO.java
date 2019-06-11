/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.acciones.modelo.Accionista;

/**
 *
 * @author david
 */
@Stateless
public class AccionistasDAO implements AccionistasDAOLocal {

    @Override
    public List<Accionista> listarAccionistas(Connection conn) throws SQLException {
        String consulta = "SELECT * FROM accionistas";
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(consulta);

        List<Accionista> lista = new ArrayList<Accionista>();
        while (rs.next()) {
            lista.add(new Accionista(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("CLAVE")));
        }

        return lista;
    }

    @Override
    public Accionista autenticarAccionista(Connection conn, String nombre, String clave) throws SQLException {
        String consulta = "SELECT * FROM accionistas WHERE nombre = ? AND clave = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, nombre);
        pst.setString(2, clave);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return new Accionista(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("CLAVE"));
        }

        return null;
    }
}
