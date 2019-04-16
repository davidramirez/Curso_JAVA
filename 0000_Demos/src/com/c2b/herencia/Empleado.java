/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.herencia;

import java.util.Date;

/**
 *
 * @author SISTEMAS
 */
public class Empleado {

    protected String nombre;
    protected double salario;
    protected Date fechaNacimiento;
    
    public Empleado(){
        this("",0);
    }
    
    public Empleado(String nombre, double salario){
        this.nombre = nombre;
        this.salario = salario;
        this.fechaNacimiento = new Date();
    }
    
    public String getDetalles(){
        return "nombre: " + nombre
                + ", salario " + salario
                + ", fecha de nacimiento " + fechaNacimiento.toLocaleString();
    }
    
    public double calcularSalario(){
        return salario*1.2;
    }
    
    public final String getNombre(){
        return this.nombre;
    }
}
