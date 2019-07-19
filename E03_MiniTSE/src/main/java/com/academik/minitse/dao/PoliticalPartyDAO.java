package com.academik.minitse.dao;

import com.academik.minitse.model.PoliticalParty;
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
public class PoliticalPartyDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;

    @Transactional
    public List<PoliticalParty> findAll() {
        //JPQL
        TypedQuery<PoliticalParty> query = em.createQuery(
                "SELECT pp FROM PoliticalParty pp", 
                PoliticalParty.class
        );
        List<PoliticalParty> result = query.getResultList();
        return result;
    }
    
}
