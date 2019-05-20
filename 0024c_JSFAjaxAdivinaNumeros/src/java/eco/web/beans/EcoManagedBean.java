/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.web.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author david
 */
@Named(value = "eco")
@ViewScoped
public class EcoManagedBean implements Serializable{

    private String nombre;
    /**
     * Creates a new instance of EcoManagedBean
     */
    public EcoManagedBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getSaludar(){
        return "hola " +nombre;
    }
    
}
