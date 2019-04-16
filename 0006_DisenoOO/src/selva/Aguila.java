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
public class Aguila extends Ave{

    public Aguila() {
        super(true);
    }

    @Override
    public void comer() {
        System.out.println("Cazo lo que pille al vuelo y ratones y conejos");}

    @Override
    public void volar() {
        System.out.println("Vuelo muy rápido tirandome de un sitio alto");}

    @Override
    public void aterrizar() {
        System.out.println("Aterrizo com mis patas en ramas o en el suelo");}
    
}
