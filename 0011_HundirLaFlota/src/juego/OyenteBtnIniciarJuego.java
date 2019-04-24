/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class OyenteBtnIniciarJuego implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Has hecho click en el botón " + btn.getText());
        System.out.println("action command " + e.getActionCommand());//Si no tienen action command, devvuelve el texto del elemento
        if(e.getActionCommand().equals("iniciar")){
            //btn.setEnabled(false);
        }else{
            System.exit(0);
        }
    }
    
}
