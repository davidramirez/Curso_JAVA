/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.web.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "partida")
@RequestScoped
public class PartidaManagedBean {
    
    private int numeroEnvioParaAdivinar;
    
    @Inject
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
        this.numeroEnvioParaAdivinar = numeroEnvioParaAdivinar;
    }

    public int getNumeroEnvioParaAdivinar() {
        return numeroEnvioParaAdivinar;
    }
    
    public String iniciarJuego(){
        this.numeroEnvioParaAdivinar = 0;
        this.numeroAAdivinar.generaNumerro();
        
        return null;
    }
    
    public String adivinar(){
        if(this.numeroEnvioParaAdivinar == this.numeroAAdivinar.getNumero()){
            System.out.println("Lo has adivinado!");
        }else{
            System.out.println("Vuelve a intentarlo");
        }
        return null;
    }
}
