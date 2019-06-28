package com.academik.minitse.dao;

import com.academik.minitse.model.Department;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author esvux
 */
@RequestScoped
public class DepartmentDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;

    @Transactional
    public List<Department> findAll() {
        //JPQL
        TypedQuery<Department> query = em.createQuery(
                "SELECT d.id, d.name FROM Department d", 
                Department.class
        );
        List<Department> result = query.getResultList();
        return result;
    }

    
}
