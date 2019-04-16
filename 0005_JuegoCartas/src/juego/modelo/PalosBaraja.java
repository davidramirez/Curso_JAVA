/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.modelo;

/**
 *
 * @author SISTEMAS
 */
public enum PalosBaraja {
    //Básico
//    OROS,
//    COPAS,
//    BASTOS,
//    ESPADAS;
    
    //Desarrollado con valores asociados a cada enumeado
    
    OROS (10),
    COPAS (20),
    BASTOS (40),
    ESPADAS (30);
    
    private final int puntos;
    
    private PalosBaraja(int puntos){
        this.puntos = puntos;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
}
