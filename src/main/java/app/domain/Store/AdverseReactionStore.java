package app.domain.Store;

import app.DTO.AdverseReactionDTO;
import app.DTO.Mappers.AdverseReactionMapper;
import app.domain.model.AdverseReaction;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;

public class AdverseReactionStore {

    private List<AdverseReaction> arList;

    public AdverseReactionStore(){
        arList = new ArrayList<>();
    }

    public List<AdverseReaction> getArList() {
        return arList;
    }

    public void setArList(List<AdverseReaction> arList) {
        this.arList = arList;
    }

    public AdverseReactionDTO getARbySNSNumber(String SNSNumber){
        for (AdverseReaction ar: arList) {
            if(ar.getSnsu().getSNSNumber().equals(SNSNumber)) return AdverseReactionMapper.toDTO(ar);
        }
        throw new IllegalArgumentException("There is no recorded Adverse Reaction for such SNS User");
    }

    //create
    public AdverseReaction createAR(SNSUser snsu, String ARText, VaccinationCenter vc){
        return new AdverseReaction(snsu, ARText, vc);
    }
    public boolean validateAR( AdverseReaction ar){
        if (ar== null) return false;
        return !getArList().contains(ar);
    }
    //save
    public boolean addAR(AdverseReaction ar){
        if(validateAR(ar)){
            arList.add(ar);
            return true;
        }
        throw new IllegalArgumentException("Not saved since the adverse reaction was already registered.");
    }
}
