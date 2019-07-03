package com.academik.minitse.beans;

import com.academik.minitse.dao.DepartmentDAO;
import com.academik.minitse.dao.MunicipalityDAO;
import com.academik.minitse.model.Department;
import com.academik.minitse.model.Municipality;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "registerVotingPlaceBean" )
@ViewScoped
public class RegisterVotingPlaceBean implements Serializable {
    
    @Inject
    DepartmentDAO daoDept;

    @Inject
    MunicipalityDAO daoMun;
    
    private Long selectedDepartmentId;
    private Long selectedMunicipalityId;
    private List<Department> allDepartments;
    private List<Municipality> allMunicipalities;

    @PostConstruct
    public void init() {
        allDepartments = daoDept.findAll();
    }
    
    public Long getSelectedDepartmentId() {
        return selectedDepartmentId;
    }

    public void setSelectedDepartmentId(Long selectedDepartmentId) {
        this.selectedDepartmentId = selectedDepartmentId;
    }

    public Long getSelectedMunicipalityId() {
        return selectedMunicipalityId;
    }

    public void setSelectedMunicipality(Long selectedMunicipalityId) {
        this.selectedMunicipalityId = selectedMunicipalityId;
    }
    
    public List<Department> getAllDepartments() {
        return allDepartments;
    }
    
    public List<Municipality> getAllMunicipalities() {
        return allMunicipalities;
    }
    
    public final void changeDepartment(final AjaxBehaviorEvent event) {
        if(selectedDepartmentId == null) {
            selectedMunicipalityId = null;
            allMunicipalities = Collections.EMPTY_LIST;
            return;
        }
        Department dept = new Department();
        dept.setId(selectedDepartmentId);
        allMunicipalities = daoMun.findByDepartment(dept);
    }
    
    public String register() {
        return "votingplacecreate";
    }
    
    
}
