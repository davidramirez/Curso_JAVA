/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.web.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.regex.Pattern;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author david
 */
@Named(value = "gestionarUsuario")
@ViewScoped
public class GestionarUsuarioManagedBean implements Serializable{
    
    
    private String nombre;
    private String dni;
    private String apellidos;
    
    private boolean dniExiste = false;
    private String msgDni =  "";

    private final HashSet<String> dnis = new HashSet();
    /**
     * Creates a new instance of GestionarUsuarioManagedBean
     */
    public GestionarUsuarioManagedBean() {
        dnis.add("12345678E");
        dnis.add("11111111E");
        dnis.add("22112211E");
        dnis.add("33333333F");
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public boolean isDniExiste() {
        System.out.println("getdniexiste");
        return dniExiste;
    }

    public String getMsgDni() {
        System.out.println("getmsg");
        return msgDni;
    }

    
    public void setDni(String dni) {
        System.out.println("SetDNI");
        //valido
        if(dni != null || Pattern.matches("[0-9]{8}[a-z]", dni)){
            System.out.println("paso dni bueno");
            if(dnis.contains(dni)){
                dniExiste = true;
                msgDni = "ya existe el DNI";
            }else{
                dniExiste = false;
                msgDni = "";
            }
        }else{
            System.out.println("paso dni malo");
                dniExiste = true;
                msgDni = "El dni dado no es válido";
            
        }
        
        
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    //action
    public String grabar(){
        System.out.println("grabando...." + this.dni);
        return null;
    }
    
    //listener de eventos ajax
    public void hacerAlgo(AjaxBehaviorEvent event){
        System.out.println("event" + event.getComponent());
        System.out.println("...dni " + dni);
        
    }
}
