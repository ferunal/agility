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
@Table(name = "inv_marcxprod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvMarcxprod.findAll", query = "SELECT i FROM InvMarcxprod i"),
    @NamedQuery(name = "InvMarcxprod.findByMxpId", query = "SELECT i FROM InvMarcxprod i WHERE i.mxpId = :mxpId"),
    @NamedQuery(name = "InvMarcxprod.findByMxpEst", query = "SELECT i FROM InvMarcxprod i WHERE i.mxpEst = :mxpEst"),
    @NamedQuery(name = "InvMarcxprod.findByIndversion", query = "SELECT i FROM InvMarcxprod i WHERE i.indversion = :indversion")})
public class InvMarcxprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mxp_id")
    private Long mxpId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mxp_est")
    private boolean mxpEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne
    private InvMarca marId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private InvProducto prdId;

    public InvMarcxprod() {
    }

    public InvMarcxprod(Long mxpId) {
        this.mxpId = mxpId;
    }

    public InvMarcxprod(Long mxpId, boolean mxpEst, int indversion) {
        this.mxpId = mxpId;
        this.mxpEst = mxpEst;
        this.indversion = indversion;
    }

    public Long getMxpId() {
        return mxpId;
    }

    public void setMxpId(Long mxpId) {
        this.mxpId = mxpId;
    }

    public boolean getMxpEst() {
        return mxpEst;
    }

    public void setMxpEst(boolean mxpEst) {
        this.mxpEst = mxpEst;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public InvMarca getMarId() {
        return marId;
    }

    public void setMarId(InvMarca marId) {
        this.marId = marId;
    }

    public InvProducto getPrdId() {
        return prdId;
    }

    public void setPrdId(InvProducto prdId) {
        this.prdId = prdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mxpId != null ? mxpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvMarcxprod)) {
            return false;
        }
        InvMarcxprod other = (InvMarcxprod) object;
        if ((this.mxpId == null && other.mxpId != null) || (this.mxpId != null && !this.mxpId.equals(other.mxpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvMarcxprod[ mxpId=" + mxpId + " ]";
    }
    
}
