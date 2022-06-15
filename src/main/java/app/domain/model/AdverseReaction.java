package app.domain.model;

import java.util.Objects;

public class AdverseReaction {

    private SNSUser snsu;
    private String ARText;
    private VaccinationCenter vc;

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

    public SNSUser getSnsu() {
        return snsu;
    }

    public void setSnsu(SNSUser snsu) {
        this.snsu = snsu;
    }

    public String getARText() {
        return ARText;
    }

    public void setARText(String ARText) {
        this.ARText = ARText;
    }

    public VaccinationCenter getVc() {
        return vc;
    }

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
