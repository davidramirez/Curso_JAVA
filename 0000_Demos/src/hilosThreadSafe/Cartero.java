/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosThreadSafe;

/**
 *
 * @author david
 */
public class Cartero implements Runnable{
    
    private String nombre;
    private Buzon buzon;

    public Cartero(String nombre, Buzon buzon) {
        this.nombre = nombre;
        this.buzon = buzon;
    }

    public String getNombre() {
        return nombre;
    }
    
    

    @Override
    public void run() {
        for(int i=0; i<25; i++){
            System.out.println("\t\tCartero " + nombre+ " intenta sacar carta");
            String carta = buzon.sacarCarta();
            if(carta != null){
                System.out.println("\t\t\tCartero "+ nombre+" saca la carta: "+carta);
            }
        }
    }
    
    
}
