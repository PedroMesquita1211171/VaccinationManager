package app.ui.gui.Utils;

import app.DTO.VaccineDTO;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Lists to string list.
 */
public class ListsToStringList {
    /**
     * Vaccine dto list to string list list.
     *
     * @param vaccines the vaccines
     * @return the list
     */
    public static List<String> vaccineDTOListToStringList(List<VaccineDTO> vaccines) {
        List<String> strings = new ArrayList<>(vaccines.size());
        for (VaccineDTO v: vaccines) {
            strings.add("Brand: "+ v.getBrand()+"\nLot Number: "+ v.getLotNumber());
        }
        return strings;
    }
}
