package com.academik.minitse.dao;

import com.academik.minitse.model.VotingPlace;
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
public class VotingPlaceDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;

    @Transactional
    public void create(VotingPlace place) {
        em.persist(place);
    }
        
    public List<VotingPlace> findAll() {
        TypedQuery<VotingPlace> query = em.createQuery("SELECT vp FROM VotingPlace vp", VotingPlace.class);
        return query.getResultList();
    }
    
}
