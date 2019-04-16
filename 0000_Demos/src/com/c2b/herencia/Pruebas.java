/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.herencia;

/**
 *
 * @author SISTEMAS
 */
public class Pruebas {
    public static void main(String[] args) {
        
        Empleado e = new Empleado("algo", 3000);
        Gerente g = new Gerente("fwe", 5000, "Secretaria");
        
        System.out.println("e " + e.getDetalles());
        System.out.println("g " + g.getDetalles());
        
        Empleado[] lista = new Empleado[4];
        lista[0] = e;
        lista[1] = g;
        lista[2] = new Empleado("d", 34);
        lista[3] = new Jefe();
        
        for(Empleado emp: lista){
            System.out.println(emp.getDetalles());
            if(emp instanceof Gerente)
            {
                Gerente g2 = (Gerente) emp;
                g2.mandar();
            }
        }
        
        System.out.println("\n.......................Nóminas...........................\n");
        for(Empleado emp: lista){
            NominasService.generarNomina(emp);
        }
    }
}
