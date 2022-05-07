package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccineType;
/**
 * @author Luís Monteiro - 1211250
 */
public class SpecifyNewVaccinationCenterController {


    /**
     *
     * Company and VaccinationCenter to add.
     */
    private Company company;
    private VaccinationCenter vac;

    /**
     * Constructors.
     */
    public SpecifyNewVaccinationCenterController () {
        this(App.getInstance().getCompany());
    }

    public SpecifyNewVaccinationCenterController(Company company) {
        this.company = company;
        this.vac = null;
    }

    /**
     * Creates and verifies Vaccination Center.
     *
     * @param emailAddress   VaccinationCenter's email address
     * @param address        VaccinationCenter's address
     * @param phoneNumber    VaccinationCenter's phone number
     * @param faxNumber      VaccinationCenter's fax number
     * @param websiteAddress VaccinationCenter's website adress
     * @param openingHours   VaccineCenter's opening hours
     * @param closingHours   VaccinationCenter's closing hours
     * @param slotDuration   VaccinationCenter's slot duration
     * @param maxVaccines    VaccinationCenter's max vaccines
     * @param coordinator    VaccinationCenter's coordinator
     * @return the boolean
     */
    public boolean createVaccination(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator,String ages,String ars) {

        try{
            this.vac = new VaccinationCenter(address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines, coordinator,ages,ars);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateVaccinationCenter(vac);
    }

    /**
     * Validates vaccination center boolean.
     *
     * @param vac the vac
     * @return the boolean
     */
    public boolean validateVaccinationCenter (VaccinationCenter vac) {
        if (vac == null) return false;
        return company.getVaccinationCenterStore().getVaccinationCenterList().contains(vac);
    }

    /**
     * Adds vaccination center.
     */
    public void addVaccinationCenter() {
        this.company.addVaccinationCenter(vac);
    }

    /**
     * Shows vaccination center object as a String.
     *
     * @return VaccinationCenter as a String
     */
    public String showVaccinationCenter() {
        return this.vac.toString();
    }
}
