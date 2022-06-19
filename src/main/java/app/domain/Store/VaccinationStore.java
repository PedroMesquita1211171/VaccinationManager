package app.domain.Store;

import app.domain.model.AdverseReaction;
import app.domain.model.Vaccination;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccination store.
 */
public class VaccinationStore {

    /**
     * The Vaccinations.
     */
    List<Vaccination> vaccinations;

    /**
     * Instantiates a new Vaccination store.
     */
    public VaccinationStore(){
        this.vaccinations = new ArrayList<>();
    }


    /**
     * Create vaccination vaccination.
     *
     * @param ar   the ar
     * @param v    the v
     * @param dose the dose
     * @param ap   the ap
     * @return the vaccination
     */
    public Vaccination createVaccination(AdverseReaction ar, Vaccine v, int dose, AdministrationProcess ap){
        return new Vaccination(ar, v, dose, ap);
    }

    /**
     * Validate vaccination boolean.
     *
     * @param v the v
     * @return the boolean
     */
    public boolean validateVaccination(Vaccination v){
        if(vaccinations.contains(v))
            return false;
        return true;
    }

    /**
     * Add vaccination boolean.
     *
     * @param v the v
     * @return the boolean
     */
    public boolean addVaccination(Vaccination v){
        if(validateVaccination(v)){
            vaccinations.add(v);
            return true;
        }
        throw new IllegalArgumentException("Vaccination already Registered");
    }

    /**
     * Get vaccinations list.
     *
     * @return the list
     */
    public List<Vaccination> getVaccinations(){
        return vaccinations;
    }

    public void setVaccinationList(List<Vaccination> readObject) {
        for ( Vaccination vac : readObject) {
            vaccinations.add(vac);
        }
    }
}
