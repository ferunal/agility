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
@Table(name = "cmp_remisioninv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpRemisioninv.findAll", query = "SELECT c FROM CmpRemisioninv c"),
    @NamedQuery(name = "CmpRemisioninv.findByRmiId", query = "SELECT c FROM CmpRemisioninv c WHERE c.rmiId = :rmiId"),
    @NamedQuery(name = "CmpRemisioninv.findByRmiFechaproceso", query = "SELECT c FROM CmpRemisioninv c WHERE c.rmiFechaproceso = :rmiFechaproceso"),
    @NamedQuery(name = "CmpRemisioninv.findByRmiFechaentrega", query = "SELECT c FROM CmpRemisioninv c WHERE c.rmiFechaentrega = :rmiFechaentrega"),
    @NamedQuery(name = "CmpRemisioninv.findByRmiEst", query = "SELECT c FROM CmpRemisioninv c WHERE c.rmiEst = :rmiEst"),
    @NamedQuery(name = "CmpRemisioninv.findByCxcIdorigen", query = "SELECT c FROM CmpRemisioninv c WHERE c.cxcIdorigen = :cxcIdorigen"),
    @NamedQuery(name = "CmpRemisioninv.findByCxcIddestino", query = "SELECT c FROM CmpRemisioninv c WHERE c.cxcIddestino = :cxcIddestino"),
    @NamedQuery(name = "CmpRemisioninv.findByIndversion", query = "SELECT c FROM CmpRemisioninv c WHERE c.indversion = :indversion"),
    @NamedQuery(name = "CmpRemisioninv.findByStrId", query = "SELECT c FROM CmpRemisioninv c WHERE c.strId = :strId"),
    @NamedQuery(name = "CmpRemisioninv.findByRmiObsrentrega", query = "SELECT c FROM CmpRemisioninv c WHERE c.rmiObsrentrega = :rmiObsrentrega")})
public class CmpRemisioninv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rmi_id")
    private Long rmiId;
    @Column(name = "rmi_fechaproceso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rmiFechaproceso;
    @Column(name = "rmi_fechaentrega")
    @Temporal(TemporalType.DATE)
    private Date rmiFechaentrega;
    @Column(name = "rmi_est")
    private Boolean rmiEst;
    @Column(name = "cxc_idorigen")
    private Integer cxcIdorigen;
    @Column(name = "cxc_iddestino")
    private Integer cxcIddestino;
    @Column(name = "indversion")
    private Integer indversion;
    @Column(name = "str_id")
    private BigInteger strId;
    @Size(max = 2147483647)
    @Column(name = "rmi_obsrentrega")
    private String rmiObsrentrega;
    @OneToMany(mappedBy = "rmiId")
    private List<InvTransac> invTransacList;
    @OneToMany(mappedBy = "rmiId")
    private List<CmpDetremision> cmpDetremisionList;

    public CmpRemisioninv() {
    }

    public CmpRemisioninv(Long rmiId) {
        this.rmiId = rmiId;
    }

    public Long getRmiId() {
        return rmiId;
    }

    public void setRmiId(Long rmiId) {
        this.rmiId = rmiId;
    }

    public Date getRmiFechaproceso() {
        return rmiFechaproceso;
    }

    public void setRmiFechaproceso(Date rmiFechaproceso) {
        this.rmiFechaproceso = rmiFechaproceso;
    }

    public Date getRmiFechaentrega() {
        return rmiFechaentrega;
    }

    public void setRmiFechaentrega(Date rmiFechaentrega) {
        this.rmiFechaentrega = rmiFechaentrega;
    }

    public Boolean getRmiEst() {
        return rmiEst;
    }

    public void setRmiEst(Boolean rmiEst) {
        this.rmiEst = rmiEst;
    }

    public Integer getCxcIdorigen() {
        return cxcIdorigen;
    }

    public void setCxcIdorigen(Integer cxcIdorigen) {
        this.cxcIdorigen = cxcIdorigen;
    }

    public Integer getCxcIddestino() {
        return cxcIddestino;
    }

    public void setCxcIddestino(Integer cxcIddestino) {
        this.cxcIddestino = cxcIddestino;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    public BigInteger getStrId() {
        return strId;
    }

    public void setStrId(BigInteger strId) {
        this.strId = strId;
    }

    public String getRmiObsrentrega() {
        return rmiObsrentrega;
    }

    public void setRmiObsrentrega(String rmiObsrentrega) {
        this.rmiObsrentrega = rmiObsrentrega;
    }

    @XmlTransient
    public List<InvTransac> getInvTransacList() {
        return invTransacList;
    }

    public void setInvTransacList(List<InvTransac> invTransacList) {
        this.invTransacList = invTransacList;
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
        hash += (rmiId != null ? rmiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpRemisioninv)) {
            return false;
        }
        CmpRemisioninv other = (CmpRemisioninv) object;
        if ((this.rmiId == null && other.rmiId != null) || (this.rmiId != null && !this.rmiId.equals(other.rmiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpRemisioninv[ rmiId=" + rmiId + " ]";
    }
    
}
