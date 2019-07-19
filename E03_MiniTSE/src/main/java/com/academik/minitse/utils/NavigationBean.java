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
        return immediateRedirect("voting-places");
    }
    
    public String goCreateVotingPlace() {
        return immediateRedirect("voting-place-create");
    }

    public String goEditVotingPlace(Long id) {
        return immediateRedirect("voting-place-edit") + "&selected_id=" + id;
    }

    public String goVoters() {
        return immediateRedirect("voters");
    }

    public String goCreateVoters() {
        return immediateRedirect("voter-create");
    }
    
    public String goVoteSubmit() {
        return immediateRedirect("vote-submit");
    }
    
}
