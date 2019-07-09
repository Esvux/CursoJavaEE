package com.academik.minitse.beans;

import com.academik.minitse.dao.VotingPlaceDAO;
import com.academik.minitse.model.VotingPlace;
import com.academik.minitse.utils.NabJSFUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "votingPlaceEditBean")
@ViewScoped
public class VotingPlaceEditBean implements Serializable {

    @Inject
    VotingPlaceDAO daoVotingPlace;

    private VotingPlace place;
    private String tempName;
    private String tempAddress;
    private String tempExtraAddress;

    @PostConstruct
    public void init() {
        String idAsString = NabJSFUtil.getParameter("selected_id");
        if(idAsString == null) {
            try {
                NabJSFUtil.redirectTo("voting-places.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        Long id = Long.parseLong(idAsString);
        place = daoVotingPlace.findById(id);
        tempName = place.getName();
        tempAddress = place.getAddress();
        tempExtraAddress = place.getExtraAddress();
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    public String getTempExtraAddress() {
        return tempExtraAddress;
    }

    public void setTempExtraAddress(String tempExtraAddress) {
        this.tempExtraAddress = tempExtraAddress;
    }

    public void saveChanges() {
        place.setName(tempName);
        place.setAddress(tempAddress);
        place.setExtraAddress(tempExtraAddress);
        place = daoVotingPlace.update(place);
    }

}
