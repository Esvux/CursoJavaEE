package com.academik.demojpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author esvux
 */
public class GeneralDAO<T> {

    @PersistenceContext(unitName = "academik-pu")
    private EntityManager em;
    
    public void create(T newItem) {
        em.persist(newItem);
    }
    
}
