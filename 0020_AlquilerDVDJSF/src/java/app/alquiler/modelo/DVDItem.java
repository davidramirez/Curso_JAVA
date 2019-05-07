/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.alquiler.modelo;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class DVDItem implements Serializable{
    
    private int id;
    private String titulo;
    private String genero;
    private boolean alquilado;

    public DVDItem() {
        this.alquilado = false;
    }

    public DVDItem(int id, String titulo, String genero, boolean alquilado) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.alquilado = alquilado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    @Override
    public String toString() {
        return "DVDItem{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", alquilado=" + alquilado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
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
        final DVDItem other = (DVDItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
