/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.oca;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class Dado extends JPanel{
    private final static int NUM_MAX_DADO= 6;
    private JLabel dado;

    public Dado() {
        this.dado = new JLabel();
        this.add(this.dado);
    }
    
    public int lanzarDado(){
        //Lanzar un dado y mostrar en la etiqueta
        int num = new Random().nextInt(NUM_MAX_DADO)+1;
        dado.setIcon(new ImageIcon("imagenes/dado/"+num+".png"));
        return num;
    }
    
}
