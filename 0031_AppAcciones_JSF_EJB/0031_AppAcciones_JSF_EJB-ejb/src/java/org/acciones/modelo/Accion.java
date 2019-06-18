/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author david
 */
@Entity
@Table(name = "ACCIONES")
@NamedQueries({
    @NamedQuery(name = "Accion.findAll", query = "SELECT a FROM Accion a")
    , @NamedQuery(name = "Accion.findById", query = "SELECT a FROM Accion a WHERE a.id = :id")
    , @NamedQuery(name = "Accion.findByNombre", query = "SELECT a FROM Accion a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Accion.findByValor", query = "SELECT a FROM Accion a WHERE a.valor = :valor")
    , @NamedQuery(name = "Accion.findAccionesByAccionista", query = "SELECT b FROM AccionDeAccionista b JOIN b.accion a WHERE b.idAccionista = :idAccionista")})
public class Accion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    //@Size(min = 1, max = 25)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "accion", fetch = FetchType.LAZY)
    //private Collection<AccionDeAccionista> accionDeAccionistaCollection;
    @Column(name = "VERSION")
    @Version
    private int version;

    public Accion() {
    }

    public Accion(Integer id) {
        this.id = id;
    }

    public Accion(Integer id, String nombre, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

//    public Collection<AccionDeAccionista> getAccionDeAccionistaCollection() {
//        return accionDeAccionistaCollection;
//    }
//
//    public void setAccionDeAccionistaCollection(Collection<AccionDeAccionista> accionDeAccionistaCollection) {
//        this.accionDeAccionistaCollection = accionDeAccionistaCollection;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accion)) {
            return false;
        }
        Accion other = (Accion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.acciones.modelo.ent.Accion[ id=" + id + " ]";
    }

}
