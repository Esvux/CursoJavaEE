package com.academik.mvc.dao;

import com.academik.mvc.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de todas las operaciones de base de datos
 * referentes a la clase Student.
 * @author esvux
 */
public class StudentDAO implements GeneralDAO<Student> {

    @Override
    public List<Student> queryAll() {
        List<Student> temp = new ArrayList<>();
        try {
            Connection conn = CONN_WRAPPER.getConnection();
            PreparedStatement stmn = conn.prepareStatement("SELECT code, first_name, last_name, gender, email, contact_phone, guardian, birthday FROM student");
            ResultSet result = stmn.executeQuery();
            while(result.next()) {
                Student s = new Student();
                s.setCode(result.getLong("code"));
                s.setFirstName(result.getString("first_name"));
                s.setLastName(result.getString("last_name"));
                s.setEmail(result.getString("email"));
                s.setGuardian(result.getString("guardian"));
                s.setContactPhone(result.getString("contact_phone"));
                temp.add(s);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return temp;
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
