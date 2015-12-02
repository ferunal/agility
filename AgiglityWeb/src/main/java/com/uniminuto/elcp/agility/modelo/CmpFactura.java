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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "cmp_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpFactura.findAll", query = "SELECT c FROM CmpFactura c"),
    @NamedQuery(name = "CmpFactura.findByFactId", query = "SELECT c FROM CmpFactura c WHERE c.factId = :factId"),
    @NamedQuery(name = "CmpFactura.findByFactNumfact", query = "SELECT c FROM CmpFactura c WHERE c.factNumfact = :factNumfact"),
    @NamedQuery(name = "CmpFactura.findByFactPrefact", query = "SELECT c FROM CmpFactura c WHERE c.factPrefact = :factPrefact"),
    @NamedQuery(name = "CmpFactura.findByFactValorbruto", query = "SELECT c FROM CmpFactura c WHERE c.factValorbruto = :factValorbruto"),
    @NamedQuery(name = "CmpFactura.findByFactValorneto", query = "SELECT c FROM CmpFactura c WHERE c.factValorneto = :factValorneto"),
    @NamedQuery(name = "CmpFactura.findByFactEst", query = "SELECT c FROM CmpFactura c WHERE c.factEst = :factEst"),
    @NamedQuery(name = "CmpFactura.findByStrId", query = "SELECT c FROM CmpFactura c WHERE c.strId = :strId"),
    @NamedQuery(name = "CmpFactura.findByCxcId", query = "SELECT c FROM CmpFactura c WHERE c.cxcId = :cxcId"),
    @NamedQuery(name = "CmpFactura.findByFactFechaproceso", query = "SELECT c FROM CmpFactura c WHERE c.factFechaproceso = :factFechaproceso"),
    @NamedQuery(name = "CmpFactura.findByIndversion", query = "SELECT c FROM CmpFactura c WHERE c.indversion = :indversion"),
    @NamedQuery(name = "CmpFactura.findByFactPrevalorbruto", query = "SELECT c FROM CmpFactura c WHERE c.factPrevalorbruto = :factPrevalorbruto"),
    @NamedQuery(name = "CmpFactura.findByFactProcesadorecibido", query = "SELECT c FROM CmpFactura c WHERE c.factProcesadorecibido = :factProcesadorecibido"),
    @NamedQuery(name = "CmpFactura.findByFactProcesadocargainv", query = "SELECT c FROM CmpFactura c WHERE c.factProcesadocargainv = :factProcesadocargainv"),
    @NamedQuery(name = "CmpFactura.findByFactEnvpagocuenta", query = "SELECT c FROM CmpFactura c WHERE c.factEnvpagocuenta = :factEnvpagocuenta"),
    @NamedQuery(name = "CmpFactura.findByFactAnticipo", query = "SELECT c FROM CmpFactura c WHERE c.factAnticipo = :factAnticipo"),
    @NamedQuery(name = "CmpFactura.findByFactFechamaxentrega", query = "SELECT c FROM CmpFactura c WHERE c.factFechamaxentrega = :factFechamaxentrega")})
