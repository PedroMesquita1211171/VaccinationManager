package app.domain.model;

import java.util.Objects;

public class AdverseReaction {

    private SNSUser snsu;
    private String ARText;

    public AdverseReaction(SNSUser snsu, String ARText){
        checkSNSUser(snsu);
        checkARText(ARText);
        if(ARText.length() == 0){
            this.ARText = "There was no Adverse Reaction for such SNS User.";
        }else{
            this.ARText = ARText;
        }
        this.snsu = snsu;
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
