/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author david
 */
public class Pruebas {
    public static void main(String[] args) {
        int[] numeros = new int[4];
        
        for(int i:numeros){
            System.out.println(i);
        }
        
        ArrayList objetos = new ArrayList();
        
        objetos.add(new String("hola"));
        objetos.add(new Integer(2));
        objetos.add(3);//Crea el objeto Integer
        
        objetos.add(new Alumno("Luis", 2));
        System.out.println("Reecorrer colección............");
        for(Object o:objetos){
            System.out.println(o);
            if(o instanceof Alumno){
                System.out.println("Nombre " + ((Alumno) o).getNombre());;
            }
        }
        
        ArrayList<Alumno> alumnos = new ArrayList();
        alumnos.add(new Alumno("Mario",1));
        alumnos.add(new Alumno("Maria",1));
        alumnos.add(new Alumno("Luis",1));
        alumnos.add(new Alumno("Ainara",1));
        
        for(Alumno a:alumnos){
            System.out.println("Nombre " + a.getNombre());
        }
        
        Alumno a3 = alumnos.get(3);
        System.out.println("En tres está " + a3.getNombre());
        
        alumnos.add(0, new Alumno("Begona",1));
        System.out.println("Añado a begoña");
        for(Alumno a:alumnos){
            System.out.println("Nombre " + a.getNombre());
        }
        
        //ArrayList<? extends Animal> listaZoo = new ArrayList<cat>();//puede ser de Animal, cat, dog...
        //Vector v = new Vector();
        
        
    }
}
