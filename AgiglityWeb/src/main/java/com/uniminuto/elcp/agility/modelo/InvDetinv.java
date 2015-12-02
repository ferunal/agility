/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fercris
 */
@Entity
@Table(name = "inv_detinv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvDetinv.findAll", query = "SELECT i FROM InvDetinv i"),
    @NamedQuery(name = "InvDetinv.findByDivId", query = "SELECT i FROM InvDetinv i WHERE i.divId = :divId"),
    @NamedQuery(name = "InvDetinv.findByDivNumserie", query = "SELECT i FROM InvDetinv i WHERE i.divNumserie = :divNumserie"),
    @NamedQuery(name = "InvDetinv.findByDivModelo", query = "SELECT i FROM InvDetinv i WHERE i.divModelo = :divModelo"),
    @NamedQuery(name = "InvDetinv.findByDivDesc", query = "SELECT i FROM InvDetinv i WHERE i.divDesc = :divDesc"),
    @NamedQuery(name = "InvDetinv.findByIndversion", query = "SELECT i FROM InvDetinv i WHERE i.indversion = :indversion"),
    @NamedQuery(name = "InvDetinv.findByDivNumserialfabricante", query = "SELECT i FROM InvDetinv i WHERE i.divNumserialfabricante = :divNumserialfabricante"),
    @NamedQuery(name = "InvDetinv.findByDivDescripcion", query = "SELECT i FROM InvDetinv i WHERE i.divDescripcion = :divDescripcion"),
    @NamedQuery(name = "InvDetinv.findByDivLibre", query = "SELECT i FROM InvDetinv i WHERE i.divLibre = :divLibre")})
public class InvDetinv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "div_id")
    private Integer divId;
    @Size(max = 100)
    @Column(name = "div_numserie")
    private String divNumserie;
    @Size(max = 100)
    @Column(name = "div_modelo")
    private String divModelo;
    @Size(max = 2147483647)
    @Column(name = "div_desc")
    private String divDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indversion")
    private int indversion;
    @Size(max = 150)
    @Column(name = "div_numserialfabricante")
    private String divNumserialfabricante;
    @Size(max = 2147483647)
    @Column(name = "div_descripcion")
    private String divDescripcion;
    @Column(name = "div_libre")
    private Boolean divLibre;
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id")
    @ManyToOne
    private InvInvent invId;

    public InvDetinv() {
    }

    public InvDetinv(Integer divId) {
        this.divId = divId;
    }

    public InvDetinv(Integer divId, int indversion) {
        this.divId = divId;
        this.indversion = indversion;
    }

    public Integer getDivId() {
        return divId;
    }

    public void setDivId(Integer divId) {
        this.divId = divId;
    }

    public String getDivNumserie() {
        return divNumserie;
    }

    public void setDivNumserie(String divNumserie) {
        this.divNumserie = divNumserie;
    }

    public String getDivModelo() {
        return divModelo;
    }

    public void setDivModelo(String divModelo) {
        this.divModelo = divModelo;
    }

    public String getDivDesc() {
        return divDesc;
    }

    public void setDivDesc(String divDesc) {
        this.divDesc = divDesc;
    }

    public int getIndversion() {
        return indversion;
    }

    public void setIndversion(int indversion) {
        this.indversion = indversion;
    }

    public String getDivNumserialfabricante() {
        return divNumserialfabricante;
    }

    public void setDivNumserialfabricante(String divNumserialfabricante) {
        this.divNumserialfabricante = divNumserialfabricante;
    }

    public String getDivDescripcion() {
        return divDescripcion;
    }

    public void setDivDescripcion(String divDescripcion) {
        this.divDescripcion = divDescripcion;
    }

    public Boolean getDivLibre() {
        return divLibre;
    }

    public void setDivLibre(Boolean divLibre) {
        this.divLibre = divLibre;
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
        hash += (divId != null ? divId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvDetinv)) {
            return false;
        }
        InvDetinv other = (InvDetinv) object;
        if ((this.divId == null && other.divId != null) || (this.divId != null && !this.divId.equals(other.divId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvDetinv[ divId=" + divId + " ]";
    }
    
}
