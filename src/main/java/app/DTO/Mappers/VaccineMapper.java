package app.DTO.Mappers;

import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;

public class VaccineMapper {

    public static VaccineDTO toDTO(Vaccine vaccine){
        return new VaccineDTO(vaccine.getName(), vaccine.getID(), vaccine.getBrand(),vaccine.getDoses(), vaccine.getDosage(), vaccine.getRecovery(), vaccine.getDoseInterval());
    }

    public static List<VaccineDTO> toDTOList(List<Vaccine> vac){
        List<VaccineDTO> vaccineDTO = new ArrayList<>();
        for (Vaccine vaccine : vac) {
            vaccineDTO.add(toDTO(vaccine));
        }
        return vaccineDTO;
    }
}
