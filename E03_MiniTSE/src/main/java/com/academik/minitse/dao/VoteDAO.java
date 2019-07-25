package com.academik.minitse.dao;

import com.academik.minitse.model.Vote;
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
public class VoteDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;

    @Transactional
    public List<Vote> findAll() {
        //JPQL
        TypedQuery<Vote> query = em.createQuery(
                "SELECT issued FROM Vote issued", 
                Vote.class
        );
        return query.getResultList();
    }
    
    @Transactional
    public void submit(Vote vote) {
        em.persist(vote);
    }

}
