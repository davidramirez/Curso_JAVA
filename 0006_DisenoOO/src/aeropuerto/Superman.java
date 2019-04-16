/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

/**
 *
 * @author david
 */
public class Superman implements Volable{

    @Override
    public void volar() {
        System.out.println("Soy superman y vuelo sin más");
    }

    @Override
    public void aterrizar() {
        System.out.println("Soy superman y aterrizo suavemente de pie");
    }
    
}
