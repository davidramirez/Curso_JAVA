/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Comparator;

/**
 *
 * @author david
 */
public class OrdenarAlumnoPorId implements Comparator<Alumno>{

    @Override
    public int compare(Alumno o1, Alumno o2) {
        
        return o1.getId() - o2.getId();
    }
    
}
