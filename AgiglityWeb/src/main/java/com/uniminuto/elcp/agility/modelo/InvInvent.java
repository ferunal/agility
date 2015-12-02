/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "inv_invent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvInvent.findAll", query = "SELECT i FROM InvInvent i"),
    @NamedQuery(name = "InvInvent.findByInvId", query = "SELECT i FROM InvInvent i WHERE i.invId = :invId"),
    @NamedQuery(name = "InvInvent.findByInvPrecio", query = "SELECT i FROM InvInvent i WHERE i.invPrecio = :invPrecio"),
    @NamedQuery(name = "InvInvent.findByInvCant", query = "SELECT i FROM InvInvent i WHERE i.invCant = :invCant"),
    @NamedQuery(name = "InvInvent.findByIndversion", query = "SELECT i FROM InvInvent i WHERE i.indversion = :indversion"),
    @NamedQuery(name = "InvInvent.findByInvFechaingreso", query = "SELECT i FROM InvInvent i WHERE i.invFechaingreso = :invFechaingreso"),
    @NamedQuery(name = "InvInvent.findByInvFechaegreso", query = "SELECT i FROM InvInvent i WHERE i.invFechaegreso = :invFechaegreso")})
public class InvInvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_id")
    private Long invId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_precio")
    private BigDecimal invPrecio;
    @Column(name = "inv_cant")
    private Integer invCant;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "inv_fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date invFechaingreso;
    @Column(name = "inv_fechaegreso")
    @Temporal(TemporalType.DATE)
    private Date invFechaegreso;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne
    private InvMarca marId;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne
    private InvPresentprod pspId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private InvProducto prdId;
    @OneToMany(mappedBy = "invId")
    private List<InvTransac> invTransacList;
    @OneToMany(mappedBy = "invId")
    private List<InvDetinv> invDetinvList;
    @OneToMany(mappedBy = "invId")
    private List<CmpDetremision> cmpDetremisionList;

    public InvInvent() {
    }

    public InvInvent(Long invId) {
        this.invId = invId;
    }

    public Long getInvId() {
        return invId;
    }

    public void setInvId(Long invId) {
        this.invId = invId;
    }

    public BigDecimal getInvPrecio() {
        return invPrecio;
    }

    public void setInvPrecio(BigDecimal invPrecio) {
        this.invPrecio = invPrecio;
    }

    public Integer getInvCant() {
        return invCant;
    }

    public void setInvCant(Integer invCant) {
        this.invCant = invCant;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public Date getInvFechaingreso() {
        return invFechaingreso;
    }

    public void setInvFechaingreso(Date invFechaingreso) {
        this.invFechaingreso = invFechaingreso;
    }

    public Date getInvFechaegreso() {
        return invFechaegreso;
    }

    public void setInvFechaegreso(Date invFechaegreso) {
        this.invFechaegreso = invFechaegreso;
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
    public List<InvTransac> getInvTransacList() {
        return invTransacList;
    }

    public void setInvTransacList(List<InvTransac> invTransacList) {
        this.invTransacList = invTransacList;
    }

    @XmlTransient
    public List<InvDetinv> getInvDetinvList() {
        return invDetinvList;
    }

    public void setInvDetinvList(List<InvDetinv> invDetinvList) {
        this.invDetinvList = invDetinvList;
    }

    @XmlTransient
    public List<CmpDetremision> getCmpDetremisionList() {
        return cmpDetremisionList;
    }

    public void setCmpDetremisionList(List<CmpDetremision> cmpDetremisionList) {
        this.cmpDetremisionList = cmpDetremisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invId != null ? invId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvInvent)) {
            return false;
        }
        InvInvent other = (InvInvent) object;
        if ((this.invId == null && other.invId != null) || (this.invId != null && !this.invId.equals(other.invId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvInvent[ invId=" + invId + " ]";
    }
    
}
