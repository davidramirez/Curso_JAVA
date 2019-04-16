/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.igualdad;

/**
 *
 * @author SISTEMAS
 */
public class Empleado {

    private int identidicador;
    private String nombre;
    private boolean activo;

    public Empleado() {
        super();
    }
    
    public Empleado(int identidicador, String nombre, boolean activo) {
        this.identidicador = identidicador;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getIdentidicador() {
        return identidicador;
    }

    public void setIdentidicador(int identidicador) {
        this.identidicador = identidicador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    //Métodos object

    @Override
    public String toString() {
        return "Empleado{" + "identidicador=" + identidicador + ", nombre=" + nombre + ", activo=" + activo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.identidicador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.identidicador != other.identidicador) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
