package com.uniminuto.elcp.agility.web.controlador.crud;

import com.uniminuto.elcp.agility.modelo.CmpRfTiporequisicion;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil;
import com.uniminuto.elcp.agility.web.controlador.crud.util.JsfUtil.PersistAction;
import com.uniminuto.elcp.agility.ejb.crud.CmpRfTiporequisicionFacade;

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

@Named("cmpRfTiporequisicionController")
@SessionScoped
public class CmpRfTiporequisicionController implements Serializable {

    @EJB
    private com.uniminuto.elcp.agility.ejb.crud.CmpRfTiporequisicionFacade ejbFacade;
    private List<CmpRfTiporequisicion> items = null;
    private CmpRfTiporequisicion selected;

    public CmpRfTiporequisicionController() {
    }

    public CmpRfTiporequisicion getSelected() {
        return selected;
    }

    public void setSelected(CmpRfTiporequisicion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CmpRfTiporequisicionFacade getFacade() {
        return ejbFacade;
    }

    public CmpRfTiporequisicion prepareCreate() {
        selected = new CmpRfTiporequisicion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CmpRfTiporequisicionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CmpRfTiporequisicionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CmpRfTiporequisicionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CmpRfTiporequisicion> getItems() {
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

    public CmpRfTiporequisicion getCmpRfTiporequisicion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CmpRfTiporequisicion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CmpRfTiporequisicion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CmpRfTiporequisicion.class)
    public static class CmpRfTiporequisicionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CmpRfTiporequisicionController controller = (CmpRfTiporequisicionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cmpRfTiporequisicionController");
            return controller.getCmpRfTiporequisicion(getKey(value));
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
            if (object instanceof CmpRfTiporequisicion) {
                CmpRfTiporequisicion o = (CmpRfTiporequisicion) object;
                return getStringKey(o.getTrqId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CmpRfTiporequisicion.class.getName()});
                return null;
            }
        }

    }

}
