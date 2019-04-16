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
public class Gato extends Animal{

    public Gato() {
        super(4);
    }

    @Override
    public void desplazarse() {
        System.out.println("Ando a 4 patas");    
    }

    @Override
    public void comer() {
        System.out.println("Como ratones");
    }
    
    
    
}
