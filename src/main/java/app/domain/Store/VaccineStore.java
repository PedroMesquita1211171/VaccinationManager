package app.domain.Store;
import app.domain.model.Vaccine;
import java.util.ArrayList;
import java.util.List;


/**
 * Stores Vaccines
 *
 * @author Pedro Mesquita - 1211171
 */
public class VaccineStore {

    private List<Vaccine> vaccineList;

    /**
     * Declares the vaccine list as an ArrayList.
     */
    public VaccineStore() {
        this.vaccineList = new ArrayList<>();
    }

    /**
     * Gets vaccine list.
     *
     * @return the vaccine list
     */
    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }

    /**
     * Add vaccine.
     *
     * @param Vaccine the vaccine
     */
    public void addVaccine(Vaccine Vaccine) {
        this.vaccineList.add(Vaccine);
    }
    /**
     * Validates the created vaccine.
     *
     * @param vaccine
     * @return the boolean
     */
    public boolean validateVaccine (Vaccine vaccine){
        if (vaccine == null) return false;
        return !getVaccineList().contains(vaccine);
    }
    /**
     * Creates vaccine.
     *
     * @param name         the name
     * @param id           the id
     * @param brand        the brand
     * @param doses        the doses
     * @param dosage       the dosage
     * @param recovery     the recovery
     * @param doseinterval the doseinterval
     * @return the boolean
     */
    public Vaccine createVaccine(String name, int id, String brand, int doses,int dosage, int recovery, int doseinterval) {
           return new Vaccine(name, id, brand, doses, dosage, recovery, doseinterval);
    }

    }
