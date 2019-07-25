package com.academik.minitse.dao;

import com.academik.minitse.model.VotingTable;
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
public class VotingTableDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;

    @Transactional
    public VotingTable findByVoter(String dpi) {
        TypedQuery<VotingTable> query = em.createQuery(
                "SELECT v.table FROM Voter v WHERE v.dpi = :dpi", VotingTable.class
        );
        query.setParameter("dpi", dpi);
        return query.getSingleResult();
    }
    
    @Transactional
    public void update(VotingTable t) {
        em.merge(t);
    }

}
