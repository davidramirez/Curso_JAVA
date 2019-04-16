/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.pruebas;

import flota.dominio.Caja;
import flota.dominio.Excepciones.CajaExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SISTEMAS
 */
public class PruebasCaja {
    public static void main(String[] args) {
        try {
            Caja c = new Caja(100);
            
            c.setPeso(-1);
        } catch (CajaExcepcion ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
