package com.uniminuto.elcp.agility.web.controlador.crud;

import com.uniminuto.elcp.agility.modelo.InvProovedor;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil.PersistAction;
import com.uniminuto.elcp.agility.ejb.crud.InvProovedorFacade;

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

@Named("invProovedorController")
@SessionScoped
public class InvProovedorController implements Serializable {

    @EJB
    private com.uniminuto.elcp.agility.ejb.crud.InvProovedorFacade ejbFacade;
    private List<InvProovedor> items = null;
    private InvProovedor selected;

    public InvProovedorController() {
    }

    public InvProovedor getSelected() {
        return selected;
    }

    public void setSelected(InvProovedor selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InvProovedorFacade getFacade() {
        return ejbFacade;
    }

    public InvProovedor prepareCreate() {
        selected = new InvProovedor();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InvProovedorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InvProovedorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InvProovedorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InvProovedor> getItems() {
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

    public InvProovedor getInvProovedor(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<InvProovedor> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InvProovedor> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InvProovedor.class)
    public static class InvProovedorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InvProovedorController controller = (InvProovedorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "invProovedorController");
            return controller.getInvProovedor(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof InvProovedor) {
                InvProovedor o = (InvProovedor) object;
                return getStringKey(o.getPrvId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InvProovedor.class.getName()});
                return null;
            }
        }

    }

}
