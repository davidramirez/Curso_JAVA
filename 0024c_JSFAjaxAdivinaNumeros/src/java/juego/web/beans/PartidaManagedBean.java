/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.web.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@ManagedBean(name = "partida")
@ViewScoped
public class PartidaManagedBean implements Serializable{
    
    private int numeroEnvioParaAdivinar;
    
    private String resultado ="";
    
    @ManagedProperty(value = "#{numeroAAdivinar}")
    private NumeroAAdivinarManagedBean numeroAAdivinar;

    /**
     * Creates a new instance of PartidaManagedBean
     */
    public PartidaManagedBean() {
    }

    public void setNumeroAAdivinar(NumeroAAdivinarManagedBean numeroAAdivinar) {
        this.numeroAAdivinar = numeroAAdivinar;
    }

    public void setNumeroEnvioParaAdivinar(int numeroEnvioParaAdivinar) {
        System.out.println("Has entrado en setnumeroenvioaadivinar");
        this.numeroEnvioParaAdivinar = numeroEnvioParaAdivinar;
        this.adivinar();//Para ejecutar la "llamada ajax" sin hacer un listener
    }

    public int getNumeroEnvioParaAdivinar() {
        return numeroEnvioParaAdivinar;
    }

    public String getResultado() {
        System.out.println("Has entrado en get resultado");
        return resultado;
    }
    
    public String iniciarJuego(){
        this.numeroEnvioParaAdivinar = 0;
        this.numeroAAdivinar.generaNumerro();
        
        this.resultado = "";//no requerido, ámbito de request
        
        return null;
    }
    
    public String adivinar(){
        if(this.numeroEnvioParaAdivinar == this.numeroAAdivinar.getNumero()){
            resultado = "Lo has adivinado!";
        }else{
            resultado = "Vuelve a intentarlo";
        }
        return null;
    }
}
