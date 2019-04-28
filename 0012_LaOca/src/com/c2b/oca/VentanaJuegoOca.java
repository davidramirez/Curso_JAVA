/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class VentanaJuegoOca extends JFrame{
    
    //Para dibujar en el orden adecuado un tablero en espiral a partir de las fichas de la oca
    private final static int[] ORDEN_TABLERO = {0,1,2,3,4,15,16,17,18,5,14,23,24,19,6,13,22,21,20,7,12,11,10,9,8};
    
    private final Oca juego;
    private JLabel jugadorActual;
    
    private JButton btnTirarDado;
    private Dado dado;

    public VentanaJuegoOca(int numJugadores) {
        super("La Oca");
        
        this.juego = new Oca(numJugadores, this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage("imagenes/casillas/oca.png");
        this.setIconImage(img);
        
        iniciarVentana();
    }

    private void iniciarVentana() {
        //Preparar estructura y dibujar tablero
        //Defino un gestor de distribución
        Container c = this.getContentPane();
        //c.setLayout(new BorderLayout(10, 10));
        
        //Creo 2 paneles con sus correspondientes gestores de distribucion
        JPanel panelJuego = new JPanel(new GridLayout(5, 5));
        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.Y_AXIS));
        //Y los añado en su sitio en el panel original de la ventana
        c.add(panelJuego, BorderLayout.CENTER);
        c.add(panelEstado, BorderLayout.EAST);
        
        //Preparar el panel del tablero, meter las casillas
        for(int i:ORDEN_TABLERO){
            panelJuego.add(this.juego.getTablero()[i]);
        }
        
        //Preparar el panel de estado
        JLabel lbl = new JLabel("JugadorActual: ");
        lbl.setAlignmentX(CENTER_ALIGNMENT);
        this.jugadorActual = new JLabel(this.juego.getFichaJugadorActual());
        this.jugadorActual.setAlignmentX(CENTER_ALIGNMENT);
        this.btnTirarDado = new JButton("Lanzar dado");
        this.btnTirarDado.setAlignmentX(CENTER_ALIGNMENT);
        this.dado = new Dado();
        this.dado.setAlignmentX(CENTER_ALIGNMENT);
        
        panelEstado.add(lbl);
        panelEstado.add(this.jugadorActual);
        panelEstado.add(this.btnTirarDado);
        panelEstado.add(this.dado);
        
        //Listener del boton
        this.btnTirarDado.addActionListener(new BotonLanzarListener());
        
        this.pack();
        this.setMinimumSize(this.getSize());
    }
    
    public static void main(String[] args) {
        VentanaJuegoOca oca = new VentanaJuegoOca(6);
        oca.setVisible(true);
    }
    
    private class BotonLanzarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            b.setEnabled(false);
            //Lanzar el dado
            int num = dado.lanzarDado();
            
            //hacer el movimiento del jugador
            juego.moverJugador(num);
            
            //Actualizar el jugador actual
            jugadorActual.setIcon(juego.getFichaJugadorActual());
            jugadorActual.updateUI();
            b.setEnabled(true);
        }
        
    }
    
}
