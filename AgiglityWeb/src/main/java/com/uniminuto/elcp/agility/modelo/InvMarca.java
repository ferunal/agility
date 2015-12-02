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
@Table(name = "inv_marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvMarca.findAll", query = "SELECT i FROM InvMarca i"),
    @NamedQuery(name = "InvMarca.findByMarId", query = "SELECT i FROM InvMarca i WHERE i.marId = :marId"),
    @NamedQuery(name = "InvMarca.findByMarNombre", query = "SELECT i FROM InvMarca i WHERE i.marNombre = :marNombre"),
    @NamedQuery(name = "InvMarca.findByMarDesc", query = "SELECT i FROM InvMarca i WHERE i.marDesc = :marDesc"),
    @NamedQuery(name = "InvMarca.findByMarEst", query = "SELECT i FROM InvMarca i WHERE i.marEst = :marEst"),
    @NamedQuery(name = "InvMarca.findByIndversion", query = "SELECT i FROM InvMarca i WHERE i.indversion = :indversion")})
public class InvMarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mar_id")
    private Integer marId;
    @Size(max = 200)
    @Column(name = "mar_nombre")
    private String marNombre;
    @Size(max = 2147483647)
    @Column(name = "mar_desc")
    private String marDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mar_est")
    private boolean marEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marId")
    private List<CmpConspedido> cmpConspedidoList;
    @OneToMany(mappedBy = "marId")
    private List<CmpConsolcompra> cmpConsolcompraList;
    @OneToMany(mappedBy = "marId")
    private List<CmpProdxreq> cmpProdxreqList;
    @OneToMany(mappedBy = "marId")
    private List<InvInvent> invInventList;
    @OneToMany(mappedBy = "marId")
    private List<InvProdxprov> invProdxprovList;
    @OneToMany(mappedBy = "marId")
    private List<InvMarcxprod> invMarcxprodList;
    @OneToMany(mappedBy = "marId")
    private List<CmpPxraprob> cmpPxraprobList;

    public InvMarca() {
    }

    public InvMarca(Integer marId) {
        this.marId = marId;
    }

    public InvMarca(Integer marId, boolean marEst, int indversion) {
        this.marId = marId;
        this.marEst = marEst;
        this.indversion = indversion;
    }

    public Integer getMarId() {
        return marId;
    }

    public void setMarId(Integer marId) {
        this.marId = marId;
    }

    public String getMarNombre() {
        return marNombre;
    }

    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }

    public String getMarDesc() {
        return marDesc;
    }

    public void setMarDesc(String marDesc) {
        this.marDesc = marDesc;
    }

    public boolean getMarEst() {
        return marEst;
    }

    public void setMarEst(boolean marEst) {
        this.marEst = marEst;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
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

    @XmlTransient
    public List<InvMarcxprod> getInvMarcxprodList() {
        return invMarcxprodList;
    }

    public void setInvMarcxprodList(List<InvMarcxprod> invMarcxprodList) {
        this.invMarcxprodList = invMarcxprodList;
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
        hash += (marId != null ? marId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvMarca)) {
            return false;
        }
        InvMarca other = (InvMarca) object;
        if ((this.marId == null && other.marId != null) || (this.marId != null && !this.marId.equals(other.marId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvMarca[ marId=" + marId + " ]";
    }
    
}
