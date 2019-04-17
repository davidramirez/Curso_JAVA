/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author david
 */
public class PruebaTreeSet {
    public static void main(String[] args) {
        Set<Alumno> alumnos = new TreeSet<Alumno>();
        
        Alumno a1 = new Alumno("Luis", 1);
        Alumno a2 = new Alumno("Luis", 1);
        Alumno a3 = new Alumno("Maria", 1);
        alumnos.add(a3);
        alumnos.add(a2);
        alumnos.add(a1);
        alumnos.add(new Alumno("Maria", 3));
        alumnos.add(new Alumno("Aitor", 3));
        
        System.out.println("Comparo igual " + a1.compareTo(a2));
        System.out.println("Comparo mayor " + a3.compareTo(a1));
        System.out.println("Comparo menor " + a1.compareTo(a3));
        
        for(Alumno a: alumnos){
            System.out.println(a);
        }
        
        //Lista que ordene solo por nombre
        Set<Alumno> listaOrdenadaPorId = new TreeSet(new OrdenarAlumnoPorId());
        listaOrdenadaPorId.add(a3);
        listaOrdenadaPorId.add(a2);
        listaOrdenadaPorId.add(a1);
        listaOrdenadaPorId.add(new Alumno("Maria", 3));
        listaOrdenadaPorId.add(new Alumno("Aitor", 3));
        
        System.out.println("Lista ordenada por id");
        for(Alumno a: listaOrdenadaPorId){
            System.out.println(a);
        }
        
        
    }
}
