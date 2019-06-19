package com.academik.demojpa.dao;

import com.academik.demojpa.model.Student;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "studentDao")
@RequestScoped
public class StudentDAO extends GeneralDAO<Student>{
    
}
