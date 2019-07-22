/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestorRoles.servicios;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author david
 */
@Local
public interface RolesServiceLocal {
    
    public List<String> getListaRoles();
    public Collection<String> getListaUsuariosEnRol(String rol);
    public Collection<String> getListaUsuariosNoEnRol(String rol);
    public void addUsuarioAGrupo(String usuario, String rol);
    public void deleteUsuarioDeGrupo(String usuario, String rol);
}
