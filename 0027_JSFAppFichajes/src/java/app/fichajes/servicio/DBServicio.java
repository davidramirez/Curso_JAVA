/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class DBServicio {
    
    private static DBServicio miDBServicio = new DBServicio();

    
    static{
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargo el driver ok");
        } catch (ClassNotFoundException ex) {
            System.err.println(".... no se pudo cargar el driver");
        }
    }

    private DBServicio() {
    }
    
    public static DBServicio getDBServicio(){
        return miDBServicio;
    }
    
    public Connection obtenerConexionBD() throws SQLException{
        String url = "jdbc:derby://localhost:1527/FichajesDB";
        String usr = "app";
        String pwd = "app";

        Connection conn;
        
            conn = DriverManager.getConnection(url, usr, pwd);
            conn.setAutoCommit(false);
            return conn;
    }
    
}
