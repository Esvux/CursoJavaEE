package com.academik.minitse.dao;

import com.academik.minitse.model.Department;
import com.academik.minitse.model.Municipality;
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
public class MunicipalityDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;

    @Transactional
    public List<Municipality> findByDepartment(Department dept) {
        //JPQL
        TypedQuery<Municipality> query = em.createQuery(
                "SELECT m.id, m.name FROM Municipality m WHERE m.department = :depto", 
                Municipality.class
        );
        query.setParameter("depto", dept);
        List<Municipality> result = query.getResultList();
        return result;
    }

    @Transactional
    public List<Municipality> findAll() {
        //JPQL
        TypedQuery<Municipality> query = em.createQuery(
                "SELECT m FROM Municipality m", 
                Municipality.class
        );
        List<Municipality> result = query.getResultList();
        return result;
    }

    
}
