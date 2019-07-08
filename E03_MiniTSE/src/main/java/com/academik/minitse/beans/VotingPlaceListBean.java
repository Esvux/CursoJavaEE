package com.academik.minitse.beans;

import com.academik.minitse.dao.VotingPlaceDAO;
import com.academik.minitse.model.VotingPlace;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "votingPlaceListBean")
@ViewScoped
public class VotingPlaceListBean implements Serializable {
    
    @Inject
    VotingPlaceDAO daoVotingPlace;
    
    private List<VotingPlace> allCenters;

    @PostConstruct
    public void init() {
        allCenters = daoVotingPlace.findAll();
    }
    
    public List<VotingPlace> getAllCenters() {
        return allCenters;
    }
    
    public void delete(Long id) {
        daoVotingPlace.delete(id);
        allCenters = daoVotingPlace.findAll();
    }

}
