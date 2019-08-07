package com.academik.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author esvux
 */
@SessionScoped
@ManagedBean
public class CustomSecurityBean {
    
    public String logout() {
        return "/index";
    }
    
}
