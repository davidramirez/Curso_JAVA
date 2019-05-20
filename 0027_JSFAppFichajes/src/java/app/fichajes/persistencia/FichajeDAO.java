/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.persistencia;

import app.fichajes.modelo.Fichaje;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class FichajeDAO implements GenericDAO<Fichaje>, Serializable{
    
    private Connection conn;

    public FichajeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void alta(Fichaje entidad) throws SQLException {
        String consulta = "INSERT INTO FICHAJE (ID_EMPLEADO, TIPO, FECHAHORA) VALUES (?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, entidad.getIdEmpleado());
        pst.setString(2, entidad.getTipo()+"");
        pst.setTimestamp(3, Timestamp.valueOf(entidad.getFechaHora()));
        pst.executeUpdate();
    }

    @Override
    public void baja(int id) throws SQLException {
        
    }

    @Override
    public void modifica(Fichaje entidad) throws SQLException {
        
    }

    @Override
    public Fichaje buscarPorId(int id) throws SQLException {
        String consulta = "SELECT * FROM fichaje WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Fichaje(rs.getInt("ID"), rs.getInt("ID_EMPLEADO"), rs.getString("TIPO").charAt(0), rs.getTimestamp("FECHAHORA").toLocalDateTime());
        }
        
        return null;
    }

    @Override
    public List<Fichaje> obtenerTodos() throws SQLException {
        return null;
    }
    
    public Fichaje obtenerUltimoFichajeEmpleado(int idEmpleado) throws SQLException{
        String consulta = "SELECT * FROM fichaje WHERE id_Empleado = ? ORDER BY id DESC fetch first 1 rows only";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, idEmpleado);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Fichaje(rs.getInt("ID"), rs.getInt("ID_EMPLEADO"), rs.getString("TIPO").charAt(0), rs.getTimestamp("FECHAHORA").toLocalDateTime());
        }
        
        return null;
    }
    
    public List<Fichaje> obtenerFichajesEmpleado(int idEmpleado) throws SQLException{
        String consulta = "SELECT * FROM fichaje WHERE id_Empleado = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, idEmpleado);
        ResultSet rs = pst.executeQuery();
        
        List<Fichaje> lista = new ArrayList();
        while(rs.next()){
            lista.add(new Fichaje(rs.getInt("ID"), rs.getInt("ID_EMPLEADO"), rs.getString("TIPO").charAt(0), rs.getTimestamp("FECHAHORA").toLocalDateTime()));
        }
        
        return lista;
    }
    
}
