/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.web.beans;

import java.util.Date;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import juego.dominio.DNI;

/**
 *
 * @author david
 */
@Named(value = "adivina")
@RequestScoped
public class AdivinaManagedBean {

    private int numeroAAdivinar;
    
    private int numero;
    
    private boolean ganador;
    
    private Date fecha;
    
    private DNI dni;
    /**
     * Creates a new instance of AdivinaManagedBean
     */
    public AdivinaManagedBean() {
        
        System.out.println("Instanciando un nuevo adivinaManagedBean....................");
        Random r = new Random();
        this.numeroAAdivinar = r.nextInt(20)+1;
        this.numeroAAdivinar = 5;
        System.out.println("Numero a adivinar: "+this.numeroAAdivinar);
    }

    public int getNumeroAAdivinar() {
        System.out.println("Acceso al getnumeroAAdivinar.............");
        return numeroAAdivinar;
    }

    public int getNumero() {
        System.out.println("Acceso al getNummero.................");
        return numero;
    }

    public void setNumero(int numero) {
        System.out.println("Setnumero.........................");
        this.numero = numero;
    }

    public boolean isGanador() {
        System.out.println("Isganador..............");
        return ganador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DNI getDni() {
        return dni;
    }

    public void setDni(DNI dni) {
        this.dni = dni;
    }
    
    public String adivinar(){
        System.out.println("Adivinando.......");
        this.ganador = this.numero == this.numeroAAdivinar;
        return "resultado";
    }
}
