/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractas;

/**
 *
 * @author SISTEMAS
 */
public abstract class Animal {
    
    private int patas = 0;

    public Animal() {
    }
     
    public Animal(int patas) {
        this.patas = patas;
    }

   
    public int getPatas() {
        return patas;
    }

    public abstract void desplazarse();
    
    public abstract void comer();
    
    
    
}
