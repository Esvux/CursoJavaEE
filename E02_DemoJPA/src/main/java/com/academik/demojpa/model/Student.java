package com.academik.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "student")
public class Student {
    
    @Id
    @GeneratedValue
    private long code;
    
    @Column(name="first_name", nullable=false, length=50)
    private String firstName;
    
    @Column(name="last_name", nullable=false, length=50)
    private String lastName;
    
    @Column
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    
    
}
