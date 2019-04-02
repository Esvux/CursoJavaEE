package com.academik.agendaweb;

/**
 *
 * @author esvux
 */
public class Contacto {
    private String nickname;
    private String fullname;
    private String email;

    public Contacto(String nickname, String fullname, String email) {
        this.nickname = nickname;
        this.fullname = fullname;
        this.email = email;
    }

    public Contacto(String nickname) {
        this.nickname = nickname;
    }

    public Contacto() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
