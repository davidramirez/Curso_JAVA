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
        return null;
    }

    @Override
    public List<Empleado> obtenerTodos() throws SQLException {
        return null;
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
}
