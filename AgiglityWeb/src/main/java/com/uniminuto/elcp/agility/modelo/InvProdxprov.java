/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "inv_prodxprov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProdxprov.findAll", query = "SELECT i FROM InvProdxprov i"),
    @NamedQuery(name = "InvProdxprov.findByPxvId", query = "SELECT i FROM InvProdxprov i WHERE i.pxvId = :pxvId"),
    @NamedQuery(name = "InvProdxprov.findByPxvEst", query = "SELECT i FROM InvProdxprov i WHERE i.pxvEst = :pxvEst"),
    @NamedQuery(name = "InvProdxprov.findByPxvPrecioact", query = "SELECT i FROM InvProdxprov i WHERE i.pxvPrecioact = :pxvPrecioact"),
    @NamedQuery(name = "InvProdxprov.findByPxvFecultprecio", query = "SELECT i FROM InvProdxprov i WHERE i.pxvFecultprecio = :pxvFecultprecio")})
public class InvProdxprov implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pxv_id")
    private Long pxvId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pxv_est")
    private boolean pxvEst;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pxv_precioact")
    private BigDecimal pxvPrecioact;
    @Column(name = "pxv_fecultprecio")
    @Temporal(TemporalType.DATE)
    private Date pxvFecultprecio;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne
    private InvMarca marId;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne
    private InvPresentprod pspId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private InvProducto prdId;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne
    private InvProovedor prvId;

    public InvProdxprov() {
    }

    public InvProdxprov(Long pxvId) {
        this.pxvId = pxvId;
    }

    public InvProdxprov(Long pxvId, boolean pxvEst) {
        this.pxvId = pxvId;
        this.pxvEst = pxvEst;
    }

    public Long getPxvId() {
        return pxvId;
    }

    public void setPxvId(Long pxvId) {
        this.pxvId = pxvId;
    }

    public boolean getPxvEst() {
        return pxvEst;
    }

    public void setPxvEst(boolean pxvEst) {
        this.pxvEst = pxvEst;
    }

    public BigDecimal getPxvPrecioact() {
        return pxvPrecioact;
    }

    public void setPxvPrecioact(BigDecimal pxvPrecioact) {
        this.pxvPrecioact = pxvPrecioact;
    }

    public Date getPxvFecultprecio() {
        return pxvFecultprecio;
    }

    public void setPxvFecultprecio(Date pxvFecultprecio) {
        this.pxvFecultprecio = pxvFecultprecio;
    }

    public InvMarca getMarId() {
        return marId;
    }

    public void setMarId(InvMarca marId) {
        this.marId = marId;
    }

    public InvPresentprod getPspId() {
        return pspId;
    }

    public void setPspId(InvPresentprod pspId) {
        this.pspId = pspId;
    }

    public InvProducto getPrdId() {
        return prdId;
    }

    public void setPrdId(InvProducto prdId) {
        this.prdId = prdId;
    }

    public InvProovedor getPrvId() {
        return prvId;
    }

    public void setPrvId(InvProovedor prvId) {
        this.prvId = prvId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pxvId != null ? pxvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProdxprov)) {
            return false;
        }
        InvProdxprov other = (InvProdxprov) object;
        if ((this.pxvId == null && other.pxvId != null) || (this.pxvId != null && !this.pxvId.equals(other.pxvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvProdxprov[ pxvId=" + pxvId + " ]";
    }
    
}
