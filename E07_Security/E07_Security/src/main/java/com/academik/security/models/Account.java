package com.academik.security.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_account", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account")
    private Long id; //id SERIAL PRIMARY KEY,

    @Column
    private String email; //VARCHAR(40) NOT NULL,

    @Column(name = "username", nullable = false)
    private String nickname; //VARCHAR(15) NOT NULL,

    @Column(nullable = false)
    private String password; //VARCHAR(255) NOT NULL,
    
    @Column
    private String firstName; //VARCHAR(100),
    
    @Column
    private String lastName; //VARCHAR(100),
    
    @Column
    private Boolean active; //BOOLEAN,
    
    @Column
    private Timestamp created; //TIMESTAMP,
    
    @Column
    private Timestamp updated; //TIMESTAMP

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "account")
    private List<AccountRole> accountRoles;
    
    public Account() {
        active = Boolean.TRUE;
        created = Timestamp.from(Instant.now());
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public List<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(List<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }
    
}
