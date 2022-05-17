package app.domain.Store;

import app.domain.model.VaccinationCenter;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccination center store.
 *
 * @author Luís Monteiro - 1211250
 */
public class VaccinationCenterStore {
    /**
     * List that will store Vaccination Centers
     */

    private List<VaccinationCenter> vaccinationCenterList;

    /**
     * Declares the vaccinationCenterList as an ArrayList of type VaccinationCenter.
     */
    public VaccinationCenterStore(){
        this.vaccinationCenterList = new ArrayList<>();
    }

    /**
     * Is used for returning the List of Vaccination centers.
     *
     * @return the list of Vaccination centers
     */
    public List<VaccinationCenter> getVaccinationCenterList(){
        return vaccinationCenterList;
    }

    /**
     * Add vaccination center.
     *
     * @param vac the vac
     */
    public void addVaccinationCenter(VaccinationCenter vac){
        this.vaccinationCenterList.add(vac);
    }

    /**
     * Validates vaccination center boolean
     * @param vac
     * @return the boolean
     */
    public boolean validateVaccinationCenter (VaccinationCenter vac){
        if (vac == null) return false;
        return !getVaccinationCenterList().contains(vac);
    }
    /**
     * Creates Vaccination Center Object.
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
     */
    public VaccinationCenter createHealthcareCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator,String ages,String ars) {
        return new VaccinationCenter(address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines, coordinator, ages, ars);
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
     */
    public VaccinationCenter createCommunityCenter(String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, String openingHours, String closingHours, int slotDuration, int maxVaccines, String coordinator) {
        return new VaccinationCenter(address, emailAddress, phoneNumber, faxNumber, websiteAddress, openingHours, closingHours, slotDuration, maxVaccines, coordinator);
    }

    }
