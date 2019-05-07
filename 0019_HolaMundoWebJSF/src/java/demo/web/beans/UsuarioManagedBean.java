/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.web.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author david
 */
@Named(value = "usuario")
@SessionScoped //Al ponerlo en sesion hay que hacer serializable el objeto
                //Ámbito por defecto es request
public class UsuarioManagedBean implements Serializable
{

    private String nombre;//Se necesitan sus getters y setters
    private String clave;
    /**
     * Creates a new instance of UsuarioManagedBean
     * 
     * Constructor necesario sin argumentos
     */
    public UsuarioManagedBean() {
        System.out.println("Instanciando un  ManagedBean Usuario");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //Métodos llamados desde los action de los botones
    public String login(){
        //Aqui ya ha llamado a los sets correspondientes
        //Nombre y clave tienen los atributos del formulario
        System.out.println("...hola " + nombre);
        
        return "inicio";//=~ como el forward a otro jsp
    }
}
