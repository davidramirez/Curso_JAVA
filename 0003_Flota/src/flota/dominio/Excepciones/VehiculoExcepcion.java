/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio.Excepciones;

/**
 *
 * @author SISTEMAS
 */
public class VehiculoExcepcion extends Exception{

    private double excesoDePeso;
    
    public VehiculoExcepcion(String message) {
        super(message);
    }

    public double getExcesoDePeso() {
        return excesoDePeso;
    }

    public void setExcesoDePeso(double excesoDePeso) {
        this.excesoDePeso = excesoDePeso;
    }
    
    
    
}
