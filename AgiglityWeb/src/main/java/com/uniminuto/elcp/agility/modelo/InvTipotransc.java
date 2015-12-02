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
@Table(name = "inv_tipotransc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvTipotransc.findAll", query = "SELECT i FROM InvTipotransc i"),
    @NamedQuery(name = "InvTipotransc.findByTtrId", query = "SELECT i FROM InvTipotransc i WHERE i.ttrId = :ttrId"),
    @NamedQuery(name = "InvTipotransc.findByTtrNombre", query = "SELECT i FROM InvTipotransc i WHERE i.ttrNombre = :ttrNombre"),
    @NamedQuery(name = "InvTipotransc.findByTtrDesc", query = "SELECT i FROM InvTipotransc i WHERE i.ttrDesc = :ttrDesc"),
    @NamedQuery(name = "InvTipotransc.findByTtrEst", query = "SELECT i FROM InvTipotransc i WHERE i.ttrEst = :ttrEst"),
    @NamedQuery(name = "InvTipotransc.findByIndversion", query = "SELECT i FROM InvTipotransc i WHERE i.indversion = :indversion")})
public class InvTipotransc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ttr_id")
    private Integer ttrId;
    @Size(max = 100)
    @Column(name = "ttr_nombre")
    private String ttrNombre;
    @Size(max = 2147483647)
    @Column(name = "ttr_desc")
    private String ttrDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ttr_est")
    private boolean ttrEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ttrId")
    private List<InvTransac> invTransacList;

    public InvTipotransc() {
    }

    public InvTipotransc(Integer ttrId) {
        this.ttrId = ttrId;
    }

    public InvTipotransc(Integer ttrId, boolean ttrEst, int indversion) {
        this.ttrId = ttrId;
        this.ttrEst = ttrEst;
        this.indversion = indversion;
    }

    public Integer getTtrId() {
        return ttrId;
    }

    public void setTtrId(Integer ttrId) {
        this.ttrId = ttrId;
    }

    public String getTtrNombre() {
        return ttrNombre;
    }

    public void setTtrNombre(String ttrNombre) {
        this.ttrNombre = ttrNombre;
    }

    public String getTtrDesc() {
        return ttrDesc;
    }

    public void setTtrDesc(String ttrDesc) {
        this.ttrDesc = ttrDesc;
    }

    public boolean getTtrEst() {
        return ttrEst;
    }

    public void setTtrEst(boolean ttrEst) {
        this.ttrEst = ttrEst;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<InvTransac> getInvTransacList() {
        return invTransacList;
    }

    public void setInvTransacList(List<InvTransac> invTransacList) {
        this.invTransacList = invTransacList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttrId != null ? ttrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTipotransc)) {
            return false;
        }
        InvTipotransc other = (InvTipotransc) object;
        if ((this.ttrId == null && other.ttrId != null) || (this.ttrId != null && !this.ttrId.equals(other.ttrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvTipotransc[ ttrId=" + ttrId + " ]";
    }
    
}
