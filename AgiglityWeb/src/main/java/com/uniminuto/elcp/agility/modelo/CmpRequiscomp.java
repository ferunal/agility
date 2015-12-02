/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "cmp_requiscomp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpRequiscomp.findAll", query = "SELECT c FROM CmpRequiscomp c"),
    @NamedQuery(name = "CmpRequiscomp.findByCrqId", query = "SELECT c FROM CmpRequiscomp c WHERE c.crqId = :crqId"),
    @NamedQuery(name = "CmpRequiscomp.findByCxcId", query = "SELECT c FROM CmpRequiscomp c WHERE c.cxcId = :cxcId"),
    @NamedQuery(name = "CmpRequiscomp.findByCrqFproc", query = "SELECT c FROM CmpRequiscomp c WHERE c.crqFproc = :crqFproc"),
    @NamedQuery(name = "CmpRequiscomp.findByCqrEst", query = "SELECT c FROM CmpRequiscomp c WHERE c.cqrEst = :cqrEst"),
    @NamedQuery(name = "CmpRequiscomp.findByIndversion", query = "SELECT c FROM CmpRequiscomp c WHERE c.indversion = :indversion"),
    @NamedQuery(name = "CmpRequiscomp.findByCrqRevisada", query = "SELECT c FROM CmpRequiscomp c WHERE c.crqRevisada = :crqRevisada"),
    @NamedQuery(name = "CmpRequiscomp.findByCrqAbierta", query = "SELECT c FROM CmpRequiscomp c WHERE c.crqAbierta = :crqAbierta"),
    @NamedQuery(name = "CmpRequiscomp.findByStrId", query = "SELECT c FROM CmpRequiscomp c WHERE c.strId = :strId"),
    @NamedQuery(name = "CmpRequiscomp.findByCrqAprobado", query = "SELECT c FROM CmpRequiscomp c WHERE c.crqAprobado = :crqAprobado"),
    @NamedQuery(name = "CmpRequiscomp.findByIseId", query = "SELECT c FROM CmpRequiscomp c WHERE c.iseId = :iseId")})
public class CmpRequiscomp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "crq_id")
    private Long crqId;
    @Column(name = "cxc_id")
    private Integer cxcId;
    @Column(name = "crq_fproc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crqFproc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cqr_est")
    private boolean cqrEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crq_revisada")
    private boolean crqRevisada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crq_abierta")
    private boolean crqAbierta;
    @Column(name = "str_id")
    private BigInteger strId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crq_aprobado")
    private boolean crqAprobado;
    @Column(name = "ise_id")
    private BigInteger iseId;
    @JoinColumn(name = "trq_id", referencedColumnName = "trq_id")
    @ManyToOne
    private CmpRfTiporequisicion trqId;
    @OneToMany(mappedBy = "crqId")
    private List<CmpProdxreq> cmpProdxreqList;

    public CmpRequiscomp() {
    }

    public CmpRequiscomp(Long crqId) {
        this.crqId = crqId;
    }

    public CmpRequiscomp(Long crqId, boolean cqrEst, int indversion, boolean crqRevisada, boolean crqAbierta, boolean crqAprobado) {
        this.crqId = crqId;
        this.cqrEst = cqrEst;
        this.indversion = indversion;
        this.crqRevisada = crqRevisada;
        this.crqAbierta = crqAbierta;
        this.crqAprobado = crqAprobado;
    }

    public Long getCrqId() {
        return crqId;
    }

    public void setCrqId(Long crqId) {
        this.crqId = crqId;
    }

    public Integer getCxcId() {
        return cxcId;
    }

    public void setCxcId(Integer cxcId) {
        this.cxcId = cxcId;
    }

    public Date getCrqFproc() {
        return crqFproc;
    }

    public void setCrqFproc(Date crqFproc) {
        this.crqFproc = crqFproc;
    }

    public boolean getCqrEst() {
        return cqrEst;
    }

    public void setCqrEst(boolean cqrEst) {
        this.cqrEst = cqrEst;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public boolean getCrqRevisada() {
        return crqRevisada;
    }

    public void setCrqRevisada(boolean crqRevisada) {
        this.crqRevisada = crqRevisada;
    }

    public boolean getCrqAbierta() {
        return crqAbierta;
    }

    public void setCrqAbierta(boolean crqAbierta) {
        this.crqAbierta = crqAbierta;
    }

    public BigInteger getStrId() {
        return strId;
    }

    public void setStrId(BigInteger strId) {
        this.strId = strId;
    }

    public boolean getCrqAprobado() {
        return crqAprobado;
    }

    public void setCrqAprobado(boolean crqAprobado) {
        this.crqAprobado = crqAprobado;
    }

    public BigInteger getIseId() {
        return iseId;
    }

    public void setIseId(BigInteger iseId) {
        this.iseId = iseId;
    }

    public CmpRfTiporequisicion getTrqId() {
        return trqId;
    }

    public void setTrqId(CmpRfTiporequisicion trqId) {
        this.trqId = trqId;
    }

    @XmlTransient
    public List<CmpProdxreq> getCmpProdxreqList() {
        return cmpProdxreqList;
    }

    public void setCmpProdxreqList(List<CmpProdxreq> cmpProdxreqList) {
        this.cmpProdxreqList = cmpProdxreqList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crqId != null ? crqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpRequiscomp)) {
            return false;
        }
        CmpRequiscomp other = (CmpRequiscomp) object;
        if ((this.crqId == null && other.crqId != null) || (this.crqId != null && !this.crqId.equals(other.crqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpRequiscomp[ crqId=" + crqId + " ]";
    }
    
}
