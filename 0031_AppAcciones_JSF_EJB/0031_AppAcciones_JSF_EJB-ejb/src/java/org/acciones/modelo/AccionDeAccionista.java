/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.modelo;

/**
 *
 * @author david
 */
public class AccionDeAccionista {
    
    private int idAccion;
    private String nombreAccion;
    private int idAccionista;
    private int cantidad;
    private double valorCompraTotal;
    private double valorActualAccion;
    private double valorMedioCompra;

    public AccionDeAccionista() {
    }

    public AccionDeAccionista(int idAccion, String nombreAccion, int idAccionista, int cantidad, double valorActual, double valorCompraTotal) {
        this.idAccion = idAccion;
        this.nombreAccion = nombreAccion;
        this.idAccionista = idAccionista;
        this.cantidad = cantidad;
        this.valorActualAccion = valorActual;
        this.valorCompraTotal = valorCompraTotal;
        this.valorMedioCompra = this.valorCompraTotal/this.cantidad;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }

    public int getIdAccionista() {
        return idAccionista;
    }

    public void setIdAccionista(int idAccionista) {
        this.idAccionista = idAccionista;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorCompraTotal() {
        return valorCompraTotal;
    }

    public void setValorCompraTotal(double valorCompraTotal) {
        this.valorCompraTotal = valorCompraTotal;
    }

    public double getValorMedioCompra() {
        return valorMedioCompra;
    }

    public void setValorMedioCompra(double valorMedioCompra) {
        this.valorMedioCompra = valorMedioCompra;
    }

    public double getValorActualAccion() {
        return valorActualAccion;
    }

    public void setValorActualAccion(double valorActualAccion) {
        this.valorActualAccion = valorActualAccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idAccion;
        hash = 29 * hash + this.idAccionista;
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
        final AccionDeAccionista other = (AccionDeAccionista) obj;
        if (this.idAccion != other.idAccion) {
            return false;
        }
        if (this.idAccionista != other.idAccionista) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccionDeAccionista{" + "idAccion=" + idAccion + ", nombreAccion=" + nombreAccion + ", idAccionista=" + idAccionista + ", cantidad=" + cantidad + ", valorCompraTotal=" + valorCompraTotal + ", valorMedioCompra=" + valorMedioCompra + '}';
    }
    
}
