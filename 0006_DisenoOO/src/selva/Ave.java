/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selva;

import aeropuerto.Volable;

/**
 *
 * @author david
 */
public abstract class Ave extends Animal implements Volable{
    
    public boolean puedeVolar;

    public Ave(boolean puedeVolar) {
        super(2);
        this.puedeVolar = puedeVolar;
    }

    @Override
    public void desplazarse(){
        if(puedeVolar){
            System.out.println("Me desplazo volando");
        }else{
            System.out.println("Me desplazo dando saltitos");
        }
    }
    
    
    
}
