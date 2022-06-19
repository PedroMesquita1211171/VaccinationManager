package app.domain.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Adverse reaction.
 */
public class AdverseReaction implements Serializable {

    private SNSUser snsu;
    private String ARText;
    private VaccinationCenter vc;

    /**
     * Instantiates a new Adverse reaction.
     *
     * @param snsu   the snsu
     * @param ARText the ar text
     * @param vc     the vc
     */
    public AdverseReaction(SNSUser snsu, String ARText,VaccinationCenter vc) {
        checkSNSUser(snsu);
        checkARText(ARText);
        checkVC(vc);
        if(ARText.length() == 0){
            this.ARText = "There was no Adverse Reaction for such SNS User.";
        }else{
            this.ARText = ARText;
        }
        this.snsu = snsu;
        this.vc = vc;
    }

    private void checkVC(VaccinationCenter vc) {
        if(vc == null){
            throw new IllegalArgumentException("Vaccination Center cannot be null.");
        }
    }

    private void checkARText(String arText) {
        if(arText.length() > 300) throw new IllegalArgumentException("Adverse Reaction Text can not be longer that 300 characters.");
    }

    private void checkSNSUser(SNSUser snsu) {
        if(snsu == null){
            throw new IllegalArgumentException("There is no SNS User with the given Number.");
        }
    }

    /**
     * Gets snsu.
     *
     * @return the snsu
     */
    public SNSUser getSnsu() {
        return snsu;
    }

    /**
     * Sets snsu.
     *
     * @param snsu the snsu
     */
    public void setSnsu(SNSUser snsu) {
        this.snsu = snsu;
    }

    /**
     * Gets ar text.
     *
     * @return the ar text
     */
    public String getARText() {
        return ARText;
    }

    /**
     * Sets ar text.
     *
     * @param ARText the ar text
     */
    public void setARText(String ARText) {
        this.ARText = ARText;
    }

    /**
     * Gets vc.
     *
     * @return the vc
     */
    public VaccinationCenter getVc() {
        return vc;
    }

    /**
     * Sets vc.
     *
     * @param vc the vc
     */
    public void setVc(VaccinationCenter vc) {
        this.vc = vc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdverseReaction)) return false;
        AdverseReaction that = (AdverseReaction) o;
        return Objects.equals(snsu, that.snsu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snsu, ARText);
    }
}
