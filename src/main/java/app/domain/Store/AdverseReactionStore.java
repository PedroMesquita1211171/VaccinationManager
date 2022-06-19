package app.domain.Store;

import app.DTO.AdverseReactionDTO;
import app.DTO.Mappers.AdverseReactionMapper;
import app.domain.model.AdverseReaction;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Adverse reaction store.
 */
public class AdverseReactionStore {

    private List<AdverseReaction> arList;

    /**
     * Instantiates a new Adverse reaction store.
     */
    public AdverseReactionStore(){
        arList = new ArrayList<>();
    }

    /**
     * Gets ar list.
     *
     * @return the ar list
     */
    public List<AdverseReaction> getArList() {
        return arList;
    }

    /**
     * Sets ar list.
     *
     * @param arList the ar list
     */
    public void setArList(List<AdverseReaction> arList) {
        this.arList = arList;
    }

    /**
     * Get a rby sns number adverse reaction.
     *
     * @param SNSNumber the sns number
     * @return the adverse reaction
     */
    public AdverseReaction getARbySNSNumber(String SNSNumber){
        for (AdverseReaction ar: arList) {
            if(ar.getSnsu().getSNSNumber().equals(SNSNumber)) return ar;
        }
        throw new IllegalArgumentException("There is no recorded Adverse Reaction for such SNS User");
    }

    /**
     * Create ar adverse reaction.
     *
     * @param snsu   the snsu
     * @param ARText the ar text
     * @param vc     the vc
     * @return the adverse reaction
     */
//create
    public AdverseReaction createAR(SNSUser snsu, String ARText, VaccinationCenter vc){
        return new AdverseReaction(snsu, ARText, vc);
    }

    /**
     * Validate ar boolean.
     *
     * @param ar the ar
     * @return the boolean
     */
    public boolean validateAR( AdverseReaction ar){
        if (ar== null) return false;
        return !getArList().contains(ar);
    }

    /**
     * Add ar boolean.
     *
     * @param ar the ar
     * @return the boolean
     */
//save
    public boolean addAR(AdverseReaction ar){
        if(validateAR(ar)){
            arList.add(ar);
            return true;
        }
        throw new IllegalArgumentException("Not saved since the adverse reaction was already registered.");
    }

    public void setStore(List<AdverseReaction> readObject) {
        for (AdverseReaction ar : readObject) {
            arList.add(ar);
        }
    }
}
