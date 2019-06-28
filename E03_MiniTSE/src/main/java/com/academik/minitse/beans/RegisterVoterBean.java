package com.academik.minitse.beans;

import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.model.Voter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "registerVoterBean")
@RequestScoped
public class RegisterVoterBean {
    
    @Inject
    VoterDAO dao;
    
    private String tempDpi;
    private String tempFirstName;
    private String tempLastName;
    private Double tempHeight;

    public String getTempDpi() {
        return tempDpi;
    }

    public void setTempDpi(String tempDpi) {
        this.tempDpi = tempDpi;
    }

    public String getTempFirstName() {
        return tempFirstName;
    }

    public void setTempFirstName(String tempFirstName) {
        this.tempFirstName = tempFirstName;
    }

    public String getTempLastName() {
        return tempLastName;
    }

    public void setTempLastName(String tempLastName) {
        this.tempLastName = tempLastName;
    }

    public Double getTempHeight() {
        return tempHeight;
    }

    public void setTempHeight(Double tempHeight) {
        this.tempHeight = tempHeight;
    }
    
    public String register(){
        Voter v = new Voter();
        v.setDpi(tempDpi);
        v.setFirstName(tempFirstName);
        v.setLastName(tempLastName);
        dao.register(v);
        return "voters";
    }
    
}
