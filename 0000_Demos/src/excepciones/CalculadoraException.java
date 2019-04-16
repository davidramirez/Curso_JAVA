/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author david
 */
public class CalculadoraException extends Exception{
    
    private String miMensaje;

    public CalculadoraException(String miMensaje, String message) {
        super(message);
        this.miMensaje = miMensaje;
    }

    public String getMiMensaje() {
        return miMensaje;
    }
    
    
    
}
