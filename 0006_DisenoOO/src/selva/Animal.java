/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selva;

/**
 *
 * @author david
 */
public abstract class Animal {
    
    private int numeroPatas;

    public Animal() {
        this(0);
    }

    public Animal(int numeroPatas) {
        super();//implicito
        this.numeroPatas = numeroPatas;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }
    
    public abstract void desplazarse();
    public abstract void comer();
    
}
