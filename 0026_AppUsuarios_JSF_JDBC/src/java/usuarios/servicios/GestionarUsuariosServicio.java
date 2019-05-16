/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.servicios;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import usuarios.modelo.Usuario;
import usuarios.persistencia.UsuarioDAO;
import usuarios.servicios.excepciones.UsuarioException;

/**
 *
 * @author david
 */
@Named(value = "gestionarUsuariosService")
@SessionScoped
public class GestionarUsuariosServicio implements Serializable {

    private static Logger log = Logger.getLogger("GestionarUsuariosServicio");

    private UsuarioDAO dao;
    private Connection conn;

    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargo el driver ok");
        } catch (ClassNotFoundException ex) {
            System.err.println(".... no se pudo cargar el driver");
        }
    }

    public GestionarUsuariosServicio() {
        String url = "jdbc:derby://localhost:1527/UsuariosDB";
        String usr = "app";
        String pwd = "app";

        try {
            this.conn = DriverManager.getConnection(url, usr, pwd);
            this.conn.setAutoCommit(false);
            dao = new UsuarioDAO(conn);
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            //TODO mejorar excepciones de conexión
        }

    }

    public List<Usuario> getListaUsuarios() throws UsuarioException{

        try {
            List<Usuario> lista = this.dao.obtenerTodos();
            //this.conn.commit();
            return lista;
        } catch (SQLException ex) {
            log.severe("Al obtener la lista de usuarios. Error BD: " + ex.getMessage());
            throw new UsuarioException("No se pudo obtener la lista de usuarios");
        }
    }

    /**
     *
     * @param u
     * @throws UsuarioException si no se puede crear el usuario
     */
    public void crearNuevoUsuario(Usuario u) throws UsuarioException {

        log.info("Grabando nuevo usuario");
        try {
            if (!this.dao.existeDNI(u.getDni())) {
                dao.alta(u);
                conn.commit();
            }else{
                throw new UsuarioException("Ya existe un usuario con el DNI " + u.getDni());
            }
        } catch (SQLException ex) {
            log.severe("Al crear nuevo usuario. Error BD: " + ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                log.severe("Al crear nuevo usuario. Error rollback BD: " + ex1.getMessage());
            }
        }
    }

    public boolean existeDNI(String dni) {
        try {
            return this.dao.existeDNI(dni);
        } catch (SQLException ex) {
            log.severe("Al comprobar si existe un dni. Error BD: " + ex.getMessage());
            return true;//TODO mejorar
        }
    }
    
    public Usuario buscarUsuarioPorId(int id) throws UsuarioException{
        try {
            return this.dao.buscarPorId(id);
        } catch (SQLException ex) {
            log.severe("Al buscar un usuario por id. Error BD: " + ex.getMessage());
            throw new UsuarioException("No se pudo encontrar el usuario con el id: "+ id);
        }
    }
    
    public void actualizarUsuario(Usuario u) throws UsuarioException{
        try {
            this.dao.modifica(u);
            this.conn.commit();
        } catch (SQLException ex) {
            log.severe("Al modificar un usuario. Error BD: " + ex.getMessage());
            throw new UsuarioException("No se pudo modificar el usuario "+u.getNombre());
        }
    }
    
    public void eliminarUsuario(int id) throws UsuarioException{
        try {
            this.dao.baja(id);
        } catch (SQLException ex) {
            log.severe("Al eliminar un usuario. Error BD: " + ex.getMessage());
            throw new UsuarioException("No se pudo eliminar el usuario con id " + id);
        }
    }
    
    
    //Para que sse ejecute cuando el contenedor destruye la clase
    //Se cierra la conexión
    @PreDestroy
    public void cierre(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            log.severe("Al cerrar la conexión de la BD. Error BD: " + ex.getMessage());
        }
    }
}
