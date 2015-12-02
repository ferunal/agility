/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "cmp_prodxreq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpProdxreq.findAll", query = "SELECT c FROM CmpProdxreq c"),
    @NamedQuery(name = "CmpProdxreq.findByPxrId", query = "SELECT c FROM CmpProdxreq c WHERE c.pxrId = :pxrId"),
    @NamedQuery(name = "CmpProdxreq.findByPxrCantsol", query = "SELECT c FROM CmpProdxreq c WHERE c.pxrCantsol = :pxrCantsol"),
    @NamedQuery(name = "CmpProdxreq.findByIndversion", query = "SELECT c FROM CmpProdxreq c WHERE c.indversion = :indversion"),
    @NamedQuery(name = "CmpProdxreq.findByPxrRechaza", query = "SELECT c FROM CmpProdxreq c WHERE c.pxrRechaza = :pxrRechaza"),
    @NamedQuery(name = "CmpProdxreq.findByPxrObsrrechza", query = "SELECT c FROM CmpProdxreq c WHERE c.pxrObsrrechza = :pxrObsrrechza"),
    @NamedQuery(name = "CmpProdxreq.findByPxrObsrsol", query = "SELECT c FROM CmpProdxreq c WHERE c.pxrObsrsol = :pxrObsrsol")})
public class CmpProdxreq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pxr_id")
    private Long pxrId;
    @Column(name = "pxr_cantsol")
    private Integer pxrCantsol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pxr_rechaza")
    private boolean pxrRechaza;
    @Size(max = 2147483647)
    @Column(name = "pxr_obsrrechza")
    private String pxrObsrrechza;
    @Size(max = 2147483647)
    @Column(name = "pxr_obsrsol")
    private String pxrObsrsol;
    @JoinColumn(name = "crq_id", referencedColumnName = "crq_id")
    @ManyToOne
    private CmpRequiscomp crqId;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne
    private InvMarca marId;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne
    private InvPresentprod pspId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private InvProducto prdId;
    @OneToMany(mappedBy = "pxrId")
    private List<CmpPxraprob> cmpPxraprobList;

    public CmpProdxreq() {
    }

    public CmpProdxreq(Long pxrId) {
        this.pxrId = pxrId;
    }

    public CmpProdxreq(Long pxrId, int indversion, boolean pxrRechaza) {
        this.pxrId = pxrId;
        this.indversion = indversion;
        this.pxrRechaza = pxrRechaza;
    }

    public Long getPxrId() {
        return pxrId;
    }

    public void setPxrId(Long pxrId) {
        this.pxrId = pxrId;
    }

    public Integer getPxrCantsol() {
        return pxrCantsol;
    }

    public void setPxrCantsol(Integer pxrCantsol) {
        this.pxrCantsol = pxrCantsol;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public boolean getPxrRechaza() {
        return pxrRechaza;
    }

    public void setPxrRechaza(boolean pxrRechaza) {
        this.pxrRechaza = pxrRechaza;
    }

    public String getPxrObsrrechza() {
        return pxrObsrrechza;
    }

    public void setPxrObsrrechza(String pxrObsrrechza) {
        this.pxrObsrrechza = pxrObsrrechza;
    }

    public String getPxrObsrsol() {
        return pxrObsrsol;
    }

    public void setPxrObsrsol(String pxrObsrsol) {
        this.pxrObsrsol = pxrObsrsol;
    }

    public CmpRequiscomp getCrqId() {
        return crqId;
    }

    public void setCrqId(CmpRequiscomp crqId) {
        this.crqId = crqId;
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

    @XmlTransient
    public List<CmpPxraprob> getCmpPxraprobList() {
        return cmpPxraprobList;
    }

    public void setCmpPxraprobList(List<CmpPxraprob> cmpPxraprobList) {
        this.cmpPxraprobList = cmpPxraprobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pxrId != null ? pxrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpProdxreq)) {
            return false;
        }
        CmpProdxreq other = (CmpProdxreq) object;
        if ((this.pxrId == null && other.pxrId != null) || (this.pxrId != null && !this.pxrId.equals(other.pxrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpProdxreq[ pxrId=" + pxrId + " ]";
    }
    
}
