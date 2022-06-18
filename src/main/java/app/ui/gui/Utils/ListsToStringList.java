package app.ui.gui.Utils;

import app.DTO.VaccineDTO;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;

public class ListsToStringList {
    public static List<String> vaccineDTOListToStringList(List<VaccineDTO> vaccines) {
        List<String> strings = new ArrayList<>(vaccines.size());
        for (VaccineDTO v: vaccines) {
            strings.add("Brand: "+ v.getBrand()+"\nLot Number: "+ v.getLotNumber());
        }
        return strings;
    }
}
