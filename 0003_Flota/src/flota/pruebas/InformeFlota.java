/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.pruebas;

import flota.dominio.Barcaza;
import flota.dominio.Caja;
import flota.dominio.Camion;
import flota.dominio.Empresa;
import flota.dominio.Excepciones.CajaExcepcion;
import flota.dominio.Excepciones.VehiculoExcepcion;
import flota.dominio.Vehiculo;

/**
 *
 * @author david
 */
public class InformeFlota {
    
    public static void main(String[] args) {
        try{
            //Crear empresa y añadir vehiculos (barcazas y camiones)
            Vehiculo v1 = new Camion("3456RTY");
            Empresa e = new Empresa("TransportesC2B", v1);
            Vehiculo v2 = new Barcaza("BAQ2345");
            Vehiculo v3 = new Camion("2345GTR");
            Empresa.addVehiculo(v2);
            Empresa.addVehiculo(v3);

            //Añadir más carga a los vehiculos
            v1.cargar(new Caja(300.0));
            v1.cargar(new Caja(400.0));

            v2.cargar(new Caja(1000.0));
            v2.cargar(new Caja(600.0));

            v3.cargar(new Caja(340));
            v3.cargar(new Caja(340));
            v3.cargar(new Caja(340));
            v3.cargar(new Caja(340));
            v3.cargar(new Caja(340));
            //Hacer informe de consumo

            InformeFlota inf = new InformeFlota();
            inf.informeConsumoFuelFlota(e);
        } catch (CajaExcepcion ex){
            System.err.println("Error: " + ex.getMessage());
        } catch (VehiculoExcepcion e){
            System.err.println("Error: " + e.getMessage());
            if(e.getExcesoDePeso() > 0)
            {
                System.err.println("Te has excedido en " + e.getExcesoDePeso()+" kg");
            }
        }
    }
    
    public void informeConsumoFuelFlota(Empresa e){
        System.out.println("******************************************************");
        System.out.println("Informe de consumo de fuel de los vehiculos de la \n empresa " + e.getNombre()+"\n");
        System.out.println("******************************************************");
        
        Vehiculo[] vehiculos = Empresa.getFlotaVehiculos();
        
        for(Vehiculo v:vehiculos){
            System.out.println("Vehiculo de tipo " + v.getClass());
            System.out.println("Matrícula del vehículo: " + v.getMatricula());
            System.out.println("Carga actual del vehiculo: " + v.getCargaActual());
            System.out.println("Consumo del vehiculo: " + v.calcularConsumoFuel() + " L/100km");
            System.out.println("---------------------------------------------------------");
        }
    }
}
