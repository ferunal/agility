/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "cmp_pxraprob")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpPxraprob.findAll", query = "SELECT c FROM CmpPxraprob c"),
    @NamedQuery(name = "CmpPxraprob.findByPraId", query = "SELECT c FROM CmpPxraprob c WHERE c.praId = :praId"),
    @NamedQuery(name = "CmpPxraprob.findByCantAprob", query = "SELECT c FROM CmpPxraprob c WHERE c.cantAprob = :cantAprob"),
    @NamedQuery(name = "CmpPxraprob.findByPraEst", query = "SELECT c FROM CmpPxraprob c WHERE c.praEst = :praEst"),
    @NamedQuery(name = "CmpPxraprob.findByIndversion", query = "SELECT c FROM CmpPxraprob c WHERE c.indversion = :indversion"),
    @NamedQuery(name = "CmpPxraprob.findByStrId", query = "SELECT c FROM CmpPxraprob c WHERE c.strId = :strId")})
public class CmpPxraprob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pra_id")
    private Long praId;
    @Column(name = "cant_aprob")
    private Integer cantAprob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pra_est")
    private boolean praEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @Column(name = "str_id")
    private BigInteger strId;
    @OneToMany(mappedBy = "praId")
    private List<CmpDetremision> cmpDetremisionList;
    @JoinColumn(name = "pxr_id", referencedColumnName = "pxr_id")
    @ManyToOne
    private CmpProdxreq pxrId;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne
    private InvMarca marId;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne
    private InvPresentprod pspId;

    public CmpPxraprob() {
    }

    public CmpPxraprob(Long praId) {
        this.praId = praId;
    }

    public CmpPxraprob(Long praId, boolean praEst, int indversion) {
        this.praId = praId;
        this.praEst = praEst;
        this.indversion = indversion;
    }

    public Long getPraId() {
        return praId;
    }

    public void setPraId(Long praId) {
        this.praId = praId;
    }

    public Integer getCantAprob() {
        return cantAprob;
    }

    public void setCantAprob(Integer cantAprob) {
        this.cantAprob = cantAprob;
    }

    public boolean getPraEst() {
        return praEst;
    }

    public void setPraEst(boolean praEst) {
        this.praEst = praEst;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public BigInteger getStrId() {
        return strId;
    }

    public void setStrId(BigInteger strId) {
        this.strId = strId;
    }

    @XmlTransient
    public List<CmpDetremision> getCmpDetremisionList() {
        return cmpDetremisionList;
    }

    public void setCmpDetremisionList(List<CmpDetremision> cmpDetremisionList) {
        this.cmpDetremisionList = cmpDetremisionList;
    }

    public CmpProdxreq getPxrId() {
        return pxrId;
    }

    public void setPxrId(CmpProdxreq pxrId) {
        this.pxrId = pxrId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (praId != null ? praId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpPxraprob)) {
            return false;
        }
        CmpPxraprob other = (CmpPxraprob) object;
        if ((this.praId == null && other.praId != null) || (this.praId != null && !this.praId.equals(other.praId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpPxraprob[ praId=" + praId + " ]";
    }
    
}
