package com.academik.demojsf;

import com.academik.demojsf.model.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Funcionalidad de la pagina XHTML.
 * @author esvux
 */
@ManagedBean(name = "studentBean")
//@ApplicationScoped // Mismo objeto para todas las peticiones
//@SessionScoped // Un solo objeto por conexion/por usuario
//@RequestScoped // Tiempo de vida igual al tiempo de una peticion 
@ApplicationScoped
public class StudentBean implements Serializable {
    //Propiedades para crear un nuevo estudiante
    private String tempFirstName;
    private String tempLastName;
    
    //Lista de todos los estudiantes en el sistema
    private List<Student> students;

    public StudentBean() {
        students = new ArrayList<>();
        students.add(new Student("Emerson", "De Leon"));
        students.add(new Student("Fernando", "Perez"));
        students.add(new Student("Oscar", "Paiz"));
        students.add(new Student("Heros", "Noriega"));
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public void addStudent() {
        Student noob = new Student();
        noob.setFirstName(tempFirstName);
        noob.setLastName(tempLastName);
        students.add(noob);
        tempFirstName = "";
        tempLastName = "";
    }
    
}
