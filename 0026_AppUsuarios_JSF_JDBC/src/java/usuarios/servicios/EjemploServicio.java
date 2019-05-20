/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.servicios;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 *
 * @author david
 */
@Named(value="ejemploServivio")
@SessionScoped
public class EjemploServicio implements Serializable{
    
    @Resource(name = "jdbc/fichajes")
    private DataSource dataSource;

    public EjemploServicio() {
        System.out.println("instanciando sampleservice...............");
        System.out.println("datasource " + dataSource);
    }
    
    public void setDataSource(DataSource dataSource) {
        System.out.println("......Inyectando data source................");
        this.dataSource = dataSource;
    }
    
    public void hazAlgo() throws SQLException{
        System.out.println("... datasource en haz algo " + dataSource);
        System.out.println("conexion");
        Connection con = dataSource.getConnection();
        System.out.println("...." + con);
    }
    
}
