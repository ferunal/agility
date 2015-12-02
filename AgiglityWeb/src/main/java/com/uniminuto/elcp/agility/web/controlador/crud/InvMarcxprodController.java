package com.uniminuto.elcp.agility.web.controlador.crud;

import com.uniminuto.elcp.agility.modelo.InvMarcxprod;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil.PersistAction;
import com.uniminuto.elcp.agility.ejb.crud.InvMarcxprodFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("invMarcxprodController")
@SessionScoped
public class InvMarcxprodController implements Serializable {

    @EJB
    private com.uniminuto.elcp.agility.ejb.crud.InvMarcxprodFacade ejbFacade;
    private List<InvMarcxprod> items = null;
    private InvMarcxprod selected;

    public InvMarcxprodController() {
    }

    public InvMarcxprod getSelected() {
        return selected;
    }

    public void setSelected(InvMarcxprod selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InvMarcxprodFacade getFacade() {
        return ejbFacade;
    }

    public InvMarcxprod prepareCreate() {
        selected = new InvMarcxprod();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InvMarcxprodCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InvMarcxprodUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InvMarcxprodDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InvMarcxprod> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public InvMarcxprod getInvMarcxprod(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<InvMarcxprod> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InvMarcxprod> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InvMarcxprod.class)
    public static class InvMarcxprodControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InvMarcxprodController controller = (InvMarcxprodController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "invMarcxprodController");
            return controller.getInvMarcxprod(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof InvMarcxprod) {
                InvMarcxprod o = (InvMarcxprod) object;
                return getStringKey(o.getMxpId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InvMarcxprod.class.getName()});
                return null;
            }
        }

    }

}