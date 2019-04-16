/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import selva.Aguila;
import selva.Gallina;

/**
 *
 * @author david
 */
public class Aeropuerto {
    public static void main(String[] args) {
        Avion jumbo = new Avion(200, "22FF");
        Superman sm = new Superman();
        
        Gallina g = new Gallina();
        Aguila ag = new Aguila();
        
        Aeropuerto a = new Aeropuerto();
        a.autorizarVuelo(jumbo);
        a.autorizarVuelo(sm);
        a.autorizarVuelo(g);
        a.autorizarVuelo(ag);
    }
    
    public void autorizarVuelo(Volable v)
    {
        v.volar();
        v.aterrizar();
    }
}
