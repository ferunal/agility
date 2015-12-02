/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "rf_banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RfBanco.findAll", query = "SELECT r FROM RfBanco r"),
    @NamedQuery(name = "RfBanco.findByBncId", query = "SELECT r FROM RfBanco r WHERE r.bncId = :bncId"),
    @NamedQuery(name = "RfBanco.findByBncNombre", query = "SELECT r FROM RfBanco r WHERE r.bncNombre = :bncNombre"),
    @NamedQuery(name = "RfBanco.findByBncDescripcion", query = "SELECT r FROM RfBanco r WHERE r.bncDescripcion = :bncDescripcion"),
    @NamedQuery(name = "RfBanco.findByBncEstado", query = "SELECT r FROM RfBanco r WHERE r.bncEstado = :bncEstado"),
    @NamedQuery(name = "RfBanco.findByIndversion", query = "SELECT r FROM RfBanco r WHERE r.indversion = :indversion")})
public class RfBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bnc_id")
    private Long bncId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "bnc_nombre")
    private String bncNombre;
    @Size(max = 2147483647)
    @Column(name = "bnc_descripcion")
    private String bncDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bnc_estado")
    private boolean bncEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bncId")
    private List<InvBancoxprov> invBancoxprovList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bncId")
    private List<Bancoxempresa> bancoxempresaList;

    public RfBanco() {
    }

    public RfBanco(Long bncId) {
        this.bncId = bncId;
    }

    public RfBanco(Long bncId, String bncNombre, boolean bncEstado, int indversion) {
        this.bncId = bncId;
        this.bncNombre = bncNombre;
        this.bncEstado = bncEstado;
        this.indversion = indversion;
    }

    public Long getBncId() {
        return bncId;
    }

    public void setBncId(Long bncId) {
        this.bncId = bncId;
    }

    public String getBncNombre() {
        return bncNombre;
    }

    public void setBncNombre(String bncNombre) {
        this.bncNombre = bncNombre;
    }

    public String getBncDescripcion() {
        return bncDescripcion;
    }

    public void setBncDescripcion(String bncDescripcion) {
        this.bncDescripcion = bncDescripcion;
    }

    public boolean getBncEstado() {
        return bncEstado;
    }

    public void setBncEstado(boolean bncEstado) {
        this.bncEstado = bncEstado;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<InvBancoxprov> getInvBancoxprovList() {
        return invBancoxprovList;
    }

    public void setInvBancoxprovList(List<InvBancoxprov> invBancoxprovList) {
        this.invBancoxprovList = invBancoxprovList;
    }

    @XmlTransient
    public List<Bancoxempresa> getBancoxempresaList() {
        return bancoxempresaList;
    }

    public void setBancoxempresaList(List<Bancoxempresa> bancoxempresaList) {
        this.bancoxempresaList = bancoxempresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bncId != null ? bncId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RfBanco)) {
            return false;
        }
        RfBanco other = (RfBanco) object;
        if ((this.bncId == null && other.bncId != null) || (this.bncId != null && !this.bncId.equals(other.bncId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.RfBanco[ bncId=" + bncId + " ]";
    }
    
}
