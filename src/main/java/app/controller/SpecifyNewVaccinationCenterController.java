package app.controller;

import app.domain.model.Company;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccineType;

/**
 * The type Specify new vaccination center controller.
 *
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

    /**
     * Instantiates a new Specify new vaccination center controller.
     *
     * @param company the company
     */
    public SpecifyNewVaccinationCenterController(Company company) {
        this.company = company;
        this.vac = null;
    }

    /**
     * Creates and verifies Vaccination Center.
     *
     * @param address        VaccinationCenter's address
     * @param emailAddress   VaccinationCenter's email address
     * @param phoneNumber    VaccinationCenter's phone number
     * @param faxNumber      VaccinationCenter's fax number
     * @param websiteAddress VaccinationCenter's website adress
     * @param openingHours   VaccineCenter's opening hours
     * @param closingHours   VaccinationCenter's closing hours
     * @param slotDuration   VaccinationCenter's slot duration
     * @param maxVaccines    VaccinationCenter's max vaccines
     * @param coordinator    VaccinationCenter's coordinator
     * @param ages           the ages
     * @param ars            the ars
     * @return the boolean
     */
    public boolean createHealthcareCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator,String ages,String ars) {

        try{
            this.vac = new VaccinationCenter(address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines, coordinator,ages,ars);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateVaccinationCenter(vac);
    }

    /**
     * Create community center boolean.
     *
     * @param address        the address
     * @param emailAddress   the email address
     * @param phoneNumber    the phone number
     * @param faxNumber      the fax number
     * @param websiteAddress the website address
     * @param openingHours   the opening hours
     * @param closingHours   the closing hours
     * @param slotDuration   the slot duration
     * @param maxVaccines    the max vaccines
     * @param coordinator    the coordinator
     * @return the boolean
     */
    public boolean createCommunityCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator) {

        try {
            this.vac = new VaccinationCenter(address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines, coordinator);
        } catch (IllegalArgumentException e) {
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
    public boolean validateVaccinationCenter () {
        if (this.vac == null) return false;
        return !company.getVaccinationCenterStore().getVaccinationCenterList().contains(this.vac);
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
