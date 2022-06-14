package app.DTO;

import app.domain.model.SNSUser;

public class AdverseReactionDTO {

    private SNSUser snsu;
    private String ARText;

    public AdverseReactionDTO(SNSUser snsu, String ARText) {
        this.snsu = snsu;
        this.ARText = ARText;
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
    public String toString() {
        return
                "SNS User: " + snsu + "\n" +
                "Adverse Reaction: " + ARText + "\n"
                ;
    }
}
