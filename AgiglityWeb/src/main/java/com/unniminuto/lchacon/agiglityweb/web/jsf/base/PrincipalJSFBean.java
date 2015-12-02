/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.agiglityweb.web.jsf.base;

import com.uniminuto.lchacon.agility.ws.client.ClienteTalentoHumano;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author fercris
 */
@SessionScoped
@Named("principalJSFBean")
public class PrincipalJSFBean implements Serializable {

    private String strUsuario;
    private String strClave;
    protected String reglaNav;

    public void validarUsuario() {
        ClienteTalentoHumano cth = new ClienteTalentoHumano();
        Boolean resultado = Boolean.parseBoolean(cth.validarUsuario(String.class, strUsuario, strClave));
        if (resultado) {
            try {
                ExternalContext nextPage = FacesContext.getCurrentInstance()
                        .getExternalContext();
                nextPage.redirect(nextPage.getRequestContextPath() + "/compras/Compra.jsf");
                reglaNav = "ingresar?faces-redirect=true";
            } catch (IOException ex) {
                Logger.getLogger(PrincipalJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            reglaNav = "";
        }
    }
    
    public String validarUsario_A() {
        return reglaNav;
    }

    /**
     * @return the strUsuario
     */
    public String getStrUsuario() {
        return strUsuario;
    }

    /**
     * @param strUsuario the strUsuario to set
     */
    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    /**
     * @return the strClave
     */
    public String getStrClave() {
        return strClave;
    }

    /**
     * @param strClave the strClave to set
     */
    public void setStrClave(String strClave) {
        this.strClave = strClave;
    }

    /**
     * @return the reglaNav
     */
    public String getReglaNav() {
        return reglaNav;
    }

    /**
     * @param reglaNav the reglaNav to set
     */
    public void setReglaNav(String reglaNav) {
        this.reglaNav = reglaNav;
    }
}
