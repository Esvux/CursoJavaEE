package com.academik.dao;

import com.academik.rest.model.Graduacion;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO para la entidad Graduacion.
 * @author esvux
 */
@RequestScoped
public class GraduacionDAO {
    
    @PersistenceContext
    EntityManager em;

    public List<Graduacion> findAll() {
        TypedQuery<Graduacion> query = em.createQuery(
                "SELECT g FROM Graduacion g", Graduacion.class
        );
        return query.getResultList();
    }
    
    public Graduacion findById(Long correlativo) {
        return em.find(Graduacion.class, correlativo);
    }

}
