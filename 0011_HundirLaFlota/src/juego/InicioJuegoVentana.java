/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class InicioJuegoVentana extends JFrame{
    
    //Atributos
    private JLabel etiqueta1;
    private JTextField cmpDimensionCasillero;
    private JButton btnIniciarJuego;
    
    private JButton btnSalir;
    
    //Constructor

    public InicioJuegoVentana(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarVentana();
    }
    
    private void iniciarVentana(){
        //Definir un layout manager
        //Pone loos elementos en línea, alineados a la izquierda con 10 px de margen
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        //Inicializar los componentes       
        this.etiqueta1 = new JLabel("Introduce dimensión del casillero");
        this.getContentPane().add(this.etiqueta1);
        
        this.cmpDimensionCasillero = new JTextField(30);
        this.getContentPane().add(this.cmpDimensionCasillero);
        
        this.btnIniciarJuego = new JButton("Iniciar juego");
        this.getContentPane().add(this.btnIniciarJuego);
        
        this.btnSalir = new JButton("Salir del juego");
        this.getContentPane().add(this.btnSalir);
        
        //Eventos
        OyenteBtnIniciarJuego oyente = new OyenteBtnIniciarJuego();
        OyenteBotones oyente2 = new OyenteBotones();
        this.btnIniciarJuego.setActionCommand("iniciar");
        this.btnSalir.setActionCommand("salir");
        this.btnIniciarJuego.addActionListener(oyente);//Deshabilitará el boton
        this.btnIniciarJuego.addActionListener(oyente2);//Recogerá el valor del cmp texto y creará la nueva ventana
        this.btnSalir.addActionListener(oyente);
        
        this.pack();
        //this.setSize(200, 200);
    }
    
    public static void main(String[] args) {
        InicioJuegoVentana ventana = new InicioJuegoVentana("Hundir la flota");
        ventana.setVisible(true);
        
    }
    
    //INNER class
    private class OyenteBotones implements ActionListener{
        //Desde aqui hey acceso a los atributos de la clase que la contiene
        @Override
        public void actionPerformed(ActionEvent e) {
            //Leer el campo de dimensión del tablero
            String sDimension = cmpDimensionCasillero.getText();
            System.out.println("Dimensión es " + sDimension);
            int dimension = Integer.parseInt(sDimension);
            
            PanelJuegoVentana p = new PanelJuegoVentana("Hundir la flota", dimension);
            p.setVisible(true);
        }
        
    }//Fin oyentebotones 
}//Fin de la ventana
