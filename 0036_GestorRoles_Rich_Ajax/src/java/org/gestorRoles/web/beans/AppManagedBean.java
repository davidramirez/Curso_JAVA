/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestorRoles.web.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author david
 */
@Named(value = "app")
@ApplicationScoped
public class AppManagedBean {
    
    private List<String> roles;
    private List<String> usuarios;
    private Map<String, Set<String>> usuariosRoles;

    /**
     * Creates a new instance of AppManagedBean
     */
    public AppManagedBean() {
        this.roles = new ArrayList<>();
        this.roles.add("ADMIN");
        this.roles.add("RRHH");
        this.roles.add("LOGÍSTICA");
        this.roles.add("CAMIONEROS");
        
        this.usuarios = new ArrayList<>();
        this.usuarios.add("Pepe");
        this.usuarios.add("Ana");
        this.usuarios.add("Mario");
        this.usuarios.add("Maria");
        this.usuarios.add("Luis");
        this.usuarios.add("David");
        this.usuarios.add("Geralt");
        this.usuarios.add("Gandalf");
        
        this.usuariosRoles = new HashMap<>();
    }

    public List<String> getRoles() {
        return roles;
    }

    public List<String> getUsuarios() {
        return usuarios;
    }

    public Map<String, Set<String>> getUsuariosRoles() {
        return usuariosRoles;
    }
    
    
}
