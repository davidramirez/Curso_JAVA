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
    private String[] cartas = new String[100];
    private int indice = 0;
    
    public synchronized void ponerCarta(String carta) throws InterruptedException{//Método síncrono
        cartas[indice] = carta;
        //Thread.sleep(20);//Forzar la concurrencia de hilos (prueba)
        indice++;
    }
    
    public String sacarCarta (){
        synchronized(this){//Bloque de sincronización
            if(indice > 0 && indice < cartas.length){
                indice--;
                String carta = cartas[indice];
                cartas[indice] = null;
                return carta;
            }
            return null;
        }
    }
    
    public synchronized void mostrar(){
        for(int i = 0; i<cartas.length;i++){
            System.out.println("Carta " +i+" : "+ cartas[i]);
        }
    }

//    public synchronized boolean estaVacio() {
//        if(indice == 0) return true;
//        return false;
//    }
}
