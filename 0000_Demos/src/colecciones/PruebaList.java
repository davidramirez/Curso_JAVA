/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author david
 */
public class PruebaList {
    public static void main(String[] args) {
        List l1 = new ArrayList();
        List l2 = new Vector();
        
        List<String> l = new ArrayList();
        l.add("Zorro");
        l.add("gato");
        l.add("avion");
        
        l.add(2,"zapato");
        
        System.out.println("ver 2 " + l.get(2));
        
        System.out.println("recorrer");
        for(String s:l){
            System.out.println(s);
        }
        
        
        LinkedList<String> l3 = new LinkedList<String>();
        l3.add("OTRO");
        l3.addFirst("UNO");
        l3.addLast("FIN");
    }
}
