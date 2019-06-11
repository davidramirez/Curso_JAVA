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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "ACCIONESPORACCIONISTA")
@NamedQueries({
    @NamedQuery(name = "AccionDeAccionista.findAll", query = "SELECT a FROM AccionDeAccionista a")
    , @NamedQuery(name = "AccionDeAccionista.findByIdAccion", query = "SELECT a FROM AccionDeAccionista a WHERE a.idAccion = :idAccion")
    , @NamedQuery(name = "AccionDeAccionista.findByIdAccionista", query = "SELECT a FROM AccionDeAccionista a WHERE a.idAccionista = :idAccionista")
    , @NamedQuery(name = "AccionDeAccionista.findByIdAccionIdAccionista", query = "SELECT a FROM AccionDeAccionista a WHERE a.idAccionista = :idAccionista AND a.idAccion = :idAccion")
    , @NamedQuery(name = "AccionDeAccionista.findByCantidad", query = "SELECT a FROM AccionDeAccionista a WHERE a.cantidad = :cantidad")
    , @NamedQuery(name = "AccionDeAccionista.findByValorCompraTotal", query = "SELECT a FROM AccionDeAccionista a WHERE a.valorCompraTotal = :valorCompraTotal")})
public class AccionDeAccionista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ACCION")
    private int idAccion;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ACCIONISTA")
    private int idAccionista;

    @JoinColumn(name = "ID_ACCION", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Accion accion;
    @JoinColumn(name = "ID_ACCIONISTA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Accionista accionista;

    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_COMPRA_TOTAL")
    private Double valorCompraTotal;

    public AccionDeAccionista() {
    }

    public AccionDeAccionista(int idAccion, int idAccionista) {
        this.idAccion = idAccion;
        this.idAccionista = idAccionista;
    }

    public AccionDeAccionista(int idAccion, int idAccionista, Integer cantidad, Double valorCompraTotal) {
        this.idAccion = idAccion;
        this.idAccionista = idAccionista;
        this.cantidad = cantidad;
        this.valorCompraTotal = valorCompraTotal;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public int getIdAccionista() {
        return idAccionista;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public void setIdAccionista(int idAccionista) {
        this.idAccionista = idAccionista;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorCompraTotal() {
        return valorCompraTotal;
    }

    public void setValorCompraTotal(Double valorCompraTotal) {
        this.valorCompraTotal = valorCompraTotal;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public Accionista getAccionista() {
        return accionista;
    }

    public void setAccionista(Accionista accionista) {
        this.accionista = accionista;
    }

    public double getValorMedioCompra() {
        return this.getValorCompraTotal() / this.getCantidad();
    }

    public double getValorActualAccion() {
        return this.getAccion().getValor();
    }

    @Override
    public String toString() {
        return "AccionDeAccionista{" + "idAccion=" + idAccion + ", idAccionista=" + idAccionista + ", cantidad=" + cantidad + ", valorCompraTotal=" + valorCompraTotal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.idAccion;
        hash = 61 * hash + this.idAccionista;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccionDeAccionista other = (AccionDeAccionista) obj;
        if (this.idAccion != other.idAccion) {
            return false;
        }
        if (this.idAccionista != other.idAccionista) {
            return false;
        }
        return true;
    }

}
