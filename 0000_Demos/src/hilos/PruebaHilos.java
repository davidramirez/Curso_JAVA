/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author david
 */
public class PruebaHilos {
    public static void main(String[] args) {
        System.out.println("Inicio main........");
        Runnable sn = new SumadorNumeros();
        
        sn.run();
        
        
        System.out.println("..... Fin del main");
    }
}
