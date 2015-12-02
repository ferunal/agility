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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "cmp_consolcompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpConsolcompra.findAll", query = "SELECT c FROM CmpConsolcompra c"),
    @NamedQuery(name = "CmpConsolcompra.findByCcmId", query = "SELECT c FROM CmpConsolcompra c WHERE c.ccmId = :ccmId"),
    @NamedQuery(name = "CmpConsolcompra.findByCcmFecproc", query = "SELECT c FROM CmpConsolcompra c WHERE c.ccmFecproc = :ccmFecproc"),
    @NamedQuery(name = "CmpConsolcompra.findByCcmCant", query = "SELECT c FROM CmpConsolcompra c WHERE c.ccmCant = :ccmCant"),
    @NamedQuery(name = "CmpConsolcompra.findByCcmPrecio", query = "SELECT c FROM CmpConsolcompra c WHERE c.ccmPrecio = :ccmPrecio"),
    @NamedQuery(name = "CmpConsolcompra.findByFpgId", query = "SELECT c FROM CmpConsolcompra c WHERE c.fpgId = :fpgId"),
    @NamedQuery(name = "CmpConsolcompra.findByStrId", query = "SELECT c FROM CmpConsolcompra c WHERE c.strId = :strId"),
    @NamedQuery(name = "CmpConsolcompra.findByCpeId", query = "SELECT c FROM CmpConsolcompra c WHERE c.cpeId = :cpeId"),
    @NamedQuery(name = "CmpConsolcompra.findByCcmFechavenfactura", query = "SELECT c FROM CmpConsolcompra c WHERE c.ccmFechavenfactura = :ccmFechavenfactura"),
    @NamedQuery(name = "CmpConsolcompra.findByCcmPreciototal", query = "SELECT c FROM CmpConsolcompra c WHERE c.ccmPreciototal = :ccmPreciototal")})
public class CmpConsolcompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ccm_id")
    private Long ccmId;
    @Column(name = "ccm_fecproc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccmFecproc;
    @Column(name = "ccm_cant")
    private Integer ccmCant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ccm_precio")
    private BigDecimal ccmPrecio;
    @Column(name = "fpg_id")
    private Integer fpgId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "str_id")
    private long strId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpe_id")
    private int cpeId;
    @Column(name = "ccm_fechavenfactura")
    @Temporal(TemporalType.DATE)
    private Date ccmFechavenfactura;
    @Column(name = "ccm_preciototal")
    private BigDecimal ccmPreciototal;
    @JoinColumn(name = "ccp_id", referencedColumnName = "ccp_id")
    @ManyToOne(optional = false)
    private CmpConspedido ccpId;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne
    private InvMarca marId;
    @JoinColumn(name = "psp_id", referencedColumnName = "psp_id")
    @ManyToOne
    private InvPresentprod pspId;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private InvProducto prdId;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne
    private InvProovedor prvId;
    @OneToMany(mappedBy = "ccmId")
    private List<CmpDetallefact> cmpDetallefactList;

    public CmpConsolcompra() {
    }

    public CmpConsolcompra(Long ccmId) {
        this.ccmId = ccmId;
    }

    public CmpConsolcompra(Long ccmId, long strId, int cpeId) {
        this.ccmId = ccmId;
        this.strId = strId;
        this.cpeId = cpeId;
    }

    public Long getCcmId() {
        return ccmId;
    }

    public void setCcmId(Long ccmId) {
        this.ccmId = ccmId;
    }

    public Date getCcmFecproc() {
        return ccmFecproc;
    }

    public void setCcmFecproc(Date ccmFecproc) {
        this.ccmFecproc = ccmFecproc;
    }

    public Integer getCcmCant() {
        return ccmCant;
    }

    public void setCcmCant(Integer ccmCant) {
        this.ccmCant = ccmCant;
    }

    public BigDecimal getCcmPrecio() {
        return ccmPrecio;
    }

    public void setCcmPrecio(BigDecimal ccmPrecio) {
        this.ccmPrecio = ccmPrecio;
    }

    public Integer getFpgId() {
        return fpgId;
    }

    public void setFpgId(Integer fpgId) {
        this.fpgId = fpgId;
    }

    public long getStrId() {
        return strId;
    }

    public void setStrId(long strId) {
        this.strId = strId;
    }

    public int getCpeId() {
        return cpeId;
    }

    public void setCpeId(int cpeId) {
        this.cpeId = cpeId;
    }

    public Date getCcmFechavenfactura() {
        return ccmFechavenfactura;
    }

    public void setCcmFechavenfactura(Date ccmFechavenfactura) {
        this.ccmFechavenfactura = ccmFechavenfactura;
    }

    public BigDecimal getCcmPreciototal() {
        return ccmPreciototal;
    }

    public void setCcmPreciototal(BigDecimal ccmPreciototal) {
        this.ccmPreciototal = ccmPreciototal;
    }

    public CmpConspedido getCcpId() {
        return ccpId;
    }

    public void setCcpId(CmpConspedido ccpId) {
        this.ccpId = ccpId;
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

    public InvProovedor getPrvId() {
        return prvId;
    }

    public void setPrvId(InvProovedor prvId) {
        this.prvId = prvId;
    }

    @XmlTransient
    public List<CmpDetallefact> getCmpDetallefactList() {
        return cmpDetallefactList;
    }

    public void setCmpDetallefactList(List<CmpDetallefact> cmpDetallefactList) {
        this.cmpDetallefactList = cmpDetallefactList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccmId != null ? ccmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpConsolcompra)) {
            return false;
        }
        CmpConsolcompra other = (CmpConsolcompra) object;
        if ((this.ccmId == null && other.ccmId != null) || (this.ccmId != null && !this.ccmId.equals(other.ccmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpConsolcompra[ ccmId=" + ccmId + " ]";
    }
    
}
