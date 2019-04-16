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
public class Pajaro extends Animal{

    public Pajaro() {
        super(2);
    }

    
    @Override
    public void desplazarse() {
        System.out.println("Vuelo.......");
    }

    @Override
    public void comer() {
        System.out.println("............soy un pajaro y como gusanos.......");
    }
    
}
