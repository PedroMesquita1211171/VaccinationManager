package app.domain.Store;

import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henrique Pinto - 1211201
 */
public class VaccineTypeStore {

    /**
     * List that will Store VaccineTypes.
     */

    private List<VaccineType> vaccineTypeList;

    /**
     * Declares the vaccine type list as an ArrayList.
     */
    public VaccineTypeStore() {
        this.vaccineTypeList = new ArrayList<>();
    }

    /**
     * Gets vaccine type list.
     *
     * @return vaccineTypeList
     */
    public List<VaccineType> getVaccineTypeList() {
        return vaccineTypeList;
    }

    /**
     * Adds vaccine type to the List.
     *
     * @param vaccineType the vaccine type
     */
    public void addVaccineType(VaccineType vaccineType) {
        this.vaccineTypeList.add(vaccineType);
    }

}
