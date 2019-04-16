/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.pruebas;

import flota.dominio.Camion;
import flota.dominio.Empresa;
import flota.dominio.Vehiculo;

/**
 *
 * @author SISTEMAS
 */
public class PruebaEmpresa {
    
    public static void main(String[] args) {
        
        //Prueba que se ha creado un array con un solo vehiculo
        System.out.println("Tiene que haber un vehiculo antes de instanciar empresas");
        Vehiculo[] flota = Empresa.getFlotaVehiculos();
        imprimirVehiculos(flota);
        
        Empresa e1 = new Empresa("ABC");
    
        Empresa e2 = new Empresa("XXX");
        
        //Prueba que se ha creado un array con un solo vehiculo
        System.out.println("Tiene que haber un vehiculo");
        flota = Empresa.getFlotaVehiculos();
        imprimirVehiculos(flota);
        
        
        
        //Añadir vehiculos
        System.out.println("Tiene que haber 2 vehiculos");
        Empresa.addVehiculo(new Camion("5555H"));
        imprimirVehiculos(Empresa.getFlotaVehiculos());
        
        
        //Comprobar que ambas empresas tienen los mismos vehiculos
        System.out.println("----------------una----------------");
        imprimirVehiculos(e1.getFlotaVehiculos());
        
        System.out.println("----------------dos----------------");
        imprimirVehiculos(e2.getFlotaVehiculos());
        
    }
    
    private static void imprimirVehiculos(Vehiculo[] vehiculos){
        for(Vehiculo v:vehiculos)
        {
            System.out.println(v);
        }
    }
    
}
