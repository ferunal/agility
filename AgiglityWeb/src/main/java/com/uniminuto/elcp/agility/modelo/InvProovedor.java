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
@Table(name = "inv_proovedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvProovedor.findAll", query = "SELECT i FROM InvProovedor i"),
    @NamedQuery(name = "InvProovedor.findByPrvId", query = "SELECT i FROM InvProovedor i WHERE i.prvId = :prvId"),
    @NamedQuery(name = "InvProovedor.findByPrvRazonsoc", query = "SELECT i FROM InvProovedor i WHERE i.prvRazonsoc = :prvRazonsoc"),
    @NamedQuery(name = "InvProovedor.findByPrvDesc", query = "SELECT i FROM InvProovedor i WHERE i.prvDesc = :prvDesc"),
    @NamedQuery(name = "InvProovedor.findByPrvTel1", query = "SELECT i FROM InvProovedor i WHERE i.prvTel1 = :prvTel1"),
    @NamedQuery(name = "InvProovedor.findByPrvTel2", query = "SELECT i FROM InvProovedor i WHERE i.prvTel2 = :prvTel2"),
    @NamedQuery(name = "InvProovedor.findByPrvEmail", query = "SELECT i FROM InvProovedor i WHERE i.prvEmail = :prvEmail"),
    @NamedQuery(name = "InvProovedor.findByPrvDireccion", query = "SELECT i FROM InvProovedor i WHERE i.prvDireccion = :prvDireccion"),
    @NamedQuery(name = "InvProovedor.findByPrvDigver", query = "SELECT i FROM InvProovedor i WHERE i.prvDigver = :prvDigver"),
    @NamedQuery(name = "InvProovedor.findByFpgId", query = "SELECT i FROM InvProovedor i WHERE i.fpgId = :fpgId"),
    @NamedQuery(name = "InvProovedor.findByPrvNit", query = "SELECT i FROM InvProovedor i WHERE i.prvNit = :prvNit"),
    @NamedQuery(name = "InvProovedor.findByPrvContacto", query = "SELECT i FROM InvProovedor i WHERE i.prvContacto = :prvContacto"),
    @NamedQuery(name = "InvProovedor.findByPrvTelcontacto", query = "SELECT i FROM InvProovedor i WHERE i.prvTelcontacto = :prvTelcontacto"),
    @NamedQuery(name = "InvProovedor.findByPrvEstado", query = "SELECT i FROM InvProovedor i WHERE i.prvEstado = :prvEstado"),
    @NamedQuery(name = "InvProovedor.findByIndversion", query = "SELECT i FROM InvProovedor i WHERE i.indversion = :indversion")})
