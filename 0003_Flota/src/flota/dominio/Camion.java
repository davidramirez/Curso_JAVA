/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio;

import flota.dominio.Excepciones.VehiculoExcepcion;

/**
 *
 * @author david
 */
public class Camion extends Vehiculo{

    public Camion(String matricula) {
        super(matricula);
    }
    
    public Camion(){
        this("2345DCF");
    }

    public Camion(String matricula, short totalCajasPermitidas, double cargaMaxPermitida) throws VehiculoExcepcion {
        super(matricula, totalCajasPermitidas, cargaMaxPermitida);
    }

    @Override
    public double calcularConsumoFuel() {
        return Math.pow((100+this.getCargaActual()),1.1)/50;
    }
    
}
