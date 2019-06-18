 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acciones.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "ACCIONISTAS")
@NamedQueries({
    @NamedQuery(name = "Accionista.findAll", query = "SELECT a FROM Accionista a")
    , @NamedQuery(name = "Accionista.findAllExceptId", query = "SELECT a FROM Accionista a WHERE a.id != :id")
    , @NamedQuery(name = "Accionista.findById", query = "SELECT a FROM Accionista a WHERE a.id = :id")
    , @NamedQuery(name = "Accionista.findByNombre", query = "SELECT a FROM Accionista a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Accionista.findByClave", query = "SELECT a FROM Accionista a WHERE a.clave = :clave")
    , @NamedQuery(name = "Accionista.findByNombreClave", query = "SELECT a FROM Accionista a WHERE a.clave = :clave AND a.nombre = :nombre")})
public class Accionista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    //@Size(min = 1, max = 25)
    @Column(name = "CLAVE")
    private String clave;
    @OneToMany(mappedBy = "accionista", fetch = FetchType.LAZY)
    private Collection<AccionDeAccionista> accionDeAccionistaCollection;

    public Accionista() {
    }

    public Accionista(Integer id) {
        this.id = id;
    }

    public Accionista(Integer id, String nombre, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Collection<AccionDeAccionista> getAccionDeAccionistaCollection() {
        return accionDeAccionistaCollection;
    }

    public void setAccionDeAccionistaCollection(Collection<AccionDeAccionista> accionDeAccionistaCollection) {
        this.accionDeAccionistaCollection = accionDeAccionistaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accionista)) {
            return false;
        }
        Accionista other = (Accionista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.acciones.modelo.ent.Accionista[ id=" + id + " ]";
    }

}