public class InvProovedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prv_id")
    private Integer prvId;
    @Size(max = 2147483647)
    @Column(name = "prv_razonsoc")
    private String prvRazonsoc;
    @Size(max = 2147483647)
    @Column(name = "prv_desc")
    private String prvDesc;
    @Size(max = 50)
    @Column(name = "prv_tel1")
    private String prvTel1;
    @Size(max = 50)
    @Column(name = "prv_tel2")
    private String prvTel2;
    @Size(max = 100)
    @Column(name = "prv_email")
    private String prvEmail;
    @Size(max = 800)
    @Column(name = "prv_direccion")
    private String prvDireccion;
    @Column(name = "prv_digver")
    private Integer prvDigver;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpg_id")
    private int fpgId;
    @Size(max = 25)
    @Column(name = "prv_nit")
    private String prvNit;
    @Size(max = 300)
    @Column(name = "prv_contacto")
    private String prvContacto;
    @Size(max = 20)
    @Column(name = "prv_telcontacto")
    private String prvTelcontacto;
    @Column(name = "prv_estado")
    private Boolean prvEstado;
    @Column(name = "indversion")
    private Integer indversion;
    @OneToMany(mappedBy = "prvId")
    private List<InvBancoxprov> invBancoxprovList;
    @OneToMany(mappedBy = "prvId")
    private List<CmpConsolcompra> cmpConsolcompraList;
    @OneToMany(mappedBy = "prvId")
    private List<CmpFactura> cmpFacturaList;
    @OneToMany(mappedBy = "prvId")
    private List<InvProdxprov> invProdxprovList;

    public InvProovedor() {
    }

    public InvProovedor(Integer prvId) {
        this.prvId = prvId;
    }

    public InvProovedor(Integer prvId, int fpgId) {
        this.prvId = prvId;
        this.fpgId = fpgId;
    }

    public Integer getPrvId() {
        return prvId;
    }

    public void setPrvId(Integer prvId) {
        this.prvId = prvId;
    }

    public String getPrvRazonsoc() {
        return prvRazonsoc;
    }

    public void setPrvRazonsoc(String prvRazonsoc) {
        this.prvRazonsoc = prvRazonsoc;
    }

    public String getPrvDesc() {
        return prvDesc;
    }

    public void setPrvDesc(String prvDesc) {
        this.prvDesc = prvDesc;
    }

    public String getPrvTel1() {
        return prvTel1;
    }

    public void setPrvTel1(String prvTel1) {
        this.prvTel1 = prvTel1;
    }

    public String getPrvTel2() {
        return prvTel2;
    }

    public void setPrvTel2(String prvTel2) {
        this.prvTel2 = prvTel2;
    }

    public String getPrvEmail() {
        return prvEmail;
    }

    public void setPrvEmail(String prvEmail) {
        this.prvEmail = prvEmail;
    }

    public String getPrvDireccion() {
        return prvDireccion;
    }

    public void setPrvDireccion(String prvDireccion) {
        this.prvDireccion = prvDireccion;
    }

    public Integer getPrvDigver() {
        return prvDigver;
    }

    public void setPrvDigver(Integer prvDigver) {
        this.prvDigver = prvDigver;
    }

    public int getFpgId() {
        return fpgId;
    }

    public void setFpgId(int fpgId) {
        this.fpgId = fpgId;
    }

    public String getPrvNit() {
        return prvNit;
    }

    public void setPrvNit(String prvNit) {
        this.prvNit = prvNit;
    }

    public String getPrvContacto() {
        return prvContacto;
    }

    public void setPrvContacto(String prvContacto) {
        this.prvContacto = prvContacto;
    }

    public String getPrvTelcontacto() {
        return prvTelcontacto;
    }

    public void setPrvTelcontacto(String prvTelcontacto) {
        this.prvTelcontacto = prvTelcontacto;
    }

    public Boolean getPrvEstado() {
        return prvEstado;
    }

    public void setPrvEstado(Boolean prvEstado) {
        this.prvEstado = prvEstado;
    }

    public Integer getIndversion() {
        return indversion;
    }

    public void setIndversion(Integer indversion) {
        this.indversion = indversion;
    }

    @XmlTransient
    public List<InvBancoxprov> getInvBancoxprovList() {
        return invBancoxprovList;
    }

    public void setInvBancoxprovList(List<InvBancoxprov> invBancoxprovList) {
        this.invBancoxprovList = invBancoxprovList;
    }

    @XmlTransient
    public List<CmpConsolcompra> getCmpConsolcompraList() {
        return cmpConsolcompraList;
    }

    public void setCmpConsolcompraList(List<CmpConsolcompra> cmpConsolcompraList) {
        this.cmpConsolcompraList = cmpConsolcompraList;
    }

    @XmlTransient
    public List<CmpFactura> getCmpFacturaList() {
        return cmpFacturaList;
    }

    public void setCmpFacturaList(List<CmpFactura> cmpFacturaList) {
        this.cmpFacturaList = cmpFacturaList;
    }

    @XmlTransient
    public List<InvProdxprov> getInvProdxprovList() {
        return invProdxprovList;
    }

    public void setInvProdxprovList(List<InvProdxprov> invProdxprovList) {
        this.invProdxprovList = invProdxprovList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prvId != null ? prvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvProovedor)) {
            return false;
        }
        InvProovedor other = (InvProovedor) object;
        if ((this.prvId == null && other.prvId != null) || (this.prvId != null && !this.prvId.equals(other.prvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.elcp.agility.modelo.InvProovedor[ prvId=" + prvId + " ]";
    }
    
}
