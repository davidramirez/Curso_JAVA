/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.modelo.comparators;

import app.fichajes.modelo.Empleado;
import java.util.Comparator;

/**
 *
 * @author david
 */
public class EmpleadoComparatorPorNombre implements Comparator<Empleado>{

    @Override
    public int compare(Empleado o1, Empleado o2) {
        int nombre = o1.getNombre().compareTo(o2.getNombre());
        int apellido = o1.getApellido().compareTo(o2.getApellido());
        int id = o1.getId() - o2.getId();
        
        if(nombre != 0) return nombre;
        if(apellido != 0) return apellido;
        return id;
    }
    
}
