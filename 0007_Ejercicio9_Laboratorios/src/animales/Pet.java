/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

/**
 *
 * @author david
 */
public interface Pet {
    
    public String getName();
    public void setName(String name);
    public void play();
    
    //Prueba de interfaces java8
    //Método no sobreescribible
    public static void dormir(){
        System.out.println("zzzzzzzzzzzzzzzzzzz");
    }
    
    //Método sobreescribible
    public default void tirarCosas(){
        System.out.println("Tiro cosas");
    }
}
