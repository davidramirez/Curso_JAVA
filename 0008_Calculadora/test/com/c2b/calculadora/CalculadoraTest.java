/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2b.calculadora;

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
public class CalculadoraTest {
    
    Calculadora c;
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //una vez para hacer todos los test
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Cada vez, antes de ejecutar un test
        c = new Calculadora();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suma method, of class Calculadora.
     */
    @Test
    public void testSuma() {
        
        //Datos de prueba
        //Datos esperados
        int n1 = 9;
        int n2 = 10;
        int resEsp = 19;
        
        Calculadora c = new Calculadora();
        
        int res = c.suma(n1, n2);
        assertEquals(resEsp, res);
    }

    /**
     * Test of divide method, of class Calculadora.
     */
    @Test
    public void testDivideDivisorNoCero() {
        int dividendo = 10;
        int divisor = 2;
        int resEsp = 5;
        
        int res = c.divide(dividendo, divisor);
        assertEquals(resEsp, res);
    }
    
    @Test
    public void testDivideDivisorCero() {
        int dividendo = 10;
        int divisor = 0;
        int resEsp = 0;
        
        int res = c.divide(dividendo, divisor);
        assertEquals(resEsp, res);
    }
    
    
    
}
