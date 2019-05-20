/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.persistencia;

import app.fichajes.modelo.Empleado;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class EmpleadoDAO implements GenericDAO<Empleado>, Serializable{
    
    private Connection conn;

    public EmpleadoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void alta(Empleado entidad) throws SQLException {
        
    }

    @Override
    public void baja(int id) throws SQLException {
        
    }

    @Override
    public void modifica(Empleado entidad) throws SQLException {
        
    }

    @Override
    public Empleado buscarPorId(int id) throws SQLException {
        String consulta = "SELECT * FROM Empleado WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Empleado(rs.getInt("ID"), rs.getString("CLAVE"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DNI"), rs.getBoolean("ADMIN"));
        }
        
        return null;
    }

    @Override
    public List<Empleado> obtenerTodos() throws SQLException {
        String consulta = "SELECT * FROM Empleado";
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery(consulta);
        
        List<Empleado> lista = new ArrayList<Empleado>();
        while(rs.next()){
            lista.add(new Empleado(rs.getInt("ID"), rs.getString("CLAVE"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DNI"), rs.getBoolean("ADMIN")));
        }
        
        return lista;
    }
    
    public Empleado buscarPorClave(String clave) throws SQLException{
        String consulta = "SELECT * FROM Empleado WHERE clave = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, clave);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Empleado(rs.getInt("ID"), rs.getString("CLAVE"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DNI"), rs.getBoolean("ADMIN"));
        }
        
        return null;
    }

    public Empleado autenticarAdmin(String dni, String clave) throws SQLException {
        String consulta = "SELECT * FROM Empleado WHERE clave = ? and dni = ? and admin='true'";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, clave);
        pst.setString(2, dni);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Empleado(rs.getInt("ID"), rs.getString("CLAVE"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("DNI"), rs.getBoolean("ADMIN"));
        }
        
        return null;
    }
}
