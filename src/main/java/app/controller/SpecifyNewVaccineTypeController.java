package app.controller;

import app.DTO.Mappers.VaccineTypeMapper;
import app.DTO.VaccineTypeDTO;
import app.domain.model.VaccineType;
import app.domain.model.Company;
import app.domain.shared.CommonMethods;

/**
 * The type Specify new vaccine type controller.
 *
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

    /**
     * Instantiates a new Specify new vaccine type controller.
     *
     * @param company the company
     */
    public SpecifyNewVaccineTypeController(Company company) {
        this.company = company;
        this.vt = null;
    }

    /**
     * Creates and verifies vaccine type.
     *
     * @param code              the code
     * @param designation       the designation
     * @param vaccineTechnology the vaccineTechnology
     * @return the boolean
     */
    public boolean createVaccineType(String code, String designation, String vaccineTechnology) {

        this.vt = this.company.getVaccineTypeStore().createVaccineType(code, designation, vaccineTechnology);

        return this.company.getVaccineTypeStore().validateVaccineType(vt);

    }

    /**
     * Adds vaccine type.
     *
     * @return the boolean
     */
    public boolean saveVaccineType() {
        boolean a = this.company.getVaccineTypeStore().addVaccineType(this.vt);
        CommonMethods.serializeStore(this.company.getVaccineTypeStore().getVaccineTypeList(),"data\\vaccineType.dat");
        return a;
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
