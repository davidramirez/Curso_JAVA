/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Saludador implements Runnable{
    
    private String saludo;
    private int veces;

    public Saludador(String saludo, int veces) {
        this.saludo = saludo;
        this.veces = veces;
    }

    @Override
    public void run() {
        for(int i = 0; i<veces;i++){
            try {
                //Dormir un hilo, hacer una pausa
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+"....."+saludo+" "+"....."+i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Saludador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
