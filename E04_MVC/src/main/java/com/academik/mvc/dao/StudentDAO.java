package com.academik.mvc.dao;

import com.academik.mvc.model.Student;
import java.util.List;

/**
 * Clase encargada de todas las operaciones de base de datos
 * referentes a la clase Student.
 * @author esvux
 */
public class StudentDAO implements GeneralDAO<Student> {

    @Override
    public List<Student> queryAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Student element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(long id, Student element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
