/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.agiglityweb.web.jsf.base;

import com.uniminuto.lchacon.agility.ws.client.ClienteTalentoHumano;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fercris
 */
@SessionScoped()
@Named("principalJSFBean")
public class PrincipalJSFBean implements Serializable {

    private String strUsuario;
    private String strClave;

    public void validarUsuario() {
        ClienteTalentoHumano cth = new ClienteTalentoHumano();
        Boolean resultado = Boolean.parseBoolean(cth.validarUsuario(String.class, strUsuario, strClave));
        System.out.println("Validado: "+ resultado );
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
}
