/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author david
 */
public class PruebaSetAlumnos {
    public static void main(String[] args) {
        Set<Alumno> alumnos = new HashSet();
        
        alumnos.add(new Alumno("Luis", 1));
        alumnos.add(new Alumno("Luis", 1));
        alumnos.add(new Alumno("Maria", 1));
        
        for(Alumno a: alumnos){
            System.out.println(a);
        }
    }
}
