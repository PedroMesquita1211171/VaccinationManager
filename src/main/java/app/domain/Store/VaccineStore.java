package app.domain.Store;

import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine store.
 */
public class VaccineStore {


    /**
     * The Vaccine list.
     */
    private List<Vaccine> VaccineList;

    /**
     * Instantiates a new Vaccine store.
     */
    public VaccineStore() {
        VaccineList = new ArrayList<>();
    }

    /**
     * Create vaccine vaccine.
     *
     * @param brand     the brand
     * @param lotNumber the lot number
     * @param ap        the ap
     * @param vt        the vt
     * @return the vaccine
     */
    public Vaccine createVaccine(String brand, String lotNumber, List<AdministrationProcess> ap, VaccineType vt) {
        return new Vaccine(brand,lotNumber,ap,vt);
    }

    /**
     * Add vaccine boolean.
     *
     * @param vac the vac
     * @return the boolean
     */
    public boolean addVaccine(Vaccine vac){
        if(validateVaccine(vac)){
            VaccineList.add(vac);
            return true;
        }
        return false;
    }

    /**
     * Validate vaccine boolean.
     *
     * @param vac the vac
     * @return the boolean
     */
    public boolean validateVaccine(Vaccine vac){
        if(vac == null) return false;
        return !VaccineList.contains(vac);
    }

    /**
     * Get vaccine list.
     *
     * @return the list
     */
    public List<Vaccine> getVaccineList(){
        return VaccineList;
    }

}
