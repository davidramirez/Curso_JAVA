/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selva;

/**
 *
 * @author david
 */
public class Gallina extends Ave{

    public Gallina() {
        super(false);
    }

    
    @Override
    public void comer() {
        System.out.println("Como pienso y picoteo en el campo");
    }

    @Override
    public void volar() {
        System.out.println("No puedo volar");
    }

    @Override
    public void aterrizar() {
        System.out.println("Si no vuelo, no aterrizo");
    }
    
}
