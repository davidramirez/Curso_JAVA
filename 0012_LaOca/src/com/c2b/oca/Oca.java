/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Oca {
    
    private final int NUM_JUGADORES;
    private Casilla[] tablero;
    private Jugador[] jugadores;
    private int jugadorActual;
    
    private final static TipoCasilla[] CASILLAS_OCA = {TipoCasilla.INICIO,TipoCasilla.NORMAL,TipoCasilla.NORMAL,TipoCasilla.NORMAL,
                                                       TipoCasilla.NORMAL,TipoCasilla.OCA,TipoCasilla.NORMAL,TipoCasilla.CARCEL,
                                                       TipoCasilla.NORMAL,TipoCasilla.NORMAL,TipoCasilla.OCA,TipoCasilla.NORMAL,
                                                       TipoCasilla.NORMAL,TipoCasilla.NORMAL,TipoCasilla.NORMAL,TipoCasilla.OCA,
                                                       TipoCasilla.NORMAL,TipoCasilla.CARCEL,TipoCasilla.NORMAL,TipoCasilla.NORMAL,
                                                       TipoCasilla.OCA,TipoCasilla.NORMAL,TipoCasilla.MUERTE,TipoCasilla.NORMAL,TipoCasilla.META};

    private VentanaJuegoOca ventana;
    public Oca(int numJugadores, VentanaJuegoOca v) {
        this.ventana = v;
        
        this.NUM_JUGADORES = numJugadores;
        
        this.tablero = new Casilla[CASILLAS_OCA.length];
        for(int i=0;i<this.tablero.length;i++){
            this.tablero[i] = new Casilla(i, CASILLAS_OCA[i]);
        }
        
        this.jugadorActual = 0;
        
        //Crear los jugadores y meterlos en la primera casilla
        this.jugadores = new Jugador[this.NUM_JUGADORES];
        for(int i=0;i<this.NUM_JUGADORES;i++){
            this.jugadores[i] = new Jugador(i+1);
            this.tablero[0].anadirJugador(this.jugadores[i]);
        }
    }

    public Casilla[] getTablero() {
        return tablero;
    }
    
    private Jugador getJugadorActual(){
        return this.jugadores[this.jugadorActual];
    }

    public ImageIcon getFichaJugadorActual() {
        return this.getJugadorActual().getFicha();
    }
    
    /**
     * Pasar el turno al siguiente jugador que pueda jugar
     * 
     * Comprueba si el siguiente jugador puede jugar el turno
     */
    private void pasarTurno(){
        this.jugadorActual++;
        
        if(this.jugadorActual == NUM_JUGADORES){
            this.jugadorActual = 0;
        }
        
        if(this.getJugadorActual().estaEliminado()){
            //avisar? "El jugador x está eliminado, pasando al siguiente"
            JOptionPane.showMessageDialog(this.ventana, "El jugador "+this.getJugadorActual().getNumero()
                    +" está eliminado. Se pasa al siguiente jugador");
            //Pasar al siguiente
            this.pasarTurno();
        }else if(this.getJugadorActual().estaCastigado()){
            //avisar el jugador x esta castigado, pasando al siguiente
            JOptionPane.showMessageDialog(this.ventana, "El jugador "+this.getJugadorActual().getNumero()
                    +" tiene que esperar. Se pasa al siguiente jugador");
            //Restar un turno de castigo
            this.getJugadorActual().restarTurnoEspera();
            //Pasar al siguiente
            this.pasarTurno();
        }else{
            //Avisar del jugador nuevo
            JOptionPane.showMessageDialog(this.ventana, "Turno del jugador "+this.getJugadorActual().getNumero());
        }
    }
    
    public void moverJugador(int numCasillas){
        //Mirar si el jugador se pasa la meta
        int casillaActual = this.getJugadorActual().getCasillaActual();
        int casillasTablero = this.tablero.length;
        int casillaObj = casillaActual + numCasillas;
        if(casillaActual + numCasillas >= this.tablero.length){
            casillaObj = casillasTablero-1 - (casillaActual + numCasillas - (casillasTablero-1));
            //aviso que se pasa
            JOptionPane.showMessageDialog(this.ventana, "El jugador "+this.getJugadorActual().getNumero()
                    +" se pasa y rebota");
        }
        
        //Cambiar el jugador de casilla
        tablero[casillaActual].quitarJugador(this.getJugadorActual());
        tablero[casillaObj].anadirJugador(this.getJugadorActual());
        this.getJugadorActual().setCasillaActual(casillaObj);
        
        //Analizar casilla objetivo
        if(tablero[casillaObj].getTipo() == TipoCasilla.NORMAL){
            this.pasarTurno();
        }else if(tablero[casillaObj].getTipo() == TipoCasilla.CARCEL){
            //dos turnos sin jugar
            this.getJugadorActual().setNumTurnosInactivo(2);
            //informar
            JOptionPane.showMessageDialog(this.ventana, "El jugador "+this.getJugadorActual().getNumero()
                    +" ha caido en la cárcel. Dos turnos sin jugar.");
            this.pasarTurno();
        }else if(tablero[casillaObj].getTipo() == TipoCasilla.MUERTE){
            //ya no juega
            this.getJugadorActual().setNumTurnosInactivo(-1);
            //informar
            JOptionPane.showMessageDialog(this.ventana, "El jugador "+this.getJugadorActual().getNumero()
                    +" ha caido en la muerte y queda eliminado");
            this.pasarTurno();
        }else if(tablero[casillaObj].getTipo() == TipoCasilla.OCA){
            //informar
            JOptionPane.showMessageDialog(this.ventana, "De oca a oca y tiro porque me toca. "
                    + "El jugador "+this.getJugadorActual().getNumero()+" sigue teniendo el turno.");
            //Buscar siguiente oca
            for(int i = casillaObj+1;i < casillasTablero;i++){
                if(this.tablero[i].getTipo() == TipoCasilla.OCA){
                    //mover a la casilla
                    tablero[casillaObj].quitarJugador(this.getJugadorActual());
                    tablero[i].anadirJugador(this.getJugadorActual());
                    this.getJugadorActual().setCasillaActual(i);
                    break;
                }
            }
        }else if(tablero[casillaObj].getTipo() == TipoCasilla.META){
            //informar
            JOptionPane.showMessageDialog(this.ventana, "¡El jugador "+this.getJugadorActual().getNumero()
                    +" ha ganado!");
            //TODO pedir nueva partida
            
            if(JOptionPane.showConfirmDialog(ventana, "¿Quieres jugar otra vez?", "Nueva partida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                VentanaInicio v = new VentanaInicio();
                v.setVisible(true);
                
                this.ventana.dispose();
            } else{
                System.exit(0);
            }
            
        }
    }
}
