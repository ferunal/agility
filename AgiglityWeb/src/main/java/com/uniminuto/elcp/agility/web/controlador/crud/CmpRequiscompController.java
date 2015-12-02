package com.uniminuto.elcp.agility.web.controlador.crud;

import com.uniminuto.elcp.agility.modelo.CmpRequiscomp;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil.PersistAction;
import com.uniminuto.elcp.agility.ejb.crud.CmpRequiscompFacade;

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

@Named("cmpRequiscompController")
@SessionScoped
public class CmpRequiscompController implements Serializable {

    @EJB
    private com.uniminuto.elcp.agility.ejb.crud.CmpRequiscompFacade ejbFacade;
    private List<CmpRequiscomp> items = null;
    private CmpRequiscomp selected;

    public CmpRequiscompController() {
    }

    public CmpRequiscomp getSelected() {
        return selected;
    }

    public void setSelected(CmpRequiscomp selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CmpRequiscompFacade getFacade() {
        return ejbFacade;
    }

    public CmpRequiscomp prepareCreate() {
        selected = new CmpRequiscomp();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CmpRequiscompCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CmpRequiscompUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CmpRequiscompDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CmpRequiscomp> getItems() {
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

    public CmpRequiscomp getCmpRequiscomp(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CmpRequiscomp> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CmpRequiscomp> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CmpRequiscomp.class)
    public static class CmpRequiscompControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CmpRequiscompController controller = (CmpRequiscompController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cmpRequiscompController");
            return controller.getCmpRequiscomp(getKey(value));
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
            if (object instanceof CmpRequiscomp) {
                CmpRequiscomp o = (CmpRequiscomp) object;
                return getStringKey(o.getCrqId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CmpRequiscomp.class.getName()});
                return null;
            }
        }

    }

}
