/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.elcp.agility.ejb.crud;

import com.uniminuto.elcp.agility.modelo.InvProducto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fercris
 */
@Stateless
public class InvProductoFacade extends AbstractFacade<InvProducto> {

    @PersistenceContext(unitName = "com.unniminuto.lchacon_AgiglityWeb_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<InvProducto> lstInvProductosXNombreLike(String nombre){
     return em.createNamedQuery("InvProducto.findByPrdNombreLike").setParameter("prdNombre", "%" + nombre + "%").getResultList();
    }
    public InvProductoFacade() {
        super(InvProducto.class);
    }
    
    
    
}
