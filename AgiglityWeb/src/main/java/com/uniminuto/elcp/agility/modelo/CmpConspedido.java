/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "cmp_conspedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpConspedido.findAll", query = "SELECT c FROM CmpConspedido c"),
    @NamedQuery(name = "CmpConspedido.findByCcpId", query = "SELECT c FROM CmpConspedido c WHERE c.ccpId = :ccpId"),
    @NamedQuery(name = "CmpConspedido.findByStrId", query = "SELECT c FROM CmpConspedido c WHERE c.strId = :strId"),
    @NamedQuery(name = "CmpConspedido.findByCcpCantaprob", query = "SELECT c FROM CmpConspedido c WHERE c.ccpCantaprob = :ccpCantaprob"),
    @NamedQuery(name = "CmpConspedido.findByCcpCantinv", query = "SELECT c FROM CmpConspedido c WHERE c.ccpCantinv = :ccpCantinv"),
    @NamedQuery(name = "CmpConspedido.findByCcpCantcomprar", query = "SELECT c FROM CmpConspedido c WHERE c.ccpCantcomprar = :ccpCantcomprar"),
    @NamedQuery(name = "CmpConspedido.findByCcpFechaproceso", query = "SELECT c FROM CmpConspedido c WHERE c.ccpFechaproceso = :ccpFechaproceso"),
    @NamedQuery(name = "CmpConspedido.findByCpeId", query = "SELECT c FROM CmpConspedido c WHERE c.cpeId = :cpeId")})
public class CmpConspedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ccp_id")
    private Long ccpId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "str_id")
    private long strId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ccp_cantaprob")
    private int ccpCantaprob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ccp_cantinv")
    private int ccpCantinv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ccp_cantcomprar")
    private int ccpCantcomprar;
    @Column(name = "ccp_fechaproceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccpFechaproceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpe_id")
    private int cpeId;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne(optional = false)
    private InvMarca marId;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne(optional = false)
    private InvPresentprod pspId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne(optional = false)
    private InvProducto prdId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ccpId")
    private List<CmpConsolcompra> cmpConsolcompraList;

    public CmpConspedido() {
    }

    public CmpConspedido(Long ccpId) {
        this.ccpId = ccpId;
    }

    public CmpConspedido(Long ccpId, long strId, int ccpCantaprob, int ccpCantinv, int ccpCantcomprar, int cpeId) {
        this.ccpId = ccpId;
        this.strId = strId;
        this.ccpCantaprob = ccpCantaprob;
        this.ccpCantinv = ccpCantinv;
        this.ccpCantcomprar = ccpCantcomprar;
        this.cpeId = cpeId;
    }

    public Long getCcpId() {
        return ccpId;
    }

    public void setCcpId(Long ccpId) {
        this.ccpId = ccpId;
    }

    public long getStrId() {
        return strId;
    }

    public void setStrId(long strId) {
        this.strId = strId;
    }

    public int getCcpCantaprob() {
        return ccpCantaprob;
    }

    public void setCcpCantaprob(int ccpCantaprob) {
        this.ccpCantaprob = ccpCantaprob;
    }

    public int getCcpCantinv() {
        return ccpCantinv;
    }

    public void setCcpCantinv(int ccpCantinv) {
        this.ccpCantinv = ccpCantinv;
    }

    public int getCcpCantcomprar() {
        return ccpCantcomprar;
    }

    public void setCcpCantcomprar(int ccpCantcomprar) {
        this.ccpCantcomprar = ccpCantcomprar;
    }

    public Date getCcpFechaproceso() {
        return ccpFechaproceso;
    }

    public void setCcpFechaproceso(Date ccpFechaproceso) {
        this.ccpFechaproceso = ccpFechaproceso;
    }

    public int getCpeId() {
        return cpeId;
    }

    public void setCpeId(int cpeId) {
        this.cpeId = cpeId;
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
    public List<CmpConsolcompra> getCmpConsolcompraList() {
        return cmpConsolcompraList;
    }

    public void setCmpConsolcompraList(List<CmpConsolcompra> cmpConsolcompraList) {
        this.cmpConsolcompraList = cmpConsolcompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccpId != null ? ccpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpConspedido)) {
            return false;
        }
        CmpConspedido other = (CmpConspedido) object;
        if ((this.ccpId == null && other.ccpId != null) || (this.ccpId != null && !this.ccpId.equals(other.ccpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpConspedido[ ccpId=" + ccpId + " ]";
    }
    
}
