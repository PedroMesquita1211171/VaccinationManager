package app.controller;

import app.DTO.AdverseReactionDTO;
import app.DTO.Mappers.AdverseReactionMapper;
import app.domain.model.AdverseReaction;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

/**
 * The type Record adverse reaction controller.
 */
public class RecordAdverseReactionController {

    private Company company;
    private SNSUser snsu;
    private VaccinationCenter vc;
    private AdverseReaction ar;

    /**
     * Instantiates a new Record adverse reaction controller.
     */
    public RecordAdverseReactionController() {
         this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Record adverse reaction controller.
     *
     * @param company the company
     */
    public RecordAdverseReactionController(Company company) {
        this.company = company;
        this.snsu = null;
        this.vc = null;
    }

    /**
     * Create adverse reaction boolean.
     *
     * @param snsuserNumber the snsuser number
     * @param ARText        the ar text
     * @return the boolean
     */
    public boolean createAdverseReaction(String snsuserNumber, String ARText) {
        this.snsu = this.company.getWaitingRoomStore().getSNSUserInTheWaitingRoomByItsSNSNumber(snsuserNumber);
        this.vc = this.company.getWaitingRoomStore().getVaccinationCenterBySNSNumber(snsuserNumber);
        this.ar = this.company.getAdverseReactionStore().createAR(this.snsu, ARText, this.vc);

        return this.company.getAdverseReactionStore().validateAR(this.ar);
    }

    /**
     * Save adverse reaction boolean.
     *
     * @return the boolean
     */
    public boolean saveAdverseReaction() {
        return this.company.getAdverseReactionStore().addAR(this.ar);
    }

    /**
     * Gets adverse reaction.
     *
     * @return the adverse reaction
     */
    public AdverseReactionDTO getAdverseReaction() {
        return AdverseReactionMapper.toDTO(this.ar);
    }

}
