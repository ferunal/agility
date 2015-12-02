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
@Table(name = "bancoxempresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancoxempresa.findAll", query = "SELECT b FROM Bancoxempresa b"),
    @NamedQuery(name = "Bancoxempresa.findByBxeId", query = "SELECT b FROM Bancoxempresa b WHERE b.bxeId = :bxeId"),
    @NamedQuery(name = "Bancoxempresa.findByBxeNumcuenta", query = "SELECT b FROM Bancoxempresa b WHERE b.bxeNumcuenta = :bxeNumcuenta"),
    @NamedQuery(name = "Bancoxempresa.findByBxeEstado", query = "SELECT b FROM Bancoxempresa b WHERE b.bxeEstado = :bxeEstado"),
    @NamedQuery(name = "Bancoxempresa.findByIndversion", query = "SELECT b FROM Bancoxempresa b WHERE b.indversion = :indversion")})
public class Bancoxempresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bxe_id")
    private Integer bxeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bxe_numcuenta")
    private long bxeNumcuenta;
    @Column(name = "bxe_estado")
    private Boolean bxeEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @JoinColumn(name = "bnc_id", referencedColumnName = "bnc_id")
    @ManyToOne(optional = false)
    private RfBanco bncId;
    @JoinColumn(name = "tct_id", referencedColumnName = "tct_id")
    @ManyToOne(optional = false)
    private RfTipocuenta tctId;

    public Bancoxempresa() {
    }

    public Bancoxempresa(Integer bxeId) {
        this.bxeId = bxeId;
    }

    public Bancoxempresa(Integer bxeId, long bxeNumcuenta, int indversion) {
        this.bxeId = bxeId;
        this.bxeNumcuenta = bxeNumcuenta;
        this.indversion = indversion;
    }

    public Integer getBxeId() {
        return bxeId;
    }

    public void setBxeId(Integer bxeId) {
        this.bxeId = bxeId;
    }

    public long getBxeNumcuenta() {
        return bxeNumcuenta;
    }

    public void setBxeNumcuenta(long bxeNumcuenta) {
        this.bxeNumcuenta = bxeNumcuenta;
    }

    public Boolean getBxeEstado() {
        return bxeEstado;
    }

    public void setBxeEstado(Boolean bxeEstado) {
        this.bxeEstado = bxeEstado;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
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
        hash += (bxeId != null ? bxeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancoxempresa)) {
            return false;
        }
        Bancoxempresa other = (Bancoxempresa) object;
        if ((this.bxeId == null && other.bxeId != null) || (this.bxeId != null && !this.bxeId.equals(other.bxeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.Bancoxempresa[ bxeId=" + bxeId + " ]";
    }
    
}
