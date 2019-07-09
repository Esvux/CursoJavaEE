package com.academik.minitse.beans;

import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.model.Voter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "voterListBean")
@RequestScoped
public class VoterListBean {
    
    @Inject
    VoterDAO dao;
    
    List<Voter> voters;

    public List<Voter> getVoters() {
        voters = dao.findAll();
        return voters;
    }

    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }
    
}
