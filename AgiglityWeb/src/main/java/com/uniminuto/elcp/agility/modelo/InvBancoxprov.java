/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "inv_bancoxprov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvBancoxprov.findAll", query = "SELECT i FROM InvBancoxprov i"),
    @NamedQuery(name = "InvBancoxprov.findByBxpId", query = "SELECT i FROM InvBancoxprov i WHERE i.bxpId = :bxpId"),
    @NamedQuery(name = "InvBancoxprov.findByBxpNumcuenta", query = "SELECT i FROM InvBancoxprov i WHERE i.bxpNumcuenta = :bxpNumcuenta"),
    @NamedQuery(name = "InvBancoxprov.findByBxpEstado", query = "SELECT i FROM InvBancoxprov i WHERE i.bxpEstado = :bxpEstado"),
    @NamedQuery(name = "InvBancoxprov.findByIndversion", query = "SELECT i FROM InvBancoxprov i WHERE i.indversion = :indversion"),
    @NamedQuery(name = "InvBancoxprov.findByBxeAplica", query = "SELECT i FROM InvBancoxprov i WHERE i.bxeAplica = :bxeAplica")})
public class InvBancoxprov implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bxp_id")
    private Long bxpId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bxp_numcuenta")
    private long bxpNumcuenta;
    @Column(name = "bxp_estado")
    private Boolean bxpEstado;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "bxe_aplica")
    private Boolean bxeAplica;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne
    private InvProovedor prvId;
    @JoinColumn(name = "bnc_id", referencedColumnName = "bnc_id")
    @ManyToOne(optional = false)
    private RfBanco bncId;
    @JoinColumn(name = "tct_id", referencedColumnName = "tct_id")
    @ManyToOne(optional = false)
    private RfTipocuenta tctId;

    public InvBancoxprov() {
    }

    public InvBancoxprov(Long bxpId) {
        this.bxpId = bxpId;
    }

    public InvBancoxprov(Long bxpId, long bxpNumcuenta) {
        this.bxpId = bxpId;
        this.bxpNumcuenta = bxpNumcuenta;
    }

    public Long getBxpId() {
        return bxpId;
    }

    public void setBxpId(Long bxpId) {
        this.bxpId = bxpId;
    }

    public long getBxpNumcuenta() {
        return bxpNumcuenta;
    }

    public void setBxpNumcuenta(long bxpNumcuenta) {
        this.bxpNumcuenta = bxpNumcuenta;
    }

    public Boolean getBxpEstado() {
        return bxpEstado;
    }

    public void setBxpEstado(Boolean bxpEstado) {
        this.bxpEstado = bxpEstado;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public Boolean getBxeAplica() {
        return bxeAplica;
    }

    public void setBxeAplica(Boolean bxeAplica) {
        this.bxeAplica = bxeAplica;
    }

    public InvProovedor getPrvId() {
        return prvId;
    }

    public void setPrvId(InvProovedor prvId) {
        this.prvId = prvId;
    }

    public RfBanco getBncId() {
        return bncId;
    }

    public void setBncId(RfBanco bncId) {
        this.bncId = bncId;
    }

    public RfTipocuenta getTctId() {
        return tctId;
    }

    public void setTctId(RfTipocuenta tctId) {
        this.tctId = tctId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bxpId != null ? bxpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvBancoxprov)) {
            return false;
        }
        InvBancoxprov other = (InvBancoxprov) object;
        if ((this.bxpId == null && other.bxpId != null) || (this.bxpId != null && !this.bxpId.equals(other.bxpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvBancoxprov[ bxpId=" + bxpId + " ]";
    }
    
}
