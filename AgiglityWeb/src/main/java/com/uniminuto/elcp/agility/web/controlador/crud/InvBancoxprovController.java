package com.uniminuto.elcp.agility.web.controlador.crud;

import com.uniminuto.elcp.agility.modelo.InvBancoxprov;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil.PersistAction;
import com.uniminuto.elcp.agility.ejb.crud.InvBancoxprovFacade;

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

@Named("invBancoxprovController")
@SessionScoped
public class InvBancoxprovController implements Serializable {

    @EJB
    private com.uniminuto.elcp.agility.ejb.crud.InvBancoxprovFacade ejbFacade;
    private List<InvBancoxprov> items = null;
    private InvBancoxprov selected;

    public InvBancoxprovController() {
    }

    public InvBancoxprov getSelected() {
        return selected;
    }

    public void setSelected(InvBancoxprov selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InvBancoxprovFacade getFacade() {
        return ejbFacade;
    }

    public InvBancoxprov prepareCreate() {
        selected = new InvBancoxprov();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InvBancoxprovCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InvBancoxprovUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InvBancoxprovDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InvBancoxprov> getItems() {
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

    public InvBancoxprov getInvBancoxprov(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<InvBancoxprov> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InvBancoxprov> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InvBancoxprov.class)
    public static class InvBancoxprovControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InvBancoxprovController controller = (InvBancoxprovController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "invBancoxprovController");
            return controller.getInvBancoxprov(getKey(value));
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
            if (object instanceof InvBancoxprov) {
                InvBancoxprov o = (InvBancoxprov) object;
                return getStringKey(o.getBxpId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InvBancoxprov.class.getName()});
                return null;
            }
        }

    }

}
