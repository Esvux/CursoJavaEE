package com.academik.security.dao;

import com.academik.security.models.Role;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author esvux
 */
@RequestScoped
public class DaoRole {
    
    @PersistenceContext
    EntityManager em;
    
    public Role getNormalRole() {
        return em.find(Role.class, 2L);
    }

    public Role getAdminRole() {
        return em.find(Role.class, 1L);
    }
    
}
