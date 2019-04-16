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
public class Prueba {

    public static void main(String[] args) {
        //Animal a = new Animal();//peta, no son instanciables
        Animal[] animales = new Animal[4];
        animales[0] = new Pajaro();
        animales[1] = new Gato();
        animales[2] = new Gato();
        animales[3] = new Pajaro();
        
        for(Animal a: animales){
            System.out.println("Siguiente animal---------------------");
            a.comer();
            a.desplazarse();
            System.out.println("Numero de patas " + a.getPatas());
        }
    }
}
