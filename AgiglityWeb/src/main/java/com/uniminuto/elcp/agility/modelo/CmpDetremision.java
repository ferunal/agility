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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "cmp_detremision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmpDetremision.findAll", query = "SELECT c FROM CmpDetremision c"),
    @NamedQuery(name = "CmpDetremision.findByDrmId", query = "SELECT c FROM CmpDetremision c WHERE c.drmId = :drmId"),
    @NamedQuery(name = "CmpDetremision.findByDrmProcentregado", query = "SELECT c FROM CmpDetremision c WHERE c.drmProcentregado = :drmProcentregado"),
    @NamedQuery(name = "CmpDetremision.findByDrmProcinventario", query = "SELECT c FROM CmpDetremision c WHERE c.drmProcinventario = :drmProcinventario"),
    @NamedQuery(name = "CmpDetremision.findByDrmEst", query = "SELECT c FROM CmpDetremision c WHERE c.drmEst = :drmEst"),
    @NamedQuery(name = "CmpDetremision.findByIndversion", query = "SELECT c FROM CmpDetremision c WHERE c.indversion = :indversion")})
public class CmpDetremision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "drm_id")
    private Long drmId;
    @Column(name = "drm_procentregado")
    private Boolean drmProcentregado;
    @Column(name = "drm_procinventario")
    private Boolean drmProcinventario;
    @Column(name = "drm_est")
    private Boolean drmEst;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "drmId")
    private List<CmpEntregapedido> cmpEntregapedidoList;
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    @ManyToOne
    private CmpPxraprob praId;
    @JoinColumn(name = "rmi_id", referencedColumnName = "rmi_id")
    @ManyToOne
    private CmpRemisioninv rmiId;
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id")
    @ManyToOne
    private InvInvent invId;

    public CmpDetremision() {
    }

    public CmpDetremision(Long drmId) {
        this.drmId = drmId;
    }

    public Long getDrmId() {
        return drmId;
    }

    public void setDrmId(Long drmId) {
        this.drmId = drmId;
    }

    public Boolean getDrmProcentregado() {
        return drmProcentregado;
    }

    public void setDrmProcentregado(Boolean drmProcentregado) {
        this.drmProcentregado = drmProcentregado;
    }

    public Boolean getDrmProcinventario() {
        return drmProcinventario;
    }

    public void setDrmProcinventario(Boolean drmProcinventario) {
        this.drmProcinventario = drmProcinventario;
    }

    public Boolean getDrmEst() {
        return drmEst;
    }

    public void setDrmEst(Boolean drmEst) {
        this.drmEst = drmEst;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<CmpEntregapedido> getCmpEntregapedidoList() {
        return cmpEntregapedidoList;
    }

    public void setCmpEntregapedidoList(List<CmpEntregapedido> cmpEntregapedidoList) {
        this.cmpEntregapedidoList = cmpEntregapedidoList;
    }

    public CmpPxraprob getPraId() {
        return praId;
    }

    public void setPraId(CmpPxraprob praId) {
        this.praId = praId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drmId != null ? drmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CmpDetremision)) {
            return false;
        }
        CmpDetremision other = (CmpDetremision) object;
        if ((this.drmId == null && other.drmId != null) || (this.drmId != null && !this.drmId.equals(other.drmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.CmpDetremision[ drmId=" + drmId + " ]";
    }
    
}
