package app.controller;

import app.DTO.AdverseReactionDTO;
import app.DTO.Mappers.AdverseReactionMapper;
import app.domain.model.AdverseReaction;
import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;

public class RecordAdverseReactionController {

    private Company company;
    private SNSUser snsu;
    private VaccinationCenter vc;
    private AdverseReaction ar;

    public RecordAdverseReactionController() {
         this(App.getInstance().getCompany());
    }

    public RecordAdverseReactionController(Company company) {
        this.company = company;
        this.snsu = null;
        this.vc = null;
    }

    public boolean createAdverseReaction(String snsuserNumber, String ARText) {
        this.snsu = this.company.getWaitingRoomStore().getSNSUserInTheWaitingRoomByItsSNSNumber(snsuserNumber);
        this.vc = this.company.getWaitingRoomStore().getVaccinationCenterBySNSNumber(snsuserNumber);
        this.ar = this.company.getAdverseReactionStore().createAR(this.snsu, ARText, this.vc);

        return this.company.getAdverseReactionStore().validateAR(this.ar);
    }

    public boolean saveAdverseReaction() {
        return this.company.getAdverseReactionStore().addAR(this.ar);
    }

    public AdverseReactionDTO getAdverseReaction() {
        return AdverseReactionMapper.toDTO(this.ar);
    }

}
