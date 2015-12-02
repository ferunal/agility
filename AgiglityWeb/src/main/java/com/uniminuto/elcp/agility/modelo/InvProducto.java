/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "inv_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProducto.findAll", query = "SELECT i FROM InvProducto i"),
    @NamedQuery(name = "InvProducto.findByPrdId", query = "SELECT i FROM InvProducto i WHERE i.prdId = :prdId"),
    @NamedQuery(name = "InvProducto.findByPrdNombre", query = "SELECT i FROM InvProducto i WHERE i.prdNombre = :prdNombre"),
    @NamedQuery(name = "InvProducto.findByPrdDesc", query = "SELECT i FROM InvProducto i WHERE i.prdDesc = :prdDesc"),
    @NamedQuery(name = "InvProducto.findByPrdEst", query = "SELECT i FROM InvProducto i WHERE i.prdEst = :prdEst"),
    @NamedQuery(name = "InvProducto.findByIndversion", query = "SELECT i FROM InvProducto i WHERE i.indversion = :indversion"),
    @NamedQuery(name = "InvProducto.findByPrdEsp", query = "SELECT i FROM InvProducto i WHERE i.prdEsp = :prdEsp"),
    @NamedQuery(name = "InvProducto.findByPrdOcasnl", query = "SELECT i FROM InvProducto i WHERE i.prdOcasnl = :prdOcasnl"),
    @NamedQuery(name = "InvProducto.findByPrdUnico", query = "SELECT i FROM InvProducto i WHERE i.prdUnico = :prdUnico"),
    @NamedQuery(name = "InvProducto.findByPrdNombreLike", query = "SELECT i FROM InvProducto i WHERE i.prdNombre LIKE :prdNombre"),
})
public class InvProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_id")
    private Integer prdId;
    @Size(max = 500)
    @Column(name = "prd_nombre")
    private String prdNombre;
    @Size(max = 2147483647)
    @Column(name = "prd_desc")
    private String prdDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_est")
    private boolean prdEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_esp")
    private boolean prdEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_ocasnl")
    private boolean prdOcasnl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prd_unico")
    private boolean prdUnico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prdId")
    private List<CmpConspedido> cmpConspedidoList;
    @OneToMany(mappedBy = "prdId")
    private List<CmpConsolcompra> cmpConsolcompraList;
    @OneToMany(mappedBy = "prdId")
    private List<CmpProdxreq> cmpProdxreqList;
    @OneToMany(mappedBy = "prdId")
    private List<InvInvent> invInventList;
    @OneToMany(mappedBy = "prdId")
    private List<InvProdxprov> invProdxprovList;
    @JoinColumn(name = "cpd_id", referencedColumnName = "cpd_id")
    @ManyToOne
    private InvCatprod cpdId;
    @OneToMany(mappedBy = "prdId")
    private List<InvMarcxprod> invMarcxprodList;
    @OneToMany(mappedBy = "prdId")
    private List<InvPresntxprod> invPresntxprodList;

    public InvProducto() {
    }

    public InvProducto(Integer prdId) {
        this.prdId = prdId;
    }

    public InvProducto(Integer prdId, boolean prdEst, int indversion, boolean prdEsp, boolean prdOcasnl, boolean prdUnico) {
        this.prdId = prdId;
        this.prdEst = prdEst;
        this.indversion = indversion;
        this.prdEsp = prdEsp;
        this.prdOcasnl = prdOcasnl;
        this.prdUnico = prdUnico;
    }

    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    public String getPrdNombre() {
        return prdNombre;
    }

    public void setPrdNombre(String prdNombre) {
        this.prdNombre = prdNombre;
    }

    public String getPrdDesc() {
        return prdDesc;
    }

    public void setPrdDesc(String prdDesc) {
        this.prdDesc = prdDesc;
    }

    public boolean getPrdEst() {
        return prdEst;
    }

    public void setPrdEst(boolean prdEst) {
        this.prdEst = prdEst;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public boolean getPrdEsp() {
        return prdEsp;
    }

    public void setPrdEsp(boolean prdEsp) {
        this.prdEsp = prdEsp;
    }

    public boolean getPrdOcasnl() {
        return prdOcasnl;
    }

    public void setPrdOcasnl(boolean prdOcasnl) {
        this.prdOcasnl = prdOcasnl;
    }

    public boolean getPrdUnico() {
        return prdUnico;
    }

    public void setPrdUnico(boolean prdUnico) {
        this.prdUnico = prdUnico;
    }

    @XmlTransient
    public List<CmpConspedido> getCmpConspedidoList() {
        return cmpConspedidoList;
    }

    public void setCmpConspedidoList(List<CmpConspedido> cmpConspedidoList) {
        this.cmpConspedidoList = cmpConspedidoList;
    }

    @XmlTransient
    public List<CmpConsolcompra> getCmpConsolcompraList() {
        return cmpConsolcompraList;
    }

    public void setCmpConsolcompraList(List<CmpConsolcompra> cmpConsolcompraList) {
        this.cmpConsolcompraList = cmpConsolcompraList;
    }

    @XmlTransient
    public List<CmpProdxreq> getCmpProdxreqList() {
        return cmpProdxreqList;
    }

    public void setCmpProdxreqList(List<CmpProdxreq> cmpProdxreqList) {
        this.cmpProdxreqList = cmpProdxreqList;
    }

    @XmlTransient
    public List<InvInvent> getInvInventList() {
        return invInventList;
    }

    public void setInvInventList(List<InvInvent> invInventList) {
        this.invInventList = invInventList;
    }

    @XmlTransient
    public List<InvProdxprov> getInvProdxprovList() {
        return invProdxprovList;
    }

    public void setInvProdxprovList(List<InvProdxprov> invProdxprovList) {
        this.invProdxprovList = invProdxprovList;
    }

    public InvCatprod getCpdId() {
        return cpdId;
    }

    public void setCpdId(InvCatprod cpdId) {
        this.cpdId = cpdId;
    }

    @XmlTransient
    public List<InvMarcxprod> getInvMarcxprodList() {
        return invMarcxprodList;
    }

    public void setInvMarcxprodList(List<InvMarcxprod> invMarcxprodList) {
        this.invMarcxprodList = invMarcxprodList;
    }

    @XmlTransient
    public List<InvPresntxprod> getInvPresntxprodList() {
        return invPresntxprodList;
    }

    public void setInvPresntxprodList(List<InvPresntxprod> invPresntxprodList) {
        this.invPresntxprodList = invPresntxprodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdId != null ? prdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProducto)) {
            return false;
        }
        InvProducto other = (InvProducto) object;
        if ((this.prdId == null && other.prdId != null) || (this.prdId != null && !this.prdId.equals(other.prdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvProducto[ prdId=" + prdId + " ]";
    }
    
}
