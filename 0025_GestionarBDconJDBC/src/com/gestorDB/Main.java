/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Main {

    public static void main(String[] args) {
        try {
            //1. cargar el driver de java db
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargo el driver ok");

        } catch (ClassNotFoundException ex) {
            System.err.println(".... no se pudo cargar el driver");
        }

        //2. obtener una conexión a la bd sample2
        String url = "jdbc:derby://localhost:1527/sample2";//Con la url se distingue el fabricante, 
        //se podrían tener diferentes y usar múltiples BDs
        String usr = "app";
        String pwd = "app";

        //V. vieja Connection conn = null;
        //V. vieja try {
        try (Connection conn = DriverManager.getConnection(url, usr, pwd);) {
            //V nueva(v7) cierra el recurso si falla o cuando termine
            //V. vieja conn = DriverManager.getConnection(url, usr, pwd);
            System.out.println("....conectado....");

            //3. Crear una sentencia
            Statement st = conn.createStatement();

            //4. Ejecutar una consulta select
            //    El resultado se guarda en un ResultSet
            ResultSet rs = st.executeQuery("SELECT product_id, description FROM product");

            //5. Recorrer los datos para mostrarlos
            while (rs.next()) {
                System.out.print(". " + rs.getInt(1));
                System.out.println(" - " + rs.getString(2));
            }

            //6 Insertar un nuevo código de descuento
            Statement stInsert = conn.createStatement();
            System.out.println("insert");
            //int n = stInsert.executeUpdate("INSERT INTO discount_code VALUES ('A', 20.0)");//Insert, delete, update, (create table)

            System.out.println("sentencia desconocida");
            String sentencia = "SELECT * FROM discount_code";
            Statement stDesconocido = conn.createStatement();

            boolean hayRS = stDesconocido.execute(sentencia);//true hay Resultset

            if (hayRS) {
                ResultSet rs2 = stDesconocido.getResultSet();
                //recorrerlo

                while (rs2.next()) {
                    System.out.print(". " + rs2.getString(1));
                    System.out.println(" - " + rs2.getString(2));
                }
            } else {
                System.out.println(" Afectó a "
                        + stDesconocido.getUpdateCount() + " registros");
            }

            //7 usar prepared statement para hacer modificaciones
            String sqlModificacion = "UPDATE discount_code SET rate = ? WHERE discount_code = ? ";//Sentencia con parámetros
            PreparedStatement pst = conn.prepareStatement(sqlModificacion);
            //Los parametros son modificables y la sentencia reutilizable

            //modificar A
            pst.setDouble(1, 40.3);
            pst.setString(2, "A");

            pst.executeUpdate();

            //modificar e
            pst.setDouble(1, 12.7);
            pst.setString(2, "e");

            pst.executeUpdate();

            //************Prueba dde creación de un curssor scrollable
            Statement stScrollable = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String consulta = "SELECT * FROM customer";
            ResultSet rsScrollable = stScrollable.executeQuery(consulta);

            if (rsScrollable.last()) {
                System.out.println("nombre: " + rsScrollable.getString("NAME"));

                if (rsScrollable.first()) {
                    System.out.println("nombre: " + rsScrollable.getString("NAME"));
                }

            }
            
            
            
            //TRANSACCIONES  +++++++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println("TRANSACCIONES ************************************");
            
            conn.setAutoCommit(false);
            //insert 1
            //insert 2
            //delete
            
            
            
            //Commit
            conn.commit();
            
        } catch (SQLException ex) {
            System.out.println("error de BD " + ex.getMessage());
            
            //Habria que hacerlo aqui
            //conn.rollback();
        } //V.Vieja finally {
//            //cerrar la conexión
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    System.out.println("error al cerrar");
//                }
//            }
//        }
    }

}
