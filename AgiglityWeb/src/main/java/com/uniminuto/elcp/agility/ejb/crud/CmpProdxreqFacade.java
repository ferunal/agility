/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.ejb.crud;

import com.uniminuto.elcp.agility.modelo.CmpProdxreq;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fercris
 */
@Stateless
public class CmpProdxreqFacade extends AbstractFacade<CmpProdxreq> {

    @PersistenceContext(unitName = "com.unniminuto.lchacon_AgiglityWeb_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CmpProdxreqFacade() {
        super(CmpProdxreq.class);
    }
    
}
