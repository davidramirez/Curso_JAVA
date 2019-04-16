/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author david
 */
public class PruebaSet {
    public static void main(String[] args) {
        //No duplicados
        
        //Hashset
        //N0 indexadas
        HashSet s;//No ordenado
        LinkedHashSet s2;//Orden de insercion
        TreeSet s3;//orden natural
        
        Set<String> nombres = new TreeSet();
        
        nombres.add("Luis");
        nombres.add("Mario");
        nombres.add("Laura");
        nombres.add("Carlos");
        nombres.add("Carlos");
        
        for(String nom:nombres){
            System.out.println(nom);
        }
    }
}
