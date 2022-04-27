package app.domain.Store;

import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

public class VaccineTypeStore {

    private List<VaccineType> vaccineTypeList;

    public VaccineTypeStore() {
        this.vaccineTypeList = new ArrayList<>();
    }

    public List<VaccineType> getVaccineTypeList() {
        return vaccineTypeList;
    }

    public void addVaccineType(VaccineType vaccineType) {
        this.vaccineTypeList.add(vaccineType);
    }

}
