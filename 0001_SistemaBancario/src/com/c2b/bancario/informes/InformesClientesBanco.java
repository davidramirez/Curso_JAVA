package com.c2b.bancario.informes;

//import com.c2b.bancario.modelo.Cliente;
//import com.c2b.bancario.modelo.ClienteOrdenadoPorDNI;
import com.c2b.bancario.modelo.*;
import java.io.File;
public class InformesClientesBanco {
    
    public static void main(String[] args) {
        
        //Ambito en el metodo main
        //      declaran denro de un metodo
        //      se crean en la memoria de pila(stack, automatica)
        //      viven hasta que salimos del metodo
        int numeroClientes = 30; //variable de tipo primitivo
        
        Cliente cliente = new Cliente();//variable de referencia
        cliente.id = 33;
        cliente.nombre = new String("Pepe"); //"Pepe";
        cliente.cuenta = new CuentaBancaria();
        System.out.println("Datos cliente es"+ cliente.id + " - " + cliente.nombre + " - " +cliente.cuenta);
        
        
        System.out.println("Interes "+ CuentaBancaria.interesCuenta);
        
        //forma 2, full qualified name
        //com.c2b.bancario.modelo.Cliente c = new com.c2b.bancario.modelo.Cliente();
        
        ClienteOrdenadoPorDNI orden = new ClienteOrdenadoPorDNI();
        
        File ficheroCarga = new File("informe.txt");
        //ficheroCarga.createNewFile();
        
        
        //Tras el fin del metodo se destruyen las vaiables automaticamente,
        //pero no los objetos, que serán borrados por el recolector de basura
        
    }
    
}
