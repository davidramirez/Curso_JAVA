/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.dominio;

import flota.dominio.Excepciones.CajaExcepcion;
import flota.dominio.Excepciones.VehiculoExcepcion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SISTEMAS
 */
public class VehiculoTest {
    
    Vehiculo v;
    
    public VehiculoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Se ejecuta una vez");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            System.out.println("Antes del bloque de pruebas");
            v = new Camion("222AA", (short) 3, 300);
        } catch (VehiculoExcepcion ex) {
            fail("No se pudo crear el vehiculo");
        }
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void probarCargarCajaVehiculoLleno(){
        //Datos preparacion - Llenar el vehiculo
        //Admite 3 cajas y hasta 300kg
        try {
            v.cargar(new Caja(20));
            v.cargar(new Caja(20));
            v.cargar(new Caja(20));
        } catch (CajaExcepcion | VehiculoExcepcion ex) {
            fail("No se pudo crear las cajas o llenar el camion");
        }
        
        try {
            //RESULTADO
            //Se espera que salte la excepcion al cargar una caja más

            v.cargar(new Caja(30));
            fail("Se ha cargado la caja cuando se esperaba que no entrara");
        } catch (CajaExcepcion ex) {
            fail("No se pudo crear las cajas");
        } catch (VehiculoExcepcion ex) {
            //éxito
        }
        
        //Asegurar que sigue habiendo 3 cajas
        assertEquals(3, v.getNumCajas());
    }
    
    @Test
    public void probarCargarCajaSuperaCargaMaxPermitida(){
        //Datos preparacion - Llenar el vehiculo
        //Admite 3 cajas y hasta 300kg
        //meto 1 caja de 240
        try {
            v.cargar(new Caja(240));
        } catch (CajaExcepcion | VehiculoExcepcion ex) {
            fail("No se pudo crear las cajas o cargar el camion");
        }
        
        try {
            //RESULTADO
            //Se espera que salte la excepcion al cargar una caja más

            v.cargar(new Caja(200));
            fail("Se ha cargado la caja cuando se esperaba que no entrara");
        } catch (CajaExcepcion ex) {
            fail("No se pudo crear las cajas");
        } catch (VehiculoExcepcion ex) {
            //éxito
            if(ex.getExcesoDePeso()==0){
                fail("No se ha indicado el exceso de peso");
            }
            else{
                assertEquals(140, ex.getExcesoDePeso(),0.0);   
            }
        }
        
        //Asegurar que sigue habiendo una caja
        assertEquals(1, v.getNumCajas());
    }
    
    @Test
    public void probarCargarCajaEnUnVehiculoVacio1CajaNoExcedeCargaMaxPermitida(){
        //Datos preparacion - Llenar el vehiculo
        //Admite 3 cajas y hasta 300kg
        //meto 1 caja de 240
        try {
            v.cargar(new Caja(240));
        } catch (CajaExcepcion | VehiculoExcepcion ex) {
            fail("No se pudo crear las cajas o cargar el camion");
        }
        
        //Asegurar hay 2 cajas y el peso son 260
        assertEquals(1, v.getNumCajas());
        assertEquals(240, v.getCargaActual(), 0.0);
    }
    
    @Test
    public void probarCargarCajaEnUnVehiculoNoVacio1CajaNoExcedeCargaMaxPermitida(){
        //Datos preparacion - Llenar el vehiculo
        //Admite 3 cajas y hasta 300kg
        //meto 1 caja de 240
        try {
            v.cargar(new Caja(240));
            
            //RESULTADO
            //Se espera que cargue la caja de 20kg
            v.cargar(new Caja(20));
        } catch (CajaExcepcion | VehiculoExcepcion ex) {
            fail("No se pudo cargar la caja");
        }
        
        //Asegurar hay 2 cajas y el peso son 260
        assertEquals(2, v.getNumCajas());
        assertEquals(260, v.getCargaActual(), 0.0);
    }
    
}
