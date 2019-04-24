/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class PanelJuegoVentana extends JFrame{
    
    private BotonJuego[] botones;
    private int dimension;
    private JLabel barcosRestantes;
    private JLabel barcosTotales;
    private int numBarcos;

    public PanelJuegoVentana(String title, int dimension) throws HeadlessException {
        super(title);
        botones = new BotonJuego[dimension*dimension];
        barcosRestantes = new JLabel();
        barcosTotales = new JLabel();
        this.dimension = dimension;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        iniciarVentana();
    }
    
    private void iniciarVentana(){
        //Defino un gestor de distribución
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout(10, 10));//(new BoxLayout(c, BoxLayout.Y_AXIS));
        //c.setLayout(new GridLayout(dimension, dimension, 2, 2));
        
        //Creo 2 paneles con sus correspondientes gestores de distribucion
        JPanel panelJuego = new JPanel(new GridLayout(dimension, dimension, 2, 2));
        JPanel panelEstado = new JPanel();//(new FlowLayout(FlowLayout.CENTER));
        panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.Y_AXIS));
        //Y los añado en su sitio en el panel original de la ventana
        c.add(panelJuego, BorderLayout.CENTER);
        c.add(panelEstado, BorderLayout.SOUTH);
        
        //Creo el oyente para los botones
        OyenteBtn oyente = new OyenteBtn();
        //Botones. Crear sin barco, poner listener, añadir al panel de juego y al array
        for(int i = 0; i< botones.length; i++){
            botones[i] = new BotonJuego(false);
            panelJuego.add(botones[i]);
            botones[i].addActionListener(oyente);
        }
        
        //Establecer el num de barcos del juego
        numBarcos = botones.length/3;
        //Establecer las etiquetas de estado
        barcosTotales.setText("Num de barcos: " + numBarcos);
        barcosRestantes.setText("Num de barcos restantes: " + numBarcos);
        panelEstado.add(barcosTotales);
        panelEstado.add(barcosRestantes);
        
        //programar que 10 botones sean true
        //int numBarcos = 10;
        //Programar que un tercio de los botones sean true
        //Crear los barcos aleatorios
        int auxNumBarcos = numBarcos;
        for(int i = 0;i<auxNumBarcos;i++){
            //generar num de 0 a botones.length
            int num = new Random().nextInt(botones.length);
            if(botones[num].hayBarco()){//Ya hay un barco, probar otra vez
                auxNumBarcos++;
            }else{
                botones[num].setHayBarco(true);
            }
        }
        
        //this.pack();
        this.setSize(numBarcos*30+80, numBarcos*30+80);
    }
    
    
    private class OyenteBtn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Mirar si tiene barco
            BotonJuego b = (BotonJuego) e.getSource();
            if(b.hayBarco()){
                b.setText("X");
                numBarcos--;
                barcosRestantes.setText("Num de barcos restantes: " + numBarcos);
                
                if(numBarcos==0){
                    for(BotonJuego bj:botones){
                        bj.setEnabled(false);
                    }
                    JOptionPane.showMessageDialog(b.getParent(), "¡Has hundido todos los barcos!");
                }
            }else{
                b.setText("o");
            }
            
            b.setEnabled(false);
        }
        
    }
}
