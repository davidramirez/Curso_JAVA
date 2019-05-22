/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.servicios;

import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class CalculadoraSessionBean implements CalculadoraSessionBeanLocal {

    @Override
    public double sumar(double i, double j) {
        return i + j;
    }

    @Override
    public double restar(double i, double j) {
        return i - j;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
