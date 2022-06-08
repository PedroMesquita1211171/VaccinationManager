package app.controller;

import app.DTO.Mappers.VaccineTypeMapper;
import app.DTO.VaccineTypeDTO;
import app.domain.model.VaccineType;
import app.domain.model.Company;

/**
 * @author Henrique Pinto - 1211201
 */
public class SpecifyNewVaccineTypeController {


    /**
     *
     * Company and VaccineType to add.
     */
    private Company company;
    private VaccineType vt;

    /**
     * Constructors.
     */
    public SpecifyNewVaccineTypeController () {
        this(App.getInstance().getCompany());
    }

    public SpecifyNewVaccineTypeController(Company company) {
        this.company = company;
        this.vt = null;
    }

    /**
     * Creates and verifies vaccine type.
     *
     * @param code        the code
     * @param designation the designation
     * @param vaccineTechnology       the vaccineTechnology
     * @return the boolean
     */
    public boolean createVaccineType(String code, String designation, String vaccineTechnology) {

        this.vt = this.company.getVaccineTypeStore().createVaccineType(code, designation, vaccineTechnology);

        return this.company.getVaccineTypeStore().validateVaccineType(vt);

    }

    /**
     * Adds vaccine type.
     */
    public boolean saveVaccineType() {
        return this.company.getVaccineTypeStore().addVaccineType(vt);
    }

    /**
     * Shows vaccine type object as a DTO.
     *
     * @return VaccineType in a DTO Format
     */
    public VaccineTypeDTO showVaccineType() {
        return VaccineTypeMapper.toDTO(this.vt);
    }
}
