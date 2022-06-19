package app.controller;

import app.DTO.Mappers.VaccineMapper;
import app.DTO.Mappers.VaccineTypeMapper;
import app.DTO.VaccineDTO;
import app.DTO.VaccineTypeDTO;
import app.domain.model.Company;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineDependencies.AgeGroup;
import app.domain.model.VaccineType;
import app.domain.shared.CommonMethods;

import java.util.List;

/**
 * The type Specify new vaccine controller.
 */
public class SpecifyNewVaccineController {

    private Company company;
    private VaccineType vt;
    private Vaccine vac;


    /**
     * Instantiates a new Specify new vaccine controller.
     *
     * @param company the company
     */
    public SpecifyNewVaccineController(Company company) {
        this.company = company;
    }

    /**
     * Instantiates a new Specify new vaccine controller.
     */
    public SpecifyNewVaccineController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Create vaccine boolean.
     *
     * @param vaccineTypeDTO the vaccine type dto
     * @param brand          the brand
     * @param lotNumber      the lot number
     * @param admList        the adm list
     * @return the boolean
     */
    public boolean createVaccine(VaccineTypeDTO vaccineTypeDTO, String brand, String lotNumber,List<AdministrationProcess> admList){

        vt = VaccineTypeMapper.toEntity(vaccineTypeDTO);
        this.vac = this.company.getVaccineStore().createVaccine(brand,lotNumber,admList,vt);

        return this.company.getVaccineStore().validateVaccine(this.vac);
    }

    /**
     * Save vaccine boolean.
     *
     * @return the boolean
     */
    public boolean saveVaccine(){
        boolean a = this.company.getVaccineStore().addVaccine(this.vac);
        CommonMethods.serializeStore(this.company.getVaccineStore().getVaccineList(), "data\\vaccines.dat");
        return a;
    }

    /**
     * Get vaccine types list.
     *
     * @return the list
     */
    public List<VaccineTypeDTO> getVaccineTypes(){
        return VaccineTypeMapper.toDTOList(this.company.getVaccineTypeStore().getVaccineTypeList());
    }

    /**
     * Get vaccine vaccine dto.
     *
     * @return the vaccine dto
     */
    public VaccineDTO getVaccine(){
        return VaccineMapper.toDTO(this.vac);
    }


}
