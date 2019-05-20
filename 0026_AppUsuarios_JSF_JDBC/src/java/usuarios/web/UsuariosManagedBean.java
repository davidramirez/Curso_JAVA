/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios.web;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import usuarios.modelo.Usuario;
import usuarios.servicios.EjemploServicio;
import usuarios.servicios.GestionarUsuariosServicio;
import usuarios.servicios.excepciones.UsuarioException;

/**
 *
 * @author david
 */
@Named(value = "usuarios")
@SessionScoped
public class UsuariosManagedBean implements Serializable {

    @Inject
    private GestionarUsuariosServicio gestionarUsuariosServicio;

    private Usuario usuario = new Usuario();

    private boolean modoEditar = false;

    private boolean dniValido = true;
    private String dniViejo = null;

    /**
     * Creates a new instance of UsuariosManagedBean
     */
    public UsuariosManagedBean() {
    }

    public void setGestionarUsuariosServicio(GestionarUsuariosServicio gestionarUsuariosServicio) {
        this.gestionarUsuariosServicio = gestionarUsuariosServicio;
    }

    public GestionarUsuariosServicio getGestionarUsuariosServicio() {
        return gestionarUsuariosServicio;
    }

    public List<Usuario> getLista() {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            return this.gestionarUsuariosServicio.getListaUsuarios();
        } catch (UsuarioException ex) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ex.getMessage()));
            return null;
        }
    }

    public String grabarUsuario() {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {//TODO añadir comprobacion del DNI
            if (this.modoEditar) {
                this.gestionarUsuariosServicio.actualizarUsuario(usuario);
                faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado el usuario", "Se ha modificado el usuario " + usuario.getNombre() + " con éxito"));
            } else {
                this.gestionarUsuariosServicio.crearNuevoUsuario(usuario);
                faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha creado el nuevo usuario", "Se ha creado el nuevo usuario " + usuario.getNombre() + " con éxito"));
            }
            return "index";
        } catch (UsuarioException ex) {
            if (modoEditar) {
                faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "No se ha podido modificar el usuario", "No se ha podido modificar el usuario. " + ex.getMessage()));
            } else {
                faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "No se ha podido crear el nuevo usuario", "No se ha podido crear el nuevo usuario. " + ex.getMessage()));
            }
            return "null";
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isDniValido() {
        return dniValido;
    }

    public boolean isModoEditar() {
        return modoEditar;
    }

    public void existeDNI(AjaxBehaviorEvent ev) {
        FacesContext faces = FacesContext.getCurrentInstance();
        System.out.println("Ajax");
        if (this.gestionarUsuariosServicio.existeDNI(usuario.getDni())) {
            //En caso de modificar, mirar si es el viejo. si no lo es, está repetido y no es correcto
            if (this.dniViejo != null && this.dniViejo.equals(usuario.getDni())) {
                this.dniValido = true;

                //Usando mensajes de error de facescontext
                //TODO Aqui el uso de ids para mensajes "usuarioform:"+ev.getComponent().getId()
                faces.addMessage("usuarioform:"+ev.getComponent().getId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "El DNI está repetido", "El DNI está repetido"));
            } else {
                this.dniValido = false;
            }
        } else {
            this.dniValido = true;
        }
    }

    public String irACrearUsuario() {
        this.modoEditar = false;
        this.usuario = new Usuario();
        this.dniViejo = null;
        return "usuario";
    }

    public String irAEditarUsuario(int id) {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            this.modoEditar = true;
            this.usuario = this.gestionarUsuariosServicio.buscarUsuarioPorId(id);
            this.dniViejo = this.usuario.getDni();
            return "usuario";
        } catch (UsuarioException ex) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se ha podido modificar el usuario", "No se ha podido modificar el usuario. " + ex.getMessage()));
            return "null";
        }
    }

    public String eliminarUsuario(int id) {
        FacesContext faces = FacesContext.getCurrentInstance();
        try {
            this.gestionarUsuariosServicio.eliminarUsuario(id);
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Se ha eliminado el usuario", "Se ha eliminado el usuario con ID " + id));
        } catch (UsuarioException ex) {
            faces.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se ha podido eliminar el usuario", "No se ha podido eliminar el usuario. " + ex.getMessage()));
        }
        return null;
    }

    
    //PRUEBA POOL
    @Inject
    private EjemploServicio ejemploServicio;

    public void setEjemploServicio(EjemploServicio ejemploServicio) {
        this.ejemploServicio = ejemploServicio;
    }
    
    public String botonHazAlgo(){
        try {
            ejemploServicio.hazAlgo();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
