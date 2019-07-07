package com.academik.minitse.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "nav")
@ApplicationScoped
public class NavigationBean {
    
    private String immediateRedirect(String url) {
        return url + "?faces-redirect=true";
    }
    
    public String goVotingPlaces() {
        return immediateRedirect("votingplaces");
    }
    
    public String goCreateVotingPlace() {
        return immediateRedirect("votingplacecreate");
    }

}
