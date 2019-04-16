
package com.c2b.bancario.modelo;

public class Empleado {
    
    //Modificadores de visibilidad
    private int id;
    public String nombre;
    private String apellidos;
    protected int categoria;//PROTECTED: clases del mismo paquete o clases que hereden/hijas que esten o no en el mismo paquete
    double salario;//default o package
    
    public Empleado(int id){
        this.id=id;
    }
    
    public int getId(){
        return this.id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }
    
    
}
