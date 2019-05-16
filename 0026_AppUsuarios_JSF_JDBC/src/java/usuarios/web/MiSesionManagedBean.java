/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import usuarios.modelo.Usuario;
import usuarios.servicios.GestionarUsuariosServicio;

/**
 *
 * @author david
 */
@Named(value = "miSesion")
@SessionScoped
public class MiSesionManagedBean implements Serializable {
    

    /**
     * Creates a new instance of UsuariosManagedBean
     */
    public MiSesionManagedBean() {
    }
}
