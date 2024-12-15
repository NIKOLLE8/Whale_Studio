package com.beans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
    private static final long serialVersionUID=1L;
    
    private String localidad;
    
    private static Map<String, Object> LstPaises;

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public Map<String, Object> getLstPaises() {
        return LstPaises;
    }
    public static void setLstPaises(Map<String, Object> lstPaises) {
        UsuarioBean.LstPaises=lstPaises;
    }
    static{
    LstPaises = new LinkedHashMap<>();
    Locale es= new Locale("ES");
    LstPaises.put("Español", es);
    LstPaises.put("English",Locale.ENGLISH);
    Locale zh=new Locale("ZH");
    LstPaises.put("Chino", zh);

    }
    public void localidadChanged(ValueChangeEvent e){
        String newLocaleValue = e.getNewValue().toString();
        for(Map.Entry<String,Object> entry:LstPaises.entrySet()){
            if(entry.getValue().toString().equals(newLocaleValue)){
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }
}
