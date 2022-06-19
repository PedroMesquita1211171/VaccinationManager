package app.controller;

import app.DTO.Mappers.VaccinationMapper;
import app.DTO.Mappers.VaccineMapper;
import app.DTO.VaccinationDTO;
import app.DTO.VaccineDTO;
import app.domain.model.AdverseReaction;
import app.domain.model.Company;
import app.domain.model.Vaccination;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.util.List;

/**
 * The type Record vaccination controller.
 */
public class RecordVaccinationController {

    private Company company;
    private Vaccination vaccination;

    /**
     * Create vaccination boolean.
     *
     * @param SNSNumber  the sns number
     * @param vacDTO     the vac dto
     * @param doseNumber the dose number
     * @return the boolean
     */
    public boolean createVaccination(String SNSNumber, VaccineDTO vacDTO, int doseNumber){
        AdverseReaction ar = this.company.getAdverseReactionStore().getARbySNSNumber(SNSNumber);
        AdministrationProcess ap = vacDTO.getAdministrationProcess(ar.getSnsu().getAge());
        Vaccine vac = VaccineMapper.toDomain(vacDTO);

        this.vaccination = this.company.getVaccinationStore().createVaccination(ar, vac, doseNumber, ap);


        return this.company.getVaccinationStore().validateVaccination(this.vaccination);
    }

    /**
     * Save vaccination boolean.
     *
     * @return the boolean
     */
    public boolean saveVaccination(){
        return this.company.getVaccinationStore().addVaccination(this.vaccination);
    }

    /**
     * Get vaccines list.
     *
     * @return the list
     */
    public List<VaccineDTO> getVaccines(){
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }

    /**
     * Get vaccination vaccination dto.
     *
     * @return the vaccination dto
     */
    public VaccinationDTO getVaccination(){
        return VaccinationMapper.toDTO(this.vaccination);
    }
}
