/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestorRoles.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.gestorRoles.web.beans.AppManagedBean;

/**
 *
 * @author david
 */
@Stateless
public class RolesService implements RolesServiceLocal {

    @Inject
    private AppManagedBean miAppManagedBean;

    @Override
    public List<String> getListaRoles() {
        return miAppManagedBean.getRoles();
    }

    @Override
    public Collection<String> getListaUsuariosEnRol(String rol) {
        Map<String, Set<String>> mapa = miAppManagedBean.getUsuariosRoles();
        if (mapa.containsKey(rol)) {
            return mapa.get(rol);
        }

        return null;
    }

    @Override
    public Collection<String> getListaUsuariosNoEnRol(String rol) {
        Map<String, Set<String>> mapa = miAppManagedBean.getUsuariosRoles();
        if (mapa.containsKey(rol)) {
            List<String> usuariosNoRol = new ArrayList<>();
            for (String u : miAppManagedBean.getUsuarios()) {
                if (!mapa.get(rol).contains(u)) {
                    usuariosNoRol.add(u);
                }
            }
            return usuariosNoRol;
        } else {
            return miAppManagedBean.getUsuarios();
        }
    }

    @Override
    public void addUsuarioAGrupo(String usuario, String rol) {
        Map<String, Set<String>> mapa = miAppManagedBean.getUsuariosRoles();
        if (!mapa.containsKey(rol)) {
            mapa.put(rol, new TreeSet<String>());
        }

        mapa.get(rol).add(usuario);
    }

    @Override
    public void deleteUsuarioDeGrupo(String usuario, String rol) {
        Map<String, Set<String>> mapa = miAppManagedBean.getUsuariosRoles();
        mapa.get(rol).remove(usuario);
    }

}
