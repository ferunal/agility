package com.uniminuto.elcp.agility.web.controlador.crud;

import com.uniminuto.elcp.agility.modelo.RfLocalidad;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil.PersistAction;
import com.uniminuto.elcp.agility.ejb.crud.RfLocalidadFacade;

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

@Named("rfLocalidadController")
@SessionScoped
public class RfLocalidadController implements Serializable {

    @EJB
    private com.uniminuto.elcp.agility.ejb.crud.RfLocalidadFacade ejbFacade;
    private List<RfLocalidad> items = null;
    private RfLocalidad selected;

    public RfLocalidadController() {
    }

    public RfLocalidad getSelected() {
        return selected;
    }

    public void setSelected(RfLocalidad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private RfLocalidadFacade getFacade() {
        return ejbFacade;
    }

    public RfLocalidad prepareCreate() {
        selected = new RfLocalidad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RfLocalidadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RfLocalidadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RfLocalidadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RfLocalidad> getItems() {
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

    public RfLocalidad getRfLocalidad(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<RfLocalidad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RfLocalidad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RfLocalidad.class)
    public static class RfLocalidadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RfLocalidadController controller = (RfLocalidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rfLocalidadController");
            return controller.getRfLocalidad(getKey(value));
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
            if (object instanceof RfLocalidad) {
                RfLocalidad o = (RfLocalidad) object;
                return getStringKey(o.getLocId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RfLocalidad.class.getName()});
                return null;
            }
        }

    }

}
