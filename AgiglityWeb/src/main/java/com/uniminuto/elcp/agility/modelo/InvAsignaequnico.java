/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
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
@Table(name = "inv_asignaequnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvAsignaequnico.findAll", query = "SELECT i FROM InvAsignaequnico i"),
    @NamedQuery(name = "InvAsignaequnico.findByIxcId", query = "SELECT i FROM InvAsignaequnico i WHERE i.ixcId = :ixcId"),
    @NamedQuery(name = "InvAsignaequnico.findByIxcFechaproceso", query = "SELECT i FROM InvAsignaequnico i WHERE i.ixcFechaproceso = :ixcFechaproceso"),
    @NamedQuery(name = "InvAsignaequnico.findByIxcEstado", query = "SELECT i FROM InvAsignaequnico i WHERE i.ixcEstado = :ixcEstado"),
    @NamedQuery(name = "InvAsignaequnico.findByIndversion", query = "SELECT i FROM InvAsignaequnico i WHERE i.indversion = :indversion"),
    @NamedQuery(name = "InvAsignaequnico.findByCxcIdasignado", query = "SELECT i FROM InvAsignaequnico i WHERE i.cxcIdasignado = :cxcIdasignado")})
public class InvAsignaequnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ixc_id")
    private Long ixcId;
    @Column(name = "ixc_fechaproceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ixcFechaproceso;
    @Column(name = "ixc_estado")
    private Boolean ixcEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @Column(name = "cxc_idasignado")
    private Integer cxcIdasignado;
    @JoinColumn(name = "itr_id", referencedColumnName = "itr_id")
    @ManyToOne
    private InvTransac itrId;

    public InvAsignaequnico() {
    }

    public InvAsignaequnico(Long ixcId) {
        this.ixcId = ixcId;
    }

    public InvAsignaequnico(Long ixcId, int indversion) {
        this.ixcId = ixcId;
        this.indversion = indversion;
    }

    public Long getIxcId() {
        return ixcId;
    }

    public void setIxcId(Long ixcId) {
        this.ixcId = ixcId;
    }

    public Date getIxcFechaproceso() {
        return ixcFechaproceso;
    }

    public void setIxcFechaproceso(Date ixcFechaproceso) {
        this.ixcFechaproceso = ixcFechaproceso;
    }

    public Boolean getIxcEstado() {
        return ixcEstado;
    }

    public void setIxcEstado(Boolean ixcEstado) {
        this.ixcEstado = ixcEstado;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public Integer getCxcIdasignado() {
        return cxcIdasignado;
    }

    public void setCxcIdasignado(Integer cxcIdasignado) {
        this.cxcIdasignado = cxcIdasignado;
    }

    public InvTransac getItrId() {
        return itrId;
    }

    public void setItrId(InvTransac itrId) {
        this.itrId = itrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ixcId != null ? ixcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvAsignaequnico)) {
            return false;
        }
        InvAsignaequnico other = (InvAsignaequnico) object;
        if ((this.ixcId == null && other.ixcId != null) || (this.ixcId != null && !this.ixcId.equals(other.ixcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvAsignaequnico[ ixcId=" + ixcId + " ]";
    }
    
}
