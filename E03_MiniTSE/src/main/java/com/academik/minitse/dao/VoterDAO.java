package com.academik.minitse.dao;

import com.academik.minitse.model.Voter;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author esvux
 */
@RequestScoped
public class VoterDAO {
    
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    @Transactional
    public void register(Voter newVoter){
        em.persist(newVoter);
    }
    
}
