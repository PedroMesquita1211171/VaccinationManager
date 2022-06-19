package app.DTO;

import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

/**
 * The type Adverse reaction dto.
 */
public class AdverseReactionDTO {

    private SNSUser snsu;
    private String ARText;
    private VaccinationCenter vc;

    /**
     * Instantiates a new Adverse reaction dto.
     *
     * @param snsu   the snsu
     * @param ARText the ar text
     * @param vc     the vc
     */
    public AdverseReactionDTO(SNSUser snsu, String ARText,VaccinationCenter vc) {
        this.snsu = snsu;
        this.ARText = ARText;
        this.vc = vc;
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
    public String toString() {
        return
                "SNS User: " + snsu.getName() + "/" + snsu.getSNSNumber() + "\n" +
                "Adverse Reaction: " + ARText + "\n"
                ;
    }
}
