/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unniminuto.lchacon.electivacp.th.ws;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author fercris
 */
@Stateless
@Path("/talentoHumano")
public class TalentoHumano {

    @GET
    public String validarUsuario(@QueryParam("usrId") String usrId, @QueryParam("usrClave") String usrClave) {
        return Boolean.toString($validarUsuario(usrId, usrClave));
    }

    public boolean $validarUsuario(String usrId, String usrClave) {
        return true;
    }
}
