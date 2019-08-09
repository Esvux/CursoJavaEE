package com.academik.security.beans;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author esvux
 */
@ManagedBean
public class RegisterAdminBean {
    
    private String tempEmail;
    private String tempNickname;
    private String tempPassword;
    private String tempFirstName;
    private String tempLastName;

    public String getTempEmail() {
        return tempEmail;
    }

    public void setTempEmail(String tempEmail) {
        this.tempEmail = tempEmail;
    }

    public String getTempNickname() {
        return tempNickname;
    }

    public void setTempNickname(String tempNickname) {
        this.tempNickname = tempNickname;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
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
    
}
