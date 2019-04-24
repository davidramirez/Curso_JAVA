/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosThreadSafe;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class PruebaVecinoBuzon {
    public static void main(String[] args) {
        try {
            Buzon b = new Buzon();
            
            Vecino v = new Vecino("Pepe", b);
            Vecino v2 = new Vecino("Herminia",b);
            Vecino v3 = new Vecino("Angel", b);
            
            Cartero c1 = new Cartero("Alfonso", b);
            Cartero c2 = new Cartero("Carmen", b);
            
            
            Thread hilo1 = new Thread(v, v.getNombre());
            Thread hilo2 = new Thread(v2, v2.getNombre());
            Thread hilo3 = new Thread(v3, v3.getNombre());
            Thread hilo4 = new Thread(c1, c1.getNombre());
            Thread hilo5 = new Thread(c2, c2.getNombre());
            hilo2.start();
            hilo1.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
            
            hilo1.join();//Esperamos a que terminen los hilos
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
            
            System.out.println("Los hilos han terminado");
            b.mostrar();
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaVecinoBuzon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
