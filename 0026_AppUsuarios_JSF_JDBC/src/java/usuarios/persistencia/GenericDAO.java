/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.persistencia;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david
 */
public interface GenericDAO<E> {
    
    public void alta(E entidad) throws SQLException;
    public void baja(int id)  throws SQLException;
    public void modifica(E entidad)  throws SQLException;
    public E buscarPorId(int id)  throws SQLException;  
    public List<E> obtenerTodos()  throws SQLException;
}
