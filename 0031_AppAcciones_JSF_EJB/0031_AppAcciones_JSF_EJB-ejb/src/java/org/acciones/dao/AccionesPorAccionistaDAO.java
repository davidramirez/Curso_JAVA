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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.acciones.modelo.AccionDeAccionista;

/**
 *
 * @author david
 */
@Stateless
public class AccionesPorAccionistaDAO implements AccionesPorAccionistaDAOLocal {

    @Override
    public List<AccionDeAccionista> getAccionesAccionista(Connection conn, int idAccionista) throws SQLException {
        String consulta = "select * "
                + "from accionesporaccionista inner join acciones "
                + "on accionesporaccionista.id_accion = acciones.id "
                + "where id_accionista = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, idAccionista);
        ResultSet rs = pst.executeQuery();
        List<AccionDeAccionista> lista = new ArrayList<>();

        while (rs.next()) {
            lista.add(new AccionDeAccionista(rs.getInt("ID_ACCION"), rs.getString("NOMBRE"), rs.getInt("ID_ACCIONISTA"), rs.getInt("CANTIDAD"), rs.getDouble("VALOR"), rs.getDouble("VALOR_COMPRA_TOTAL")));
        }

        return lista;
    }

    @Override
    public void guardarCompra(Connection conn, int idAccion, int idAccionista, int cantidad, double valorTotal) throws SQLException {
        String consulta = "SELECT * FROM accionesporaccionista WHERE id_accion = ? AND id_accionista = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, idAccion);
        pst.setInt(2, idAccionista);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            //Coger los datos del registro para actualizarlo
            cantidad += rs.getInt("CANTIDAD");
            valorTotal += rs.getDouble("VALOR_COMPRA_TOTAL");
            consulta = "UPDATE accionesporaccionista SET cantidad = ?, valor_compra_total = ? WHERE id_accion = ? AND id_accionista = ?";
            pst = conn.prepareStatement(consulta);
            pst.setInt(1, cantidad);
            pst.setDouble(2, valorTotal);
            pst.setInt(3, idAccion);
            pst.setInt(4, idAccionista);
            pst.executeUpdate();
        } else {
            //Crear un registro nuevo
            consulta = "INSERT INTO accionesporaccionista VALUES(?,?,?,?)";
            pst = conn.prepareStatement(consulta);
            pst.setInt(1, idAccion);
            pst.setInt(2, idAccionista);
            pst.setInt(3, cantidad);
            pst.setDouble(4, valorTotal);
            pst.executeUpdate();
        }
    }
}
