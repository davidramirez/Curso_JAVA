/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.HashMap;

/**
 *
 * @author david
 */
public class PruebaHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Alumno> map = new HashMap();//Key tiene que tener un equals y hashcode
        
        Alumno a1 = new Alumno("Luis", 1);
        Alumno a2 = new Alumno("Pepe", 2);
        Alumno a3 = new Alumno("Rosa", 3);
        
        map.put(a1.getId(), a1);
        map.put(a2.getId(), a2);
        map.put(a3.getId(), a3);
        
        System.out.println("Mostrar alumno cuyo id es el 2");
        System.out.println(map.get(2));
        
        Alumno a4 = new Alumno("gg",3);
        a4.setId(2);
        
        System.out.println("Mostrar alumno cuyo id es el 2");
        System.out.println(map.get(2));
 
        HashMap<Alumno,Double> notas = new HashMap();
        notas.put(a1, 7.0);
        notas.put(a2, 8.0);
        notas.put(a3, 8.5);
        
        System.out.println("La nota media de " + a1.getNombre()+" es "+notas.get(a1));
        
        
        System.out.println("Recorrer los values del map");
        
        for(Alumno a:map.values()){
            System.out.println(a);
        }
        
        System.out.println("Recorrer los keys del map");
        
        for(Integer k:map.keySet()){
            System.out.println(k+" --> "+map.get(k));
        }
    }
}
