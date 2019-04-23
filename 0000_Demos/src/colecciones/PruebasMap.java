/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.*;//No importa nada, 

/**
 *
 * @author david
 */
public class PruebasMap {
    public static void main(String[] args) {
        //Hashtable**************************************************************************
        System.out.println("Pruebas Hashtable");
        Map<Integer, Alumno> map = new Hashtable();//thread safe implementaction
        
        Alumno a1 = new Alumno("Luis", 1);
        Alumno a2 = new Alumno("Pepe", 2);
        Alumno a3 = new Alumno("Rosa", 3);
        Alumno a4 = new Alumno("Marta", 2);
        
        map.put(a3.getId(), a3);
        map.put(a2.getId(), a2);
        map.put(a1.getId(), a1);
        map.put(a4.getId(), a4);//Claves iguales sobreescriben el valor existente
        
        System.out.println("Recorrer los values del map");
        
        for(int i:map.keySet()){
            System.out.println(map.get(i));
        }
        
        //HashMap******************************************************************************
        System.out.println("Pruebas hashmap");
        Map<Integer, Alumno> map2 = new HashMap();//thread safe implementaction
        
        map2.put(a3.getId(), a3);
        map2.put(a2.getId(), a2);
        map2.put(a1.getId(), a1);
        map2.put(a4.getId(), a4);//Claves iguales sobreescriben el valor existente
        
        System.out.println("Recorrer los values del map");
        
        for(int i:map2.keySet()){
            System.out.println(map2.get(i));
        }
        
        //LinkedHashMap*****************************************************************************
        System.out.println("Pruebas linkedhashmap");
        Map<Integer, Alumno> map3 = new LinkedHashMap();//thread safe implementaction
        
        map3.put(a2.getId(), a2);
        map3.put(a3.getId(), a3);
        map3.put(a1.getId(), a1);
        map3.put(a4.getId(), a4);//Claves iguales sobreescriben el valor existente
        
        System.out.println("Recorrer los values del map");
        
        for(int i:map3.keySet()){
            System.out.println(map3.get(i));
        }
        
        //TreeMap******************************************************************************
        System.out.println("Pruebas treemap");
        Map<Integer, Alumno> map4 = new TreeMap();//thread safe implementaction
        
        map4.put(a3.getId(), a3);
        map4.put(a2.getId(), a2);
        map4.put(a1.getId(), a1);
        map4.put(a4.getId(), a4);//Claves iguales sobreescriben el valor existente
        
        System.out.println("Recorrer los values del map");
        
        for(int i:map4.keySet()){
            System.out.println(map4.get(i));
        }
        
        
        
        System.out.println("\n\n++++++++++++++++Prueba Map<Curso, Double>, nota media por curso++++++++++++++++\n\n");
        
        Curso c1 = new Curso(1, "Primero de primaria");
        Curso c2 = new Curso(20, "Segundo de primaria");
        Curso c3 = new Curso(14, "Tercero de primaria");
        Curso c4 = new Curso(8, "Tercero de primaria modelo B");
        Curso c5 = new Curso(4, "Cuarto de primaria");
        
        Map<Curso, Double> medias = new TreeMap();//o cualquier Map
        
        medias.put(c5, 7.3);
        medias.put(c3, 6.2);
        medias.put(c4, 7.8);
        medias.put(c1, 8.1);
        medias.put(c2, 9.0);
        
        for(Curso c:medias.keySet()){
            System.out.println("Curso: " + c + " Nota media: " + medias.get(c));
        }
        
        
        System.out.println("\n\n+++++++Prueba Map<Curso, Double>, nota media por curso"
                + " con comparator de descripcion del curso++++++++\n\n");
        
        Curso c6 = new Curso(1, "Primero de primaria");
        Curso c7 = new Curso(2, "Segundo de primaria");
        Curso c8 = new Curso(3, "Tercero de primaria");
        Curso c9 = new Curso(3, "Tercero de primaria modelo B");
        
        Map<Curso, Double> medias2 = new TreeMap(new ComparatorCurso());//o cualquier Map
        
        medias2.put(c8, 7.3);
        medias2.put(c7, 6.2);
        medias2.put(c6, 7.8);
        medias2.put(c9, 8.1);
        
        for(Curso c:medias2.keySet()){
            System.out.println("Curso: " + c + " Nota media: " + medias2.get(c));
        }
        
        //Map<Curso, List<Alumno>
        System.out.println("\n\n+++++++++++++++++++++++++ lista de alumnos por curso +++++++++++++++++++++++++++\n\n");
        
        List<Alumno> l1 = new LinkedList();
        l1.add(a4);
        l1.add(a2);
        
        List<Alumno> l2 = new ArrayList();
        l2.add(a1);
        l2.add(a3);
        
        Map<Curso, List<Alumno>> mapColegio = new TreeMap();
        mapColegio.put(c1, l1);
        mapColegio.put(c1, l2);//La piso
        mapColegio.put(c2, l1);
        
        for(Curso c:mapColegio.keySet()){
            System.out.println("Al curso " +c+" pertenecen los alumnos: ");
            for(Alumno a:mapColegio.get(c)){
                System.out.println(a);
            }
        }
    }
}
