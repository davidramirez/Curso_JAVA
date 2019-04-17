/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author begonaolea
 */
public class Empresa {
    
    private String nombre;
    private static HashMap<String, Vehiculo> vehiculos;
    
    static{
        vehiculos = new HashMap();
        vehiculos.put("AAAA", new Camion("AAAA"));
    }

    //constructores
    
    public Empresa(){
        this("TRANSPORTES YYY");
    }
    
    public Empresa(String nombre) {
        this.nombre = nombre;
    }
    
    public Empresa(String nombre, Vehiculo vehiculoInicial) {
        this.nombre = nombre;
        //Añadir el vehiculo
        vehiculos.put(vehiculoInicial.getMatricula(), vehiculoInicial);
    }
     
    public String getNombre() {
        return " ** " + nombre.toUpperCase();
    }
    
    //Devuelve un array del tamaño adecuado
    public static Vehiculo[] getFlotaVehiculos(){
        Vehiculo[] v = new Vehiculo[vehiculos.size()];
        return vehiculos.values().toArray(v);
    }
    
    public static int getNumVehiculosDisponibles(){
        return vehiculos.size();
    }
    
    public static void addVehiculo(Vehiculo v){
        //validar no null
        if(v != null){
            vehiculos.put(v.getMatricula(), v);
        }
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", vehiculos=" + vehiculos + ", numeroVehiculos=" + getNumVehiculosDisponibles() + '}';
    }
}
