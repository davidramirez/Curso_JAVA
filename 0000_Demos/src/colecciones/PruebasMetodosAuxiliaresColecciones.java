/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author david
 */
public class PruebasMetodosAuxiliaresColecciones {
    public static void main(String[] args) {
        List<Alumno> lista = new ArrayList<Alumno>();
        
        Alumno a1 = new Alumno("Luis", 1);
        Alumno a2 = new Alumno("Luis", 1);
        Alumno a3 = new Alumno("Maria", 1);
        lista.add(a3);
        lista.add(a2);
        lista.add(a1);
        lista.add(new Alumno("Maria", 3));
        lista.add(new Alumno("Aitor", 3));
        
        System.out.println("Lista:");
        for(Alumno a:lista){
            System.out.println(a);
        }
        
        Collections.sort(lista);
        System.out.println("lista por orden curso nombre");
        for(Alumno a:lista){
            System.out.println(a);
        }
        
        Collections.sort(lista, new OrdenarAlumnoPorId());
        System.out.println("lista por orden id");
        for(Alumno a:lista){
            System.out.println(a);
        }
        
        //Búsqueda binaria
        
        Alumno alumnoABuscar = a1;
        //Ordenado con el criterio a buscar
        Collections.sort(lista);//Ordena por curso nombre 
        int posicion = Collections.binarySearch(lista, alumnoABuscar);//Busca por curso nombre
        System.out.println("Está en la posicion " + posicion);
        
        //Busqueda binaria por ID
        //Ordenado con el criterio a buscar
        Collections.sort(lista, new OrdenarAlumnoPorId());//Ordena por id
        posicion = Collections.binarySearch(lista, alumnoABuscar, new OrdenarAlumnoPorId());//Busca por id
        System.out.println("Está en la posicion " + posicion);
        
    }
}
