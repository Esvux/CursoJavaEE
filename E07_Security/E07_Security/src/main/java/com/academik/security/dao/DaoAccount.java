package com.academik.security.dao;

import com.academik.security.models.Account;
import com.academik.security.models.AccountRole;
import com.academik.security.models.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author esvux
 */
@RequestScoped
public class DaoAccount {
    
    @PersistenceContext
    EntityManager em;
    

    
    @Transactional
    public void createNormalAccount(Account account) {
        
        em.persist(account);
    }
    
}
