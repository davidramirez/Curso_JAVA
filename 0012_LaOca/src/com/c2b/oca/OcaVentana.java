/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class OcaVentana extends JFrame {
    
    private static final int NUM_CASILLAS = 10;
    private static final int NUM_MAX_DADO = 5;
    
    private JButton[] tablero;
    private JButton jugador;
    
    //quitar
    private int posJ1;
    
    //Usar
    private final int NUM_JUGADORES = 4;//Pedir al principio
    private int[] posicionesJugadores;
    private int turno;//num con el jugador que tiene el turno
    
    private JLabel dado;

    public OcaVentana(String title) throws HeadlessException {
        super(title);
        
        tablero = new JButton[NUM_CASILLAS];
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        posJ1=0;
        
        iniciarVentana();
    }

    private void iniciarVentana() {
        //Defino un gestor de distribución
        Container c = this.getContentPane();
        //c.setLayout(new BorderLayout(10, 10));
        
        //Creo 2 paneles con sus correspondientes gestores de distribucion
        JPanel panelJuego = new JPanel(new GridLayout(4, 4));//new FlowLayout(FlowLayout.LEFT));
        JPanel panelEstado = new JPanel();
        panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.Y_AXIS));
        //Y los añado en su sitio en el panel original de la ventana
        c.add(panelJuego, BorderLayout.CENTER);
        c.add(panelEstado, BorderLayout.SOUTH);
        
        //Creo los elementos del panel de estado
        jugador = new JButton();
        jugador.setText("Jugar 1");
        jugador.setActionCommand("J");
        dado = new JLabel();
        dado.setText("");
        dado.setSize(new Dimension(64, 64));
        
        panelEstado.add(jugador);
        panelEstado.add(dado);
        
        ActionListener oyente = new BotonJugadorListener();
        jugador.addActionListener(oyente);
        
        //Creo los elementos del panel de juego con su listener
        ActionListener oyente2 = new BotonCasillaListener();
        for(int i=0;i<NUM_CASILLAS;i++){
            JButton b = new JButton();
            b.addActionListener(oyente2);
            tablero[i] = b;
            panelJuego.add(b);
        }
        
        //Casillas de forma manual
        tablero[0].setActionCommand("Inicio");
        tablero[0].setIcon(new ImageIcon("meta.png"));
        tablero[1].setActionCommand("algo");
        tablero[1].setIcon(new ImageIcon("algo.png"));
        tablero[2].setActionCommand("Oca");
        tablero[2].setIcon(new ImageIcon("oca.png"));
        tablero[3].setActionCommand("algo");
        tablero[3].setIcon(new ImageIcon("algo.png"));
        tablero[4].setActionCommand("algo");
        tablero[4].setIcon(new ImageIcon("algo.png"));
        tablero[5].setActionCommand("Carcel");
        tablero[5].setIcon(new ImageIcon("carcel.png"));
        tablero[6].setActionCommand("Oca");
        tablero[6].setIcon(new ImageIcon("oca.png"));
        tablero[7].setActionCommand("algo");
        tablero[7].setIcon(new ImageIcon("algo.png"));
        tablero[8].setActionCommand("Muerte");
        tablero[8].setIcon(new ImageIcon("muerte.png"));
        tablero[9].setActionCommand("Meta");
        tablero[9].setIcon(new ImageIcon("meta.png"));
        
        //Prueba nueva ficha
        JPanel ficha = new JPanel();
        ficha.setLayout(new BoxLayout(ficha, BoxLayout.Y_AXIS));
        ficha.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        JLabel num = new JLabel("1", JLabel.LEFT);
        num.setAlignmentX(CENTER_ALIGNMENT);
        ficha.add(num);
        JLabel img = new JLabel(new ImageIcon("algo.png"));
        img.setAlignmentX(CENTER_ALIGNMENT);
        ficha.add(img);
        JPanel jugadores = new JPanel();
        jugadores.setLayout(new BoxLayout(jugadores, BoxLayout.X_AXIS));
        JLabel imgFicha = new JLabel(new ImageIcon("ficha.png"));
        jugadores.add(imgFicha);
        imgFicha.setSize(50, 50);
        JLabel imgFicha2 = new JLabel(new ImageIcon("ficha.png"));
        jugadores.add(imgFicha2);
        JLabel imgFicha3 = new JLabel(new ImageIcon("ficha.png"));
        jugadores.add(imgFicha3);
        jugadores.setAlignmentX(CENTER_ALIGNMENT);
        ficha.add(jugadores);
        
        panelJuego.add(ficha);
        //Prueba casilla
        Casilla cas = new Casilla(2, TipoCasilla.OCA);
        panelJuego.add(cas);
        
        //gestionar el tamaño de la ventana
        this.pack();
        Dimension d = this.getSize();
        d.height+=70;
        this.setSize(d);
    }
    
    
    public static void main(String[] args) {
        OcaVentana oca = new OcaVentana("La Oca");
        oca.setVisible(true);
    }
    
    
    private class BotonJugadorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            //Lanzar un dado y mostrar en la etiqueta
            int num = new Random().nextInt(NUM_MAX_DADO)+1;
            dado.setIcon(new ImageIcon("dado/"+num+".png"));
            
            //TODO refactor para que lo haga genérico para jugadores
            //Activar el botón de la casilla a la que llega
            if(e.getActionCommand().equals("J1")){
                if(posJ1+num >= tablero.length){
                    //Se pasa
                    JOptionPane.showMessageDialog(b.getParent(), "¡Te saltas la meta!, ¡prueba en el siguiente turno!");
                    //TODO cambio turno
                }else{
                    posJ1 += num;
                    tablero[posJ1].doClick();
                    //TODO cambio de turno?
                }
            }else{
                //TODO lo mismo para el jugador2
            }
        }
        
    }
    
    private class BotonCasillaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            //JOptionPane.showMessageDialog(b.getParent(), "pulsado!");
            //Ver por el boton qué jugador está activo
            if(jugador.isEnabled()){
                //pongo un texto en el boton
                b.setText("j1");
                
                //ver de que tipo es el boton
                switch(e.getActionCommand()){
                    case "Algo":
                        break;
                    case "Muerte":
                        JOptionPane.showMessageDialog(b.getParent(), "¡El jugador 1 ha muerto! :(");
                        break;
                    case "Meta":
                        JOptionPane.showMessageDialog(b.getParent(), "¡Ha ganado el jugador 1! :)");
                        break;
                    case "Oca":
                        JOptionPane.showMessageDialog(b.getParent(), "¡De oca a oca y tiro porque me toca!");
                        //Buscar la siguiente oca, aumentar la pos del jugador y moverlo
                        for(int i = posJ1+1;i<tablero.length;i++){
                            if(tablero[i].getActionCommand().equals("Oca")){
                                posJ1 = i;
                                tablero[i].setText("j1");
                                break;
                            }
                        }
                        //TODO mantener el turno
                        break;
                    case "Carcel":
                        JOptionPane.showMessageDialog(b.getParent(), "¡El jugador 1 ha caido en la carcel, pierde 2 turnos!");
                        //TODO mantener 2 turnos
                        break;
                }
            }
        }
        
    }
}
