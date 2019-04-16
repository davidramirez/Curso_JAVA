/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Pruebas {
    
    public static void main(String[] args) {
        String snumero = "200 ";
        int num = 0;
        try{
        num = Integer.parseInt(snumero);
        System.out.println("El numero es: " + num);
        }catch (NumberFormatException e){
            System.out.println("No pude convertir el numero a entero");
            System.out.println("Error " + e.getMessage());
        }
        
        num = 10;
        System.out.println("Aqui tras el fallo (o no, claro)");
        
        try{
        double media = 29/1;
            System.out.println("sin fallo de división");
            //return;//Si lo pongo aqui, entra en el finally, pero no imprime lo último
            //System.exit(0);//En este caso si que se salta el finally
        }catch(Exception e){
            System.out.println("Error dividiendo");
            //return;//Si lo pongo, se ejecuta el finally, pero el fin del main al saltar la excepción
        }finally{
            System.out.println(".... entro aquí siempre, ocurra o no la excepción");
        }
        
        System.out.println("Fin del main");
        
        
        File fichero = new File("ee");
        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
