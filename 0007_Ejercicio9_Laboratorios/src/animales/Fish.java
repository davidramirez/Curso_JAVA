/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

/**
 *
 * @author david
 */
public class Fish extends Animal implements Pet{
    
    private String name;

    public Fish() {
        super(0);
        this.name = "";
    }

    @Override
    public void eat() {
        System.out.println("Como cosas del rio o mar");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Juego poco");
    }

    @Override
    public void walk() {
        System.out.println("Soy un pez, no ando, nado");
    }

    @Override
    public void tirarCosas() {
        System.out.println("Tiro el castillo del acuario");
    }
    
    
}
