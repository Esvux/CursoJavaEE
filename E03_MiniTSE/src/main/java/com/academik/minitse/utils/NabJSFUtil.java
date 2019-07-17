package com.academik.minitse.utils;

import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author esvux
 */
public class NabJSFUtil {
    
    public static String getParameter(String name) {
        return FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get(name);
    }
    
    public static void redirectTo(String redirect) throws IOException {
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .redirect(redirect);
    }
    
}
