/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.ascensor.dominio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import com.c2b.ascensor.excepciones.AscensorException;
import com.c2b.ascensor.excepciones.ExcesoPasajerosException;
import com.c2b.ascensor.excepciones.ExcesoPesoException;
import com.c2b.ascensor.excepciones.PlantaInexistenteException;

/**
 *
 * @author SISTEMAS
 */
public class AscensorTest {
    
    Ascensor ascensor;
    
    public AscensorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try{
            int maxPers = 5;
            double maxPeso = 400;
            int plantaAlta = 10;
            int plantaBaja = -3;
            //int numPlantas = 14;
            ascensor = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
        }catch(AscensorException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void PruebaCrearAscensorValido() {
        try{
            int maxPers = 5;
            double maxPeso = 400;
            int plantaAlta = 10;
            int plantaBaja = -3;
            int numPlantas = 14;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            assertFalse(asc == null);
            assertEquals(maxPers, asc.getMaxPersonas());
            assertEquals(maxPeso, asc.getMaxPeso(),0);
            assertEquals(numPlantas, asc.getNumPlantas());
        }catch(AscensorException e){
            fail("Falló la creación del objeto");
        }
    }
    
    @org.junit.Test
    public void PruebaCrearAscensorNoValidoMaxPersNegativo() {
        try{
            int maxPers = -5;
            double maxPeso = 400;
            int plantaAlta = 10;
            int plantaBaja = -3;
            int numPlantas = 14;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            fail("Se creó el ascensor cuando no se esperaba");
        }catch(AscensorException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @org.junit.Test
    public void PruebaCrearAscensorNoValidoMaxPesoNegativo() {
        try{
            int maxPers = 5;
            double maxPeso = -400;
            int plantaAlta = 10;
            int plantaBaja = -3;
            int numPlantas = 14;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            fail("Se creó el ascensor cuando no se esperaba");
        }catch(AscensorException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @org.junit.Test
    public void PruebaCrearAscensorNoValidoIntervaloPlantasNoValido() {
        try{
            int maxPers = 5;
            double maxPeso = 400;
            int plantaAlta = 10;
            int plantaBaja = 13;
            int numPlantas = 14;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            fail("Se creó el ascensor cuando no se esperaba");
        }catch(AscensorException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @org.junit.Test
    public void PruebaCrearAscensorNoValidoUnaPlanta() {
        try{
            int maxPers = 5;
            double maxPeso = 400;
            int plantaAlta = 10;
            int plantaBaja = 9;
            int numPlantas = 14;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            fail("Se creó el ascensor cuando no se esperaba");
        }catch(AscensorException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @org.junit.Test
    public void PruebaEntrarUnaPersona() {
        Persona p1 = new Persona(70.0);
        ascensor.entrar(p1);
        assertEquals(70.0, ascensor.getPesoActual(),0);
        assertEquals(1, ascensor.getNumPasajeros());
    }
    
    @org.junit.Test
    public void PruebaEntrarMasDeUnaPersona() {
        Persona p1 = new Persona(70.0);
        ascensor.entrar(p1);
        assertEquals(70.0, ascensor.getPesoActual(),0);
        assertEquals(1, ascensor.getNumPasajeros());
        Persona p2 = new Persona(80.0);
        ascensor.entrar(p2);
        assertEquals(150.0, ascensor.getPesoActual(),0);
        assertEquals(2, ascensor.getNumPasajeros());
    }
    
    @org.junit.Test
    public void PruebaSalirAscensorCargado() {
        try{    
            Persona p1 = new Persona(70.0);
            ascensor.entrar(p1);

            ascensor.salir(p1);
            assertEquals(0, ascensor.getNumPasajeros());
            assertEquals(0.0, ascensor.getPesoActual(),0);
        }catch(AscensorException e){
            fail("Se tiene que poder descargar una persona");
        }
    }
    
    @org.junit.Test
    public void PruebaSalirAscensorVacio() {
        try{    
            Persona p1 = new Persona(70.0);

            ascensor.salir(p1);
            fail("No se tiene que haber podido descargar una persona");
        }catch(AscensorException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    @org.junit.Test
    public void PruebaGetNumPlantasPosYNeg() {
        assertEquals(14, ascensor.getNumPlantas());
    }
    
    @org.junit.Test
    public void PruebaGetNumPlantasPosYPos() {
        try{
            int maxPers = 5;
            double maxPeso = 400;
            int plantaAlta = 10;
            int plantaBaja = 3;
            int numPlantas = 8;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            
            assertEquals(numPlantas, asc.getNumPlantas());
        }catch(AscensorException e){
            fail("Se tiene que poder crear el ascensor");
        }
    }
    
    
    @org.junit.Test
    public void PruebaGetNumPlantasNegYNeg() {
        try{
            int maxPers = 5;
            double maxPeso = 400;
            int plantaAlta = -4;
            int plantaBaja = -11;
            int numPlantas = 8;
            Ascensor asc = new Ascensor(maxPers, maxPeso, plantaAlta, plantaBaja);
            
            assertEquals(numPlantas, asc.getNumPlantas());
        }catch(AscensorException e){
            fail("Se tiene que poder crear el ascensor");
        }
    }
    
    @org.junit.Test
    public void PruebaIrAplantaCorrecto() {
        try{    
            ascensor.irAPlanta(7);
            assertEquals(7, ascensor.getPlantaActual());
        }catch(ExcesoPesoException | ExcesoPasajerosException | PlantaInexistenteException e){
            fail("El ascensor debería ir a la planta dada sin problemas");
        }
    }
    
    @org.junit.Test
    public void PruebaIrAplantaFalloPlanta() {
        try{    
            ascensor.irAPlanta(33);
            fail("No debería poder ir a la planta dada");
        }catch(ExcesoPesoException | ExcesoPasajerosException e){
            fail("No deberían saltar estas excepciones en el test");
        }catch(PlantaInexistenteException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    @org.junit.Test
    public void PruebaIrAplantaExcesoPersonas() {
        try{    
            Persona p = new Persona(20.0);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.irAPlanta(3);
            fail("No debería poder ir a la planta dada");
        }catch(ExcesoPesoException | PlantaInexistenteException e){
            fail("No deberían saltar estas excepciones en el test");
        }catch(ExcesoPasajerosException e){
            System.out.println("Error: "+e.getMessage());
            assertEquals(2, e.getExcesoPasajeros());
        }
    }
    
    @org.junit.Test
    public void PruebaIrAplantaExcesoPeso() {
        try{    
            Persona p = new Persona(100.0);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.entrar(p);
            ascensor.irAPlanta(3);
            fail("No debería poder ir a la planta dada");
        }catch(ExcesoPasajerosException | PlantaInexistenteException e){
            fail("No deberían saltar estas excepciones en el test");
        }catch(ExcesoPesoException e){
            System.out.println("Error: "+e.getMessage());
            assertEquals(300.0, e.getExcesoPeso(),0);
        }
    }
}
