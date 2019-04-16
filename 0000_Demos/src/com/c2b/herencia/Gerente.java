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
//Nadie puede heredar de esta clase
public final class Gerente extends Empleado {
    
    protected String departamento;
    
    public Gerente(String nombre, double salario, String departamento){
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    @Override
    public String getDetalles() {
        return super.getDetalles() +", departamento "+ this.departamento;
    }
    
    public void mandar(){
        System.out.println("Mando mucho");
    }

    @Override
    public double calcularSalario() {
        return salario*2;
    }
    
    
    
}
