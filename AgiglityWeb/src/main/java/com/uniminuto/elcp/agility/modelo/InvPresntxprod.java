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
@Table(name = "inv_presntxprod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvPresntxprod.findAll", query = "SELECT i FROM InvPresntxprod i"),
    @NamedQuery(name = "InvPresntxprod.findByPxpId", query = "SELECT i FROM InvPresntxprod i WHERE i.pxpId = :pxpId"),
    @NamedQuery(name = "InvPresntxprod.findByPxpEst", query = "SELECT i FROM InvPresntxprod i WHERE i.pxpEst = :pxpEst")})
public class InvPresntxprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pxp_id")
    private Long pxpId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pxp_est")
    private boolean pxpEst;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne
    private InvPresentprod pspId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private InvProducto prdId;

    public InvPresntxprod() {
    }

    public InvPresntxprod(Long pxpId) {
        this.pxpId = pxpId;
    }

    public InvPresntxprod(Long pxpId, boolean pxpEst) {
        this.pxpId = pxpId;
        this.pxpEst = pxpEst;
    }

    public Long getPxpId() {
        return pxpId;
    }

    public void setPxpId(Long pxpId) {
        this.pxpId = pxpId;
    }

    public boolean getPxpEst() {
        return pxpEst;
    }

    public void setPxpEst(boolean pxpEst) {
        this.pxpEst = pxpEst;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pxpId != null ? pxpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvPresntxprod)) {
            return false;
        }
        InvPresntxprod other = (InvPresntxprod) object;
        if ((this.pxpId == null && other.pxpId != null) || (this.pxpId != null && !this.pxpId.equals(other.pxpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvPresntxprod[ pxpId=" + pxpId + " ]";
    }
    
}
