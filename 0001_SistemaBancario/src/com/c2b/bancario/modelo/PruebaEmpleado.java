/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.bancario.modelo;

/**
 *
 * @author SISTEMAS
 */
public class PruebaEmpleado {
    public static void main(String[] args) {
        Empleado e = new Empleado(2);
        e.setApellidos("Botella");
        System.out.println("id es " + e.getId());
        
        e.categoria = 3;
        System.out.println("apellido " + e.getApellidos());
    }
}
