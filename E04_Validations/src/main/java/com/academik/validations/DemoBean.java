package com.academik.validations;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
@RequestScoped
public class DemoBean {

    @Pattern(regexp = "\\p{Alpha}{5,}")
    private String nickname;
    
    @Pattern(regexp = "\\p{Alnum}{3,}@\\p{Alnum}{2,}\\.\\p{Alnum}{2,3}")
    private String email;
    
    @Size(min = 8, max = 25)
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}





