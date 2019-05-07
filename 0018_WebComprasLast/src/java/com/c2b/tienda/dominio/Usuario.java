/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.tienda.dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author david
 */
public class Usuario implements Serializable{//interface que indica al contenedor que el objeto se puede "pasivar" en disco duro
                                            //Si no, "not serializable exception" cuando los intenta guardar en disco duro, ademas de perder los datos
                                            //El contenedor pide a la JVM que serialice
    static final long serialVersionUID = 1L; //Para casos que se serialicen objetos para mandarlos por la red
    
    private String nombre;
    private String clave;

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", clave=" + clave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.clave);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
