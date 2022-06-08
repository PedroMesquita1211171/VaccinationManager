package app.domain.Store;

import app.domain.model.Employee;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.Tempo;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccination center store.
 */
public class VaccinationCenterStore {

    private List<VaccinationCenter> vaccinationCenters;

    /**
     * Instantiates a new Vaccination center store.
     */
    public VaccinationCenterStore() {
        this.vaccinationCenters = new ArrayList<>();
    }

    /**
     * Create vaccination center.
     *
     * @param name           the name
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
     * @param ages           the ages
     * @param ars            the ars
     * @param region         the region
     * @return the vaccination center
     */
    public VaccinationCenter createVaccinationCenter(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, Employee coordinator, String ages, String ars, String region) {
        //Healthcare Center
        return new VaccinationCenter(name,address,emailAddress,phoneNumber,faxNumber,websiteAddress,openingHours,closingHours,slotDuration,maxVaccines,coordinator,ages,ars,region);

    }

    /**
     * Create vaccination center vaccination center.
     *
     * @param name           the name
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
     * @return the vaccination center
     */
    public VaccinationCenter createVaccinationCenter(String name, String address, String emailAddress, String phoneNumber, String faxNumber, String websiteAddress, Tempo openingHours, Tempo closingHours, int slotDuration, int maxVaccines, Employee coordinator) {
        //Mass Community Center
        return new VaccinationCenter(name,address,emailAddress,phoneNumber,faxNumber,websiteAddress,openingHours,closingHours,slotDuration,maxVaccines,coordinator);
    }

    /**
     * Validate vaccination center boolean.
     *
     * @param vaccinationCenter the vaccination center
     * @return the boolean
     */
    public boolean validateVaccinationCenter(VaccinationCenter vaccinationCenter) {
        if(vaccinationCenter == null) return false;

        return !vaccinationCenters.contains(vaccinationCenter);
    }

    /**
     * Add vaccination center boolean.
     *
     * @param vaccinationCenter the vaccination center
     * @return the boolean
     */
    public boolean addVaccinationCenter(VaccinationCenter vaccinationCenter) {
        if(validateVaccinationCenter(vaccinationCenter)) {
            this.vaccinationCenters.add(vaccinationCenter);
            return true;
        }
        return false;
    }

    /**
     * Gets vaccination centers.
     *
     * @return the vaccination centers
     */
    public List<VaccinationCenter> getVaccinationCenters() {
        return vaccinationCenters;
    }
}
