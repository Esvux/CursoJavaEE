package com.academik.minitse.beans;

import com.academik.minitse.dao.DepartmentDAO;
import com.academik.minitse.dao.MunicipalityDAO;
import com.academik.minitse.model.Department;
import com.academik.minitse.model.Municipality;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "registerVotingPlaceBean" )
@SessionScoped
public class RegisterVotingPlaceBean implements Serializable {
    
    @Inject
    DepartmentDAO daoDept;

    @Inject
    MunicipalityDAO daoMun;
    
    private Department selectedDepartment;
    private Municipality selectedMunicipality;
    private List<Department> allDepartments;
    private List<Municipality> allMunicipalities;

    @PostConstruct
    public void init() {
        allDepartments = daoDept.findAll();
    }
    
    public Department getSelectedDepartment() {
        return selectedDepartment;
    }

    public void setSelectedDepartment(Department selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public Municipality getSelectedMunicipality() {
        return selectedMunicipality;
    }

    public void setSelectedMunicipality(Municipality selectedMunicipality) {
        this.selectedMunicipality = selectedMunicipality;
    }
    
    public List<Department> getAllDepartments() {
        return allDepartments;
    }
    
    public List<Municipality> getAllMunicipalities() {
        return allMunicipalities;
    }
    
    public final void changeDepartment(final AjaxBehaviorEvent event) {
        System.err.println("... cambiando...");
        allMunicipalities = daoMun.findByDepartment(selectedDepartment);
    }
    
    public String register() {
        return "votingplace_create";
    }
    
    
}
