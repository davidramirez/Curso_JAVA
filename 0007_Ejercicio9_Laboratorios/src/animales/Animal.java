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
public abstract class Animal {
    
    protected int legs;

    public Animal(int legs) {
        this.legs = legs;
    }
    
    public abstract void eat();
    
    public void walk(){
        System.out.println("Ando con " + this.legs + " patas");
    }
    
}
