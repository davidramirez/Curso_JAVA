/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web.beans;

import demo.servicios.CalculadoraSessionBean;
import demo.servicios.CalculadoraSessionBeanLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author david
 */
@Named(value = "calculadoraManagedBean")
@RequestScoped
public class CalculadoraManagedBean implements Serializable{

    private double i;
    private double j;
    
    private double resultado;
    
    @EJB
    private CalculadoraSessionBeanLocal calculadora;
    /**
     * Creates a new instance of CalculadoraManagedBean
     */
    public CalculadoraManagedBean() {
        System.out.println("Calculadora es " + calculadora);
    }
    
    @PostConstruct//para cualquier clase que inyecte cosas
    public void hazAlgo(){
        System.out.println("Calculadora es " + calculadora);
    }
    
    @PreDestroy
    public void terminaAlgo(){
        System.out.println("Recogiendo cosas.....");
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

    public double getResultado() {
        return resultado;
    }
    
    public String sumar(){
        resultado = calculadora.sumar(i, j);
        return null;
    }
    
    public String restar(){
        resultado = calculadora.restar(i, j);
        return null;
    }
}
