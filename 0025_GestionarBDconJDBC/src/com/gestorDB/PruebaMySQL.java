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

/**
 *
 * @author david
 */
public class PruebaMySQL {
    
    public static void main(String[] args) {
        try {
            //1. cargar el driver de java db
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Cargo el driver ok");

        } catch (ClassNotFoundException ex) {
            System.err.println(".... no se pudo cargar el driver");
        }

        //2. obtener una conexión a la bd sample2
        String url = "jdbc:mysql://127.0.0.1:3306/sample";//Con la url se distingue el fabricante, 
        //se podrían tener diferentes y usar múltiples BDs
        String usr = "root";
        String pwd = "1234";

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
}
