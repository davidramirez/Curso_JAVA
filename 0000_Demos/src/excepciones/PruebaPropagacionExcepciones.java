/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author david
 */
public class PruebaPropagacionExcepciones {
    public static void main(String[] args) {
        try {
            InformeFlota f = new InformeFlota();
            
            f.crearInforme(1);
        } catch (Exception ex) {
            System.out.println("No creo informe " + ex.getMessage());
        }
        
        Calculadora cal = new Calculadora();
        try {
            //int a = cal.sumar(null, null);//Excepcion silenciosa, no avisa de su captura (con la runtime exception
            int a = cal.sumar(null, null);
        } catch (CalculadoraException ex) {
            System.out.println(ex.getMessage() + ex.getMiMensaje());
        }
    }
}

class Calculadora{
    
    public double dividir(int n1, int n2) throws Exception{
        if(n2 == 0){
            System.out.println("Es cero");
            throw new Exception("n2 es cero. No se puede dividor por 0");
        }
        return n1 / n2;
    }
    
    public int sumar(Integer n1, Integer n2) throws CalculadoraException{
        if(n1 == null || n2 == null)
        {
            //throw new RuntimeException("numeros null");//Excepción silenciosa. No avisa al que use el método que puede ocurrir
            throw new CalculadoraException("No puedo sumar, algun numero es null", "");
        }
        return n1+n2;
    }
}

class InformeFlota{
        
    int totalFuel = 200;
        
    public void crearInforme(int totalCamiones) throws Exception{
        
        System.out.println("Media de fuel consumido");
        Calculadora cal = new Calculadora();
        
//        try {
            cal.dividir(totalFuel, totalCamiones);
//        } catch (Exception ex) {
//            System.out.println("....ERROR " + ex.getMessage());
//        }
    }
}