package app.controller;

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
     * @param whoId       the whoId
     * @return the boolean
     */
    public boolean createVaccineType(String code, String designation, String whoId) {
        try{
            this.vt = new VaccineType(code, designation, whoId);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateVaccineType(vt);
    }

    /**
     * Validates vaccine type boolean.
     *
     * @param vt the vt
     * @return the boolean
     */
    public boolean validateVaccineType (VaccineType vt) {
        if (vt == null) return false;
        return !company.getVaccineTypeStore().getVaccineTypeList().contains(vt);
    }

    /**
     * Adds vaccine type.
     */
    public void addVaccineType() {
        this.company.addVaccineType(vt);
    }

    /**
     * Shows vaccine type object as a String.
     *
     * @return VaccineType as a String
     */
    public String showVaccineType() {
        return this.vt.toString();
    }
}
