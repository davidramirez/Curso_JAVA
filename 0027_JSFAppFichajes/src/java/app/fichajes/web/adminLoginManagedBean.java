/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "adminLogin")
@RequestScoped
public class adminLoginManagedBean {

    String dni;
    String clave;

    @Inject
    private AdminSesionManagedBean adminSesionManagedBean;

    /**
     * Creates a new instance of adminLoginManagedBean
     */
    public adminLoginManagedBean() {
    }

    public void setAdminSesionManagedBean(AdminSesionManagedBean adminSesionManagedBean) {
        this.adminSesionManagedBean = adminSesionManagedBean;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public String getDni() {
        return dni;
    }

    public String autenticar() {
        return adminSesionManagedBean.autenticarAdmin(dni, clave);
    }
}
