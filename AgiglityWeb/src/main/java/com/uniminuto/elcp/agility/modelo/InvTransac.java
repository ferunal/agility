/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "inv_transac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvTransac.findAll", query = "SELECT i FROM InvTransac i"),
    @NamedQuery(name = "InvTransac.findByItrId", query = "SELECT i FROM InvTransac i WHERE i.itrId = :itrId"),
    @NamedQuery(name = "InvTransac.findByItrCant", query = "SELECT i FROM InvTransac i WHERE i.itrCant = :itrCant"),
    @NamedQuery(name = "InvTransac.findByItrFecpro", query = "SELECT i FROM InvTransac i WHERE i.itrFecpro = :itrFecpro"),
    @NamedQuery(name = "InvTransac.findByCxcId", query = "SELECT i FROM InvTransac i WHERE i.cxcId = :cxcId"),
    @NamedQuery(name = "InvTransac.findByItrObsr", query = "SELECT i FROM InvTransac i WHERE i.itrObsr = :itrObsr"),
    @NamedQuery(name = "InvTransac.findByItrAnultr", query = "SELECT i FROM InvTransac i WHERE i.itrAnultr = :itrAnultr"),
    @NamedQuery(name = "InvTransac.findByItrIdtranul", query = "SELECT i FROM InvTransac i WHERE i.itrIdtranul = :itrIdtranul"),
    @NamedQuery(name = "InvTransac.findByItrEstado", query = "SELECT i FROM InvTransac i WHERE i.itrEstado = :itrEstado"),
    @NamedQuery(name = "InvTransac.findByIndversion", query = "SELECT i FROM InvTransac i WHERE i.indversion = :indversion"),
    @NamedQuery(name = "InvTransac.findByItrValor", query = "SELECT i FROM InvTransac i WHERE i.itrValor = :itrValor"),
    @NamedQuery(name = "InvTransac.findByStrId", query = "SELECT i FROM InvTransac i WHERE i.strId = :strId")})
public class InvTransac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itr_id")
    private Long itrId;
    @Column(name = "itr_cant")
    private Integer itrCant;
    @Column(name = "itr_fecpro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itrFecpro;
    @Column(name = "cxc_id")
    private Integer cxcId;
    @Size(max = 2147483647)
    @Column(name = "itr_obsr")
    private String itrObsr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itr_anultr")
    private boolean itrAnultr;
    @Column(name = "itr_idtranul")
    private BigInteger itrIdtranul;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itr_estado")
    private boolean itrEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "itr_valor")
    private BigDecimal itrValor;
    @Column(name = "str_id")
    private BigInteger strId;
    @JoinColumn(name = "fact_id", referencedColumnName = "fact_id")
    @ManyToOne
    private CmpFactura factId;
    @JoinColumn(name = "rmi_id", referencedColumnName = "rmi_id")
    @ManyToOne
    private CmpRemisioninv rmiId;
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id")
    @ManyToOne
    private InvInvent invId;
    @JoinColumn(name = "ttr_id", referencedColumnName = "ttr_id")
    @ManyToOne(optional = false)
    private InvTipotransc ttrId;
    @OneToMany(mappedBy = "itrId")
    private List<InvAsignaequnico> invAsignaequnicoList;

    public InvTransac() {
    }

    public InvTransac(Long itrId) {
        this.itrId = itrId;
    }

    public InvTransac(Long itrId, boolean itrAnultr, boolean itrEstado, int indversion) {
        this.itrId = itrId;
        this.itrAnultr = itrAnultr;
        this.itrEstado = itrEstado;
        this.indversion = indversion;
    }

    public Long getItrId() {
        return itrId;
    }

    public void setItrId(Long itrId) {
        this.itrId = itrId;
    }

    public Integer getItrCant() {
        return itrCant;
    }

    public void setItrCant(Integer itrCant) {
        this.itrCant = itrCant;
    }

    public Date getItrFecpro() {
        return itrFecpro;
    }

    public void setItrFecpro(Date itrFecpro) {
        this.itrFecpro = itrFecpro;
    }

    public Integer getCxcId() {
        return cxcId;
    }

    public void setCxcId(Integer cxcId) {
        this.cxcId = cxcId;
    }

    public String getItrObsr() {
        return itrObsr;
    }

    public void setItrObsr(String itrObsr) {
        this.itrObsr = itrObsr;
    }

    public boolean getItrAnultr() {
        return itrAnultr;
    }

    public void setItrAnultr(boolean itrAnultr) {
        this.itrAnultr = itrAnultr;
    }

    public BigInteger getItrIdtranul() {
        return itrIdtranul;
    }

    public void setItrIdtranul(BigInteger itrIdtranul) {
        this.itrIdtranul = itrIdtranul;
    }

    public boolean getItrEstado() {
        return itrEstado;
    }

    public void setItrEstado(boolean itrEstado) {
        this.itrEstado = itrEstado;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public BigDecimal getItrValor() {
        return itrValor;
    }

    public void setItrValor(BigDecimal itrValor) {
        this.itrValor = itrValor;
    }

    public BigInteger getStrId() {
        return strId;
    }

    public void setStrId(BigInteger strId) {
        this.strId = strId;
    }

    public CmpFactura getFactId() {
        return factId;
    }

    public void setFactId(CmpFactura factId) {
        this.factId = factId;
    }

    public CmpRemisioninv getRmiId() {
        return rmiId;
    }

    public void setRmiId(CmpRemisioninv rmiId) {
        this.rmiId = rmiId;
    }

    public InvInvent getInvId() {
        return invId;
    }

    public void setInvId(InvInvent invId) {
        this.invId = invId;
    }

    public InvTipotransc getTtrId() {
        return ttrId;
    }

    public void setTtrId(InvTipotransc ttrId) {
        this.ttrId = ttrId;
    }

    @XmlTransient
    public List<InvAsignaequnico> getInvAsignaequnicoList() {
        return invAsignaequnicoList;
    }

    public void setInvAsignaequnicoList(List<InvAsignaequnico> invAsignaequnicoList) {
        this.invAsignaequnicoList = invAsignaequnicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itrId != null ? itrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTransac)) {
            return false;
        }
        InvTransac other = (InvTransac) object;
        if ((this.itrId == null && other.itrId != null) || (this.itrId != null && !this.itrId.equals(other.itrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvTransac[ itrId=" + itrId + " ]";
    }
    
}
