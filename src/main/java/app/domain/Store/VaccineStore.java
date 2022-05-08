package app.domain.Store;
import app.domain.model.Vaccine;
import java.util.ArrayList;
import java.util.List;


public class VaccineStore {
    private List<Vaccine> vaccineList;
    public VaccineStore() {
        this.vaccineList = new ArrayList<>();
    }
    public List<Vaccine> getVaccineList() {
        return vaccineList;
    }
    public void addVaccine(Vaccine Vaccine) {
        this.vaccineList.add(Vaccine);
    }

}
