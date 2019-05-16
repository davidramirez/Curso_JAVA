/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.modelo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author david
 */
public class Fichaje implements Serializable{
    
    private int id;
    private int idEmpleado;
    private char tipo;
    private Date fechaHora;

    public Fichaje() {
    }

    public Fichaje(int id, int idEmpleado, char tipo, Date fechaHora) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public char getTipo() {
        return tipo;
    }
    
    public String getTipoEnString(){
        if(tipo == 'S')
            return "salida";
        else
            return "entrada";
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
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
        final Fichaje other = (Fichaje) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
