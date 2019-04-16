/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelo;

import java.util.Random;

/**
 *
 * @author SISTEMAS
 */
public class Carta {
    
    private PalosBaraja palo;
    private int numero;
    
    private static final int NUM_MAX_CARTA = 10;

    public Carta() {
        palo = this.generarPaloAleatorio();
        numero = this.generarNumeroAleatorio();
    }
    
    private PalosBaraja generarPaloAleatorio(){
        return PalosBaraja.values()[new Random().nextInt(PalosBaraja.values().length)];
    }
    
    private int generarNumeroAleatorio(){
        //Next int genera entre 0...num, le resto 1 al num max y al 
        //resultado le sumo para generar dentro del intervalo
        return (new Random().nextInt(NUM_MAX_CARTA-1)+1);
    }

    public PalosBaraja getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
}
