/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.agiglityweb.web.jsf.compras;

import com.uniminuto.elcp.agility.ejb.crud.InvProductoFacade;
import com.uniminuto.elcp.agility.modelo.InvProducto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author lchacon
 */
@SessionScoped
@Named("comprasJSFBean")
public class ComprasJSFBean implements Serializable {

    protected String cadenaBusqueda;
    private InvProducto selected;

    public InvProducto getSelected() {
        return selected;
    }

    public void setSelected(InvProducto selected) {
        this.selected = selected;
    }

    protected List<InvProducto> lstInvProductos = new ArrayList<>();

    public void buscarProductosXNombre_AE() {
        lstInvProductos = invProductoFacade.lstInvProductosXNombreLike(cadenaBusqueda);
    }

    @EJB
    InvProductoFacade invProductoFacade;

    /**
     * @return the cadenaBusqueda
     */
    public String getCadenaBusqueda() {
        return cadenaBusqueda;
    }

    /**
     * @param cadenaBusqueda the cadenaBusqueda to set
     */
    public void setCadenaBusqueda(String cadenaBusqueda) {
        this.cadenaBusqueda = cadenaBusqueda;
    }

    /**
     * @return the lstInvProductos
     */
    public List<InvProducto> getLstInvProductos() {
        return lstInvProductos;
    }

    /**
     * @param lstInvProductos the lstInvProductos to set
     */
    public void setLstInvProductos(List<InvProducto> lstInvProductos) {
        this.lstInvProductos = lstInvProductos;
    }
}
