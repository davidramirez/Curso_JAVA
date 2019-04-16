/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.flota.dominio;

/**
 * Clase que modela un vehiculo de una flota de transporte.
 * Tiene la capacidad de cargar cajas
 * 
 * @author SISTEMAS
 * @version 1.0
 */
public class Vehiculo {

    private double cargaMaxima;
    
    /**
     * Atributo que representa la carrga actual del vehiculo en kilogramos.
     * No puede superar la carga máxima del vehiculo y no puede tener valores negativos.
     */
    private double cargaActual;
    private String matricula;
    private int numCajas;
    private Caja[] cajas;
    private int maxCajas;
    
    public Vehiculo(){
        this.cargaMaxima = 2000;
        this.cargaActual = 0;
        this.matricula = "";
        this.numCajas = 0;
        this.maxCajas = 5;
        this.cajas = new Caja[this.maxCajas];
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public double getCargaActual() {
        return cargaActual;
    }
    
    /**
     * Método que recibe el peso de un a caja a cargar y añade esta carga al vehiculo
     * incrementando el número de cajas cargadas en 1
     * @param peso - peso en kg de la caja
     */
    public void cargar(double peso){
        if (peso > 0 && cargaMaxima >= (cargaActual + peso)){
            cargaActual += peso;
            numCajas ++;
        }
    }

    @Override
    public String toString() {
        return "Matricula: " + this.matricula + " carga max: " + this.cargaMaxima +" Carga actual: " + this.cargaActual;
    }
    
    
}
