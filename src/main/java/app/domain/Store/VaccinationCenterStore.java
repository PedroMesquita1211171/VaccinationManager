package app.domain.Store;

import app.domain.model.VaccinationCenter;


import java.util.ArrayList;
import java.util.List;
/**
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
        vaccinationCenterList = new ArrayList<>();
    }

    /**
     * Is used for returning the List of Vaccination centers.
     *
     * @return the list of Vaccination centers
     */
    public List<VaccinationCenter> getVaccinationCenterList(){
        return vaccinationCenterList;
    }

    public void addVaccinationCenter(VaccinationCenter vac){
        this.vaccinationCenterList.add(vac);
    }

}
