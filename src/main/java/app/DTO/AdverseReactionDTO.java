package app.DTO;

import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

public class AdverseReactionDTO {

    private SNSUser snsu;
    private String ARText;
    private VaccinationCenter vc;

    public AdverseReactionDTO(SNSUser snsu, String ARText,VaccinationCenter vc) {
        this.snsu = snsu;
        this.ARText = ARText;
        this.vc = vc;
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
    public String toString() {
        return
                "SNS User: " + snsu + "\n" +
                "Adverse Reaction: " + ARText + "\n"
                ;
    }
}
