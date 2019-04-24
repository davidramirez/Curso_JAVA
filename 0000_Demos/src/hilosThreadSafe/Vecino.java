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
public class Vecino implements Runnable{

    private String nombre;
    private Buzon buzon;

    public Vecino(String nombre, Buzon buzon) {
        this.nombre = nombre;
        this.buzon = buzon;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        //Añadir 20 cartas al buzón
        for(int i = 0; i<30 ; i++){
            try {
                char letra = (char)('A'+i);
                String carta = "carta " + letra + " del vecino " +this.getNombre();
                System.out.println(Thread.currentThread().getName() + " pone carta: "+carta);
                buzon.ponerCarta(carta);
            } catch (InterruptedException ex) {
                Logger.getLogger(Vecino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
