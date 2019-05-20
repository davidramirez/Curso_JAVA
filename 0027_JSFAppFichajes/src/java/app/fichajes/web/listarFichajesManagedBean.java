/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.fichajes.web;

import app.fichajes.modelo.Empleado;
import app.fichajes.modelo.Fichaje;
import app.fichajes.servicio.GestionarEmpleadosServicio;
import app.fichajes.servicio.GestionarFichajesServicio;
import app.fichajes.servicio.excepciones.EmpleadoExcepcion;
import app.fichajes.servicio.excepciones.FichajeExcepcion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "listarFichajes")
@SessionScoped
public class listarFichajesManagedBean implements Serializable {

    private Empleado empleadoSeleccionado;
    private int idEmpleadoSeleccionado;
    private List<Fichaje> listaFichajesEmpleado;

    @Inject
    private GestionarEmpleadosServicio gestionarEmpleadosServicio;
    @Inject
    private GestionarFichajesServicio gestionarFichajesServicio;

    /**
     * Creates a new instance of listarFichajesManagedBean
     */
    public listarFichajesManagedBean() {
    }

    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public int getIdEmpleadoSeleccionado() {
        return idEmpleadoSeleccionado;
    }

    public void setIdEmpleadoSeleccionado(int idEmpleadoSeleccionado) {
        this.idEmpleadoSeleccionado = idEmpleadoSeleccionado;
    }

    public List<Fichaje> getListaFichajesEmpleado() {
        return listaFichajesEmpleado;
    }

    public void setGestionarEmpleadosServicio(GestionarEmpleadosServicio gestionarEmpleadosServicio) {
        this.gestionarEmpleadosServicio = gestionarEmpleadosServicio;
    }

    public void setGestionarFichajesServicio(GestionarFichajesServicio gestionarFichajesServicio) {
        this.gestionarFichajesServicio = gestionarFichajesServicio;
    }

    public List<SelectItem> getListaEmpleadosPorNombreApellido() {
        FacesContext fc = FacesContext.getCurrentInstance();
        List<SelectItem> items = new ArrayList();
        try {
            List<Empleado> empleados = this.gestionarEmpleadosServicio.getListaEmpleadosOrdenadoNombre();
            //Preparar la lista de selectitems para el desplegable
            for (Empleado e : empleados) {
                items.add(new SelectItem(e.getId(), e.getNombre() + " " + e.getApellido()));
            }
        } catch (EmpleadoExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, ex.getMessage(), ex.getMessage()));
        }
        if (items.isEmpty()) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay empleados en el sistema", "No hay empleados en el sistema"));
        }
        return items;
    }

    public String mostrarFichajesEmpleado() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            //Con el id del empleado, volver a buscarlo en la bd para mostrar su nombre
            this.empleadoSeleccionado = this.gestionarEmpleadosServicio.buscarEmpleadoPorId(this.idEmpleadoSeleccionado);
            this.listaFichajesEmpleado = this.listaFichajesEmpleado();
        } catch (EmpleadoExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, ex.getMessage(), ex.getMessage()));
        }
        return null;
    }

    private List<Fichaje> listaFichajesEmpleado() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            List<Fichaje> lista = this.gestionarFichajesServicio.obtenerFichajesEmpleado(this.idEmpleadoSeleccionado);//.getId());
            if (lista.isEmpty()) {
                fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El empleado seleccionado no tiene fichajes", "El empleado seleccionado no tiene fichajes"));
            }
            return lista;
        } catch (FichajeExcepcion ex) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, ex.getMessage(), ex.getMessage()));
        }
        return new ArrayList<Fichaje>();//vacia si hay fallo
    }
}
