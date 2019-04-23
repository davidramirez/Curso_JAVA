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
            
            
            Thread hilo1 = new Thread(v, v.getNombre());
            Thread hilo2 = new Thread(v2, v2.getNombre());
            hilo2.start();
            hilo1.start();
            
            hilo1.join();//Esperamos a que terminen los hilos
            hilo2.join();
            
            System.out.println("Los hilos han terminado");
            b.mostrar();
        } catch (InterruptedException ex) {
            Logger.getLogger(PruebaVecinoBuzon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
