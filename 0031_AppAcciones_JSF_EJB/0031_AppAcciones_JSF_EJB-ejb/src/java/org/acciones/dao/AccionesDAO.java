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
import org.acciones.modelo.Accion;
import org.acciones.servicios.excepciones.AccionException;

/**
 *
 * @author david
 */
@Stateless
public class AccionesDAO implements AccionesDAOLocal {

    @Override
    public List<Accion> listarAcciones(Connection conn) throws SQLException {
        String consulta = "SELECT * FROM acciones";
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(consulta);

        List<Accion> lista = new ArrayList<Accion>();
        while (rs.next()) {
            lista.add(new Accion(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getDouble("VALOR")));
        }

        return lista;
    }

    @Override
    public Accion buscarId(Connection conn, int id) throws SQLException {
        String consulta = "SELECT * FROM acciones WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return new Accion(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getDouble("VALOR"));
        }

        return null;
    }

    @Override
    public double consultarPrecioAccion(Connection conn, int idAccion) throws SQLException, AccionException {
        String consulta = "SELECT valor FROM acciones WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, idAccion);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getDouble("VALOR");
        }

        throw new AccionException("No se ha encontrado la acción con id "+ idAccion+" en la base de datos", "AccionConsultaPrecioError");
    }

    @Override
    public void actualizarPrecioAccion(Connection conn, int idAccion, double valorNuevo) throws SQLException {
        String consulta = "UPDATE acciones SET valor = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setDouble(1, valorNuevo);
        pst.setInt(2, idAccion);
        pst.executeUpdate();
    }
}
