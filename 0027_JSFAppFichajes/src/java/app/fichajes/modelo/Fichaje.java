/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author david
 */
public class Fichaje implements Serializable{
    
    private int id;
    private int idEmpleado;
    private char tipo;
    private Timestamp fechaHora;

    public Fichaje() {
    }

    public Fichaje(int id, int idEmpleado, char tipo, Timestamp fechaHora) {
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

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
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
    
    public String getHora(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(fechaHora);//TODO mejorar tratamiento de las fecha horas a string
    }
    
    public String getFecha(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaHora);//TODO mejorar tratamiento de las fecha horas a string
    }
}
