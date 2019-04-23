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
public class Buzon {
    private String[] cartas = new String[300];
    private int indice = 0;
    
    public synchronized void ponerCarta(String carta) throws InterruptedException{//Método síncrono
        cartas[indice] = carta;
        Thread.sleep(140);//Forzar la concurrencia de hilos (prueba)
        indice++;
    }
    
    public String sacarCarta (){
        synchronized(this){//Bloque de sincronización
            String carta = cartas[indice];
            cartas[indice] = null;
            indice--;
            return carta;
        }
    }
    
    public synchronized void mostrar(){
        for(int i = 0; i<indice;i++){
            System.out.println("Carta " +i+" : "+ cartas[i]);
        }
    }
}
