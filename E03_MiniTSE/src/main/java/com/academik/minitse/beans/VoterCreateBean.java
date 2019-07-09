package com.academik.minitse.beans;

import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.model.Voter;
import com.academik.minitse.utils.DateUtils;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "voterCreateBean")
@RequestScoped
public class VoterCreateBean {
    
    @Inject
    VoterDAO dao;
    
    private String tempDpi;
    private String tempFirstName;
    private String tempLastName;
    private Date tempBirthday;
    private String tempGender;
    private String tempAddress;
    private String tempExtraAddress;

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

    public Date getTempBirthday() {
        return tempBirthday;
    }

    public void setTempBirthday(Date tempBirthday) {
        this.tempBirthday = tempBirthday;
    }

    public String getTempGender() {
        return tempGender;
    }

    public void setTempGender(String tempGender) {
        this.tempGender = tempGender;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    public String getTempExtraAddress() {
        return tempExtraAddress;
    }

    public void setTempExtraAddress(String tempExtraAddress) {
        this.tempExtraAddress = tempExtraAddress;
    }
    
    public String register(){
        Voter v = new Voter();
        v.setDpi(tempDpi);
        v.setFirstName(tempFirstName);
        v.setLastName(tempLastName);
        v.setGender(tempGender);
        v.setBirthday(DateUtils.truncateDate(tempBirthday));
        v.setAddress(tempAddress);
        v.setExtraAddress(tempExtraAddress);
        dao.register(v);
        return "voters";
    }

}
