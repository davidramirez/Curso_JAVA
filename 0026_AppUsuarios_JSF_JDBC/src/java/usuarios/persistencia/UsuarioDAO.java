/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.persistencia;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelo.Usuario;

/**
 *
 * @author david
 */
public class UsuarioDAO implements GenericDAO<Usuario>, Serializable{
    
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void alta(Usuario entidad) throws SQLException {
        
        String consulta = "INSERT INTO USUARIOS (NOMBRE, DNI) VALUES (?, ?)";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, entidad.getNombre());
        pst.setString(2, entidad.getDni());
        pst.executeUpdate();
    }

    @Override
    public void baja(int id) throws SQLException {
        String consulta = "DELETE FROM USUARIOS WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        pst.executeUpdate();
    }

    @Override
    public void modifica(Usuario entidad) throws SQLException {
        String consulta = "UPDATE USUARIOS SET NOMBRE = ?, DNI = ? WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, entidad.getNombre());
        pst.setString(2, entidad.getDni());
        pst.setInt(3, entidad.getId());
        pst.executeUpdate();
    }

    /**
     * Busca el usuario por id
     * @param id
     * @return null si no se encuentra el usuario
     * @throws SQLException 
     */
    @Override
    public Usuario buscarPorId(int id) throws SQLException {
        String consulta = "SELECT * FROM USUARIOS WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Usuario(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("DNI"));
        }
        
        return null;
    }

    /**
     * Devuelve la lista de usuarios
     * @return una lista vacía si no hay resultados
     * @throws SQLException 
     */
    @Override
    public List<Usuario> obtenerTodos() throws SQLException {
        String consulta = "SELECT * FROM USUARIOS";
        PreparedStatement pst = conn.prepareStatement(consulta);
        ResultSet rs = pst.executeQuery();
        
        List<Usuario> lista = new ArrayList();
        
        while(rs.next()){
            lista.add(new Usuario(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("DNI")));
        }
        
        return lista;
    }
    
    /**
     * Comprueba si el dni dado existe en la BD
     * @param dni El dni a buscar
     * @return true si existe. Flase en caso contrario
     * @throws SQLException 
     */
    public boolean existeDNI(String dni) throws SQLException{
        String consulta = "SELECT * FROM USUARIOS WHERE DNI = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dni);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return true;
        }
        return false;
    }
    
    public Usuario getUsuarioPorDNI(String dni) throws SQLException{
        String consulta = "SELECT * FROM USUARIOS WHERE dni = ?";
        PreparedStatement pst = conn.prepareStatement(consulta);
        pst.setString(1, dni);
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            return new Usuario(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("DNI"));
        }
        
        return null;
    }
}
