/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

import com.sun.org.apache.xalan.internal.xsltc.dom.AbsoluteIterator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class Casilla extends JPanel{
    private int numero;
    private TipoCasilla tipo;
    private ArrayList<Jugador> jugadores;
    
    private JLabel lblNumero;
    private ImageIcon imagen;
    private JLabel lblImg;
    //private JPanel contPnlJugadores;
    private JPanel pnlJugadores;

    public Casilla(int numero, TipoCasilla tipo) {
        this.numero = numero;
        this.tipo = tipo;
        
        this.jugadores = new ArrayList();
        
        this.lblNumero = new JLabel(numero +"");
        this.lblNumero.setAlignmentX(CENTER_ALIGNMENT);
        this.imagen = new ImageIcon(tipo.getImagen());
        
        //Preparar los layout de la casilla
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setBackground(Color.white);
        
//        this.contPnlJugadores = new JPanel();
//        this.contPnlJugadores.setLayout(null);//Absolutelayout
//        this.contPnlJugadores.setSize(100, 40);
        
        this.pnlJugadores = new JPanel();
        this.pnlJugadores.setBackground(Color.white);
        this.pnlJugadores.setLayout(new BoxLayout(this.pnlJugadores, BoxLayout.X_AXIS));
        this.pnlJugadores.setAlignmentX(CENTER_ALIGNMENT);
        
        //Empaquetar elementos
        this.add(this.lblNumero);
        lblImg = new JLabel(this.imagen);
        lblImg.setAlignmentX(CENTER_ALIGNMENT);
        this.add(lblImg);
        //this.add(this.contPnlJugadores);
        this.add(this.pnlJugadores);
        
        
        //Pruebas
//        JLabel imgFicha = new JLabel(new ImageIcon("ficha.png"));
//        JLabel imgFicha2 = new JLabel(new ImageIcon("ficha.png"));
//        JLabel imgFicha3 = new JLabel(new ImageIcon("ficha.png"));
//        
//        this.pnlJugadores.add(imgFicha);
//        this.pnlJugadores.add(imgFicha2);
//        this.pnlJugadores.add(imgFicha3);
        
//        Insets inset = this.contPnlJugadores.getInsets();
//        Dimension d = this.pnlJugadores.getPreferredSize();
//        this.pnlJugadores.setBounds(inset.left, inset.top, 100 , 20);
    }
    
    
    private void dibujarJugadores(){
        this.pnlJugadores.removeAll();
        for(Jugador j:this.jugadores){
            this.pnlJugadores.add(new JLabel(j.getFicha()));
        }
    }
    
    public void quitarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
        this.dibujarJugadores();
    }
    
    public void anadirJugador(Jugador jugador){
        this.jugadores.add(jugador);
        this.dibujarJugadores();
    }
    
//    public void mostrarJugadorPaso(Jugador jugador){
//        
//    }

    public TipoCasilla getTipo() {
        return this.tipo;
    }
}
