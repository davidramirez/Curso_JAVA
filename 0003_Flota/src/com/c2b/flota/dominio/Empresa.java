/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.flota.dominio;

/**
 *
 * @author SISTEMAS
 */
public class Empresa {
    
    private String nombre;
    private Vehiculo[] vehiculos;
    private int numVehiculos;
    private static final int MAX_VEHICULOS = 3;
    
    public Empresa(String nombre){
        this.nombre = nombre;
        this.vehiculos = new Vehiculo[MAX_VEHICULOS];
        this.vehiculos[0] = new Vehiculo();
        this.numVehiculos = 1;
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }
    
    /**
     * Añade el vehiculo si entra
     * @param vehiculo 
     * @return true si el vehiculo se ha podido añadir. False en caso contrario
     */
    public boolean addVehiculo(Vehiculo vehiculo)
    {
        if(this.numVehiculos < MAX_VEHICULOS)
        {
            //añadir
            this.vehiculos[this.numVehiculos] = vehiculo;
            this.numVehiculos++;
            return true;
        }
        return false;
    }
    
    public Vehiculo[] getFlota(){
        return this.vehiculos;
    }

    public int getNumVehiculos() {
        return this.numVehiculos;
    }
}
