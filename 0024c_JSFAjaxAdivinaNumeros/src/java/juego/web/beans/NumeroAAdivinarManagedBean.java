/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.web.beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author david
 */
@ManagedBean(name = "numeroAAdivinar")
@SessionScoped
public class NumeroAAdivinarManagedBean implements Serializable {

    private int numero;
    /**
     * Creates a new instance of NumeroAAdivinarManagedBean
     */
    public NumeroAAdivinarManagedBean() {
        generaNumerro();
    }

    public int getNumero() {
        return numero;
    }
    
    public void generaNumerro(){
        Random r = new Random();
        this.numero = r.nextInt(10)+1;
    }
}