public class CmpFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fact_id")
    private Long factId;
    @Size(max = 100)
    @Column(name = "fact_numfact")
    private String factNumfact;
    @Column(name = "fact_prefact")
    private Boolean factPrefact;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fact_valorbruto")
    private BigDecimal factValorbruto;
    @Column(name = "fact_valorneto")
    private BigDecimal factValorneto;
    @Column(name = "fact_est")
    private Boolean factEst;
    @Column(name = "str_id")
    private BigInteger strId;
    @Column(name = "cxc_id")
    private Integer cxcId;
    @Column(name = "fact_fechaproceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date factFechaproceso;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "fact_prevalorbruto")
    private BigDecimal factPrevalorbruto;
    @Column(name = "fact_procesadorecibido")
    private Boolean factProcesadorecibido;
    @Column(name = "fact_procesadocargainv")
    private Boolean factProcesadocargainv;
    @Column(name = "fact_envpagocuenta")
    private Boolean factEnvpagocuenta;
    @Column(name = "fact_anticipo")
    private BigDecimal factAnticipo;
    @Column(name = "fact_fechamaxentrega")
    @Temporal(TemporalType.DATE)
    private Date factFechamaxentrega;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne
    private InvProovedor prvId;
    @OneToMany(mappedBy = "factId")
    private List<InvTransac> invTransacList;
    @OneToMany(mappedBy = "factId")
    private List<CmpDetallefact> cmpDetallefactList;

    public CmpFactura() {
    }

    public CmpFactura(Long factId) {
        this.factId = factId;
    }

    public Long getFactId() {
        return factId;
    }

    public void setFactId(Long factId) {
        this.factId = factId;
    }

    public String getFactNumfact() {
        return factNumfact;
    }

    public void setFactNumfact(String factNumfact) {
        this.factNumfact = factNumfact;
    }

    public Boolean getFactPrefact() {
        return factPrefact;
    }

    public void setFactPrefact(Boolean factPrefact) {
        this.factPrefact = factPrefact;
    }

    public BigDecimal getFactValorbruto() {
        return factValorbruto;
    }

    public void setFactValorbruto(BigDecimal factValorbruto) {
        this.factValorbruto = factValorbruto;
    }

    public BigDecimal getFactValorneto() {
        return factValorneto;
    }

    public void setFactValorneto(BigDecimal factValorneto) {
        this.factValorneto = factValorneto;
    }

    public Boolean getFactEst() {
        return factEst;
    }

    public void setFactEst(Boolean factEst) {
        this.factEst = factEst;
    }

    public BigInteger getStrId() {
        return strId;
    }

    public void setStrId(BigInteger strId) {
        this.strId = strId;
    }

    public Integer getCxcId() {
        return cxcId;
    }

    public void setCxcId(Integer cxcId) {
        this.cxcId = cxcId;
    }

    public Date getFactFechaproceso() {
        return factFechaproceso;
    }

    public void setFactFechaproceso(Date factFechaproceso) {
        this.factFechaproceso = factFechaproceso;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public BigDecimal getFactPrevalorbruto() {
        return factPrevalorbruto;
    }

    public void setFactPrevalorbruto(BigDecimal factPrevalorbruto) {
        this.factPrevalorbruto = factPrevalorbruto;
    }

    public Boolean getFactProcesadorecibido() {
        return factProcesadorecibido;
    }

    public void setFactProcesadorecibido(Boolean factProcesadorecibido) {
        this.factProcesadorecibido = factProcesadorecibido;
    }

    public Boolean getFactProcesadocargainv() {
        return factProcesadocargainv;
    }

    public void setFactProcesadocargainv(Boolean factProcesadocargainv) {
        this.factProcesadocargainv = factProcesadocargainv;
    }

    public Boolean getFactEnvpagocuenta() {
        return factEnvpagocuenta;
    }

    public void setFactEnvpagocuenta(Boolean factEnvpagocuenta) {
        this.factEnvpagocuenta = factEnvpagocuenta;
    }

    public BigDecimal getFactAnticipo() {
        return factAnticipo;
    }

    public void setFactAnticipo(BigDecimal factAnticipo) {
        this.factAnticipo = factAnticipo;
    }

    public Date getFactFechamaxentrega() {
        return factFechamaxentrega;
    }

    public void setFactFechamaxentrega(Date factFechamaxentrega) {
        this.factFechamaxentrega = factFechamaxentrega;
    }

    public InvProovedor getPrvId() {
        return prvId;
    }

    public void setPrvId(InvProovedor prvId) {
        this.prvId = prvId;
    }

    @XmlTransient
    public List<InvTransac> getInvTransacList() {
        return invTransacList;
    }

    public void setInvTransacList(List<InvTransac> invTransacList) {
        this.invTransacList = invTransacList;
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
        hash += (factId != null ? factId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpFactura)) {
            return false;
        }
        CmpFactura other = (CmpFactura) object;
        if ((this.factId == null && other.factId != null) || (this.factId != null && !this.factId.equals(other.factId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpFactura[ factId=" + factId + " ]";
    }
    
}
