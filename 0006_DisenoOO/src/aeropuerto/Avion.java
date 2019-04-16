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
public class Avion extends Vehiculo implements Volable{
    
    private int numeroPasajeros;

    public Avion(int numeroPasajeros, String matricula) {
        super(matricula);
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    @Override
    public void volar() {
        System.out.println("Vuelo con un motor de avión");
    }

    @Override
    public void aterrizar() {
        System.out.println("Aterrizo con el tren de aterrizaje");
    }
    
    
}
