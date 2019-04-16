/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio;

/**
 *
 * @author david
 */
public class Barcaza extends Vehiculo{

    public Barcaza(String matricula) {
        super(matricula);
    }
    
    public Barcaza(){
        this("AEO345");
    }
    

    @Override
    public double calcularConsumoFuel() {
        return Math.pow((100+this.getCargaActual()),1.25)/100;
    }
    
}
