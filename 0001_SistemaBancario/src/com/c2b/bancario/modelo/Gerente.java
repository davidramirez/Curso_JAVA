package com.c2b.bancario.modelo;

public class Gerente extends Empleado{
    
    //hereda los atributos del empleado
    
    
    //adicionales
    
    private double plus;
    
    public Gerente(int id, double plus){
        super(id);
        this.plus=plus;
        this.categoria=5;
    }
}
