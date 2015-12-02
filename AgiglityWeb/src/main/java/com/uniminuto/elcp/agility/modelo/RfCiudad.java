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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "rf_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RfCiudad.findAll", query = "SELECT r FROM RfCiudad r"),
    @NamedQuery(name = "RfCiudad.findByCiuId", query = "SELECT r FROM RfCiudad r WHERE r.ciuId = :ciuId"),
    @NamedQuery(name = "RfCiudad.findByCiuCod", query = "SELECT r FROM RfCiudad r WHERE r.ciuCod = :ciuCod"),
    @NamedQuery(name = "RfCiudad.findByCiuDesc", query = "SELECT r FROM RfCiudad r WHERE r.ciuDesc = :ciuDesc")})
public class RfCiudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciu_id")
    private Long ciuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ciu_cod")
    private String ciuCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ciu_desc")
    private String ciuDesc;
    @JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
    @ManyToOne(optional = false)
    private RfDep depId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciuId")
    private List<RfLocalidad> rfLocalidadList;

    public RfCiudad() {
    }

    public RfCiudad(Long ciuId) {
        this.ciuId = ciuId;
    }

    public RfCiudad(Long ciuId, String ciuCod, String ciuDesc) {
        this.ciuId = ciuId;
        this.ciuCod = ciuCod;
        this.ciuDesc = ciuDesc;
    }

    public Long getCiuId() {
        return ciuId;
    }

    public void setCiuId(Long ciuId) {
        this.ciuId = ciuId;
    }

    public String getCiuCod() {
        return ciuCod;
    }

    public void setCiuCod(String ciuCod) {
        this.ciuCod = ciuCod;
    }

    public String getCiuDesc() {
        return ciuDesc;
    }

    public void setCiuDesc(String ciuDesc) {
        this.ciuDesc = ciuDesc;
    }

    public RfDep getDepId() {
        return depId;
    }

    public void setDepId(RfDep depId) {
        this.depId = depId;
    }

    @XmlTransient
    public List<RfLocalidad> getRfLocalidadList() {
        return rfLocalidadList;
    }

    public void setRfLocalidadList(List<RfLocalidad> rfLocalidadList) {
        this.rfLocalidadList = rfLocalidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciuId != null ? ciuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RfCiudad)) {
            return false;
        }
        RfCiudad other = (RfCiudad) object;
        if ((this.ciuId == null && other.ciuId != null) || (this.ciuId != null && !this.ciuId.equals(other.ciuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.RfCiudad[ ciuId=" + ciuId + " ]";
    }
    
}
