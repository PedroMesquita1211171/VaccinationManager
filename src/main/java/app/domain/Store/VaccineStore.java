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

}
