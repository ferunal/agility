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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "rf_tipodoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RfTipodoc.findAll", query = "SELECT r FROM RfTipodoc r"),
    @NamedQuery(name = "RfTipodoc.findByTdcId", query = "SELECT r FROM RfTipodoc r WHERE r.tdcId = :tdcId"),
    @NamedQuery(name = "RfTipodoc.findByTdcNombre", query = "SELECT r FROM RfTipodoc r WHERE r.tdcNombre = :tdcNombre"),
    @NamedQuery(name = "RfTipodoc.findByTdcEstado", query = "SELECT r FROM RfTipodoc r WHERE r.tdcEstado = :tdcEstado"),
    @NamedQuery(name = "RfTipodoc.findByIndversion", query = "SELECT r FROM RfTipodoc r WHERE r.indversion = :indversion")})
public class RfTipodoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tdc_id")
    private String tdcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tdc_nombre")
    private String tdcNombre;
    @Column(name = "tdc_estado")
    private Boolean tdcEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;

    public RfTipodoc() {
    }

    public RfTipodoc(String tdcId) {
        this.tdcId = tdcId;
    }

    public RfTipodoc(String tdcId, String tdcNombre, int indversion) {
        this.tdcId = tdcId;
        this.tdcNombre = tdcNombre;
        this.indversion = indversion;
    }

    public String getTdcId() {
        return tdcId;
    }

    public void setTdcId(String tdcId) {
        this.tdcId = tdcId;
    }

    public String getTdcNombre() {
        return tdcNombre;
    }

    public void setTdcNombre(String tdcNombre) {
        this.tdcNombre = tdcNombre;
    }

    public Boolean getTdcEstado() {
        return tdcEstado;
    }

    public void setTdcEstado(Boolean tdcEstado) {
        this.tdcEstado = tdcEstado;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdcId != null ? tdcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RfTipodoc)) {
            return false;
        }
        RfTipodoc other = (RfTipodoc) object;
        if ((this.tdcId == null && other.tdcId != null) || (this.tdcId != null && !this.tdcId.equals(other.tdcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.RfTipodoc[ tdcId=" + tdcId + " ]";
    }
    
}
