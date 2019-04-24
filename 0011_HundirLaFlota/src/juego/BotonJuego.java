/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import javax.swing.JButton;

/**
 *
 * @author david
 */
public class BotonJuego extends JButton{
    
    private boolean hayBarco;

    public BotonJuego(boolean hayBarco) {
        this.hayBarco = hayBarco;
    }
    
    public boolean hayBarco(){
        return this.hayBarco;
    }
    
    public void setHayBarco(boolean hayBarco){
        this.hayBarco = hayBarco;
    }
}
