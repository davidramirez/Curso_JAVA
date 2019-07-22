/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestorRoles.web.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.gestorRoles.servicios.RolesServiceLocal;
import org.richfaces.event.DropEvent;

/**
 *
 * @author david
 */
@Named(value = "gestorRoles")
@ViewScoped
public class GestorRolesManagedBean implements Serializable{
    
    private String rolSeleccionado;
    
    @EJB
    private RolesServiceLocal servicio;

    /**
     * Creates a new instance of GestorRolesManagedBean
     */
    public GestorRolesManagedBean() {
    }

    public String getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(String rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }
    
    public Collection<String> getListaRoles(){
        return servicio.getListaRoles();
    }
    
    public Collection<String> getListaUsuariosEnRol(){
        if(rolSeleccionado != null)
            return servicio.getListaUsuariosEnRol(rolSeleccionado);
        
        return null;
    }
    
    public Collection<String> getListaUsuariosNoEnRol(){
        if(rolSeleccionado != null)
            return servicio.getListaUsuariosNoEnRol(rolSeleccionado);
        
        return null;
    }
    
    public void dragListenerListaUsuariosNoRol(DropEvent ev){
        System.out.println("Drag de rol a usuario");
        String usuario = (String) ev.getDragValue();
        
        servicio.deleteUsuarioDeGrupo(usuario, rolSeleccionado);
    }
    
    public void dragListenerListaUsuariosEnRol(DropEvent ev){
        System.out.println("Drag de usuario a rol");
        String usuario = (String) ev.getDragValue();
        
        servicio.addUsuarioAGrupo(usuario, rolSeleccionado);
    }
}
