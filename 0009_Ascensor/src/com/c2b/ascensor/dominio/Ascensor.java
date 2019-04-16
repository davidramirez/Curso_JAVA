/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.ascensor.dominio;

import com.c2b.ascensor.excepciones.AscensorException;
import com.c2b.ascensor.excepciones.ExcesoPasajerosException;
import com.c2b.ascensor.excepciones.ExcesoPesoException;
import com.c2b.ascensor.excepciones.PlantaInexistenteException;

/**
 *
 * @author SISTEMAS
 */
public class Ascensor {
    
    private final int NUM_MAX_PASAJEROS;
    private int numPasajerosActual;
    private final double PESO_MAX;
    private double pesoActual;
    private final int PLANTA_ALTA;
    private final int PLANTA_BAJA;
    private int plantaActual;

    /**
     * Crea un ascensor con los parámetros indicados. La diferencia entre PLANTA_ALTA y PLANTA_BAJA 
     * (tiene que ser mayor que 1) determina el número de plantas que tendrá el ascensor.
     * 
     * Ej.:
     * Una PLANTA_ALTA de 10 y una PLANTA_BAJA de 1 dará un ascensor con 10 plantas comprendidas en [1, 10].
     * Una PLANTA_ALTA de 10 y una PLANTA_BAJA de 0 dará un ascensor con 11 plantas comprendidas en [0, 10].
     * Una PLANTA_ALTA de 10 y una PLANTA_BAJA de -3 dará un ascensor con 14 plantas comprendidas en [-3, 10].
     * Una PLANTA_ALTA de -3 y una PLANTA_BAJA de -8 dará un ascensor con 6 plantas comprendidas en [1, 10].
     * 
     * @param NUM_MAX_PASAJEROS El número máximo de pasajeros que pueden montar en el ascensor. Tiene que ser positivo.
     * @param PESO_MAX El peso máximo soportado por el ascensor. Tiene que ser positivo.
     * @param PLANTA_ALTA El nº de planta hasta el que subirá el ascensor
     * @param PLANTA_BAJA El nº de planta hasta el que bajará el ascensor. Tiene que ser menor que PLANTA_ALTA
     * @throws AscensorException Si NUM_MAX_PASAJEROS o PESO_MAX son negativos, PLANTA_BAJA es mayor que 
     * PLANTA_ALTA o la diferencia entre PLANTA_ALTA y PLANTA_BAJA es igual a 1.
     */
    public Ascensor(int NUM_MAX_PASAJEROS, double PESO_MAX, int PLANTA_ALTA, int PLANTA_BAJA) throws AscensorException{
        if(NUM_MAX_PASAJEROS <= 0){
            throw new AscensorException("El número máximo de pasajeros del ascensor tiene que ser mayor que 0");
        }
        this.NUM_MAX_PASAJEROS = NUM_MAX_PASAJEROS;
        this.numPasajerosActual = 0;
        
        if(PESO_MAX <= 0){
            throw new AscensorException("El peso máximo soportado por el ascensor tiene que ser mayor que 0");
        }
        this.PESO_MAX = PESO_MAX;
        this.pesoActual = 0;
        if(PLANTA_ALTA-PLANTA_BAJA <= 0){
            throw new AscensorException("La planta más baja no puede ser mayor o igual que la más alta");
        }else if(PLANTA_ALTA-PLANTA_BAJA + 1 == 1){
            throw new AscensorException("El ascensor tiene que tener más de una planta");
        }
        this.PLANTA_ALTA = PLANTA_ALTA;
        this.PLANTA_BAJA = PLANTA_BAJA;
        this.plantaActual = 0;
    }

    public int getNumPasajeros() {
        return numPasajerosActual;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public int getPlantaActual() {
        return plantaActual;
    }
    
    /**
     * Carga a la persona en el ascensor sin hacer comprobaciones.
     * @param p1 La persona a cargar.
     */
    public void entrar(Persona p1) {
        this.pesoActual += p1.getPeso();
        this.numPasajerosActual++;
    }

    /**
     * Saca a la persona indicada del ascensor.
     * @param p1 La persona a sacar.
     * @throws AscensorException Si se pide sacar a una persona cuando no quedan.
     */
    public void salir(Persona p1) throws AscensorException{
        if(this.numPasajerosActual == 0){
            throw new AscensorException("No quedan más pasajeros que descargar");
        }
        
        //Si el peso de la pers de param es mayor que el peso actual?
        
        this.numPasajerosActual--;
        this.pesoActual -= p1.getPeso();
    }

    public int getMaxPersonas() {
        return NUM_MAX_PASAJEROS;
    }

    public double getMaxPeso() {
        return PESO_MAX;
    }

    /**
     * Devuelve el número de plantas por las que se mueve el ascensor.
     * @return El número de plantas por las que se mueve el ascensor.
     */
    public int getNumPlantas() {
        /*//Si la planta mas alta es positiva o 0 y la planta mas baja es negativa o 0,
        //el num de plantas es alta-baja +1 (se cuenta la planta 0)
        if(this.PLANTA_ALTA >= 0 && this.PLANTA_BAJA <= 0){
            return this.PLANTA_ALTA - this.PLANTA_BAJA + 1;
        }else{
            return this.PLANTA_ALTA - this.PLANTA_BAJA;
        }*/
        return this.PLANTA_ALTA - this.PLANTA_BAJA + 1;
    }
    
    /**
     * Mueve el ascensor a la planta indicada si se cumplen las condiciones para ello.
     * @param numPlanta El número de planta a la que dirigirse.
     * @throws ExcesoPesoException Si el peso actual del ascensor supera su máximo permitido.
     * @throws ExcesoPasajerosException Si el número de pasajeros actual supera el máximo permitido.
     * @throws PlantaInexistenteException Si la planta indicada no es alcanzable por el ascensor.
     */
    public void irAPlanta(int numPlanta) throws ExcesoPesoException, ExcesoPasajerosException, PlantaInexistenteException{
        //Exceso de peso
        if(this.pesoActual > this.PESO_MAX){
            throw new ExcesoPesoException(this.pesoActual-this.PESO_MAX, "El peso total excede el máximo permitido");
        }
        //Exceso de pasajeros
        if(this.numPasajerosActual > this.NUM_MAX_PASAJEROS){
            throw new ExcesoPasajerosException(this.numPasajerosActual-this.NUM_MAX_PASAJEROS, 
                    "El número de pasajeros actual excede el máximo permitido");
        }
        //Planta incorrecta
        if(numPlanta > this.PLANTA_ALTA || numPlanta < this.PLANTA_BAJA){
            throw new PlantaInexistenteException("La planta dada es incorrecta. No está "
                    + "comprendida entre "+this.PLANTA_BAJA+" y "+this.PLANTA_ALTA);
        }
        
        this.plantaActual = numPlanta;
    }
}
