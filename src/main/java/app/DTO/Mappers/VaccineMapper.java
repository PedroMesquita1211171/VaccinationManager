package app.DTO.Mappers;

import app.DTO.VaccineDTO;
import app.domain.model.Vaccine;

import java.util.List;

/**
 * The type Vaccine mapper.
 */
public class VaccineMapper {

    /**
     * To dto vaccine dto.
     *
     * @param vaccine the vaccine
     * @return the vaccine dto
     */
    public static VaccineDTO toDTO(Vaccine vaccine){
        return new VaccineDTO(vaccine.getBrand(), vaccine.getLotNumber(), vaccine.getAdministrationProcesses(), vaccine.getVaccineType());
    }

    /**
     * To domain vaccine.
     *
     * @param vaccineDTO the vaccine dto
     * @return the vaccine
     */
    public static Vaccine toDomain(VaccineDTO vaccineDTO){
        return new Vaccine(vaccineDTO.getBrand(), vaccineDTO.getLotNumber(), vaccineDTO.getAdministrationProcesses(), vaccineDTO.getVaccineType());
    }

    /**
     * To dto list.
     *
     * @param vaccines the vaccines
     * @return the list
     */
    public static List<VaccineDTO> toDTOList(List<Vaccine> vaccines){
        List<VaccineDTO> vaccineDTOs = new java.util.ArrayList<>();
        for(Vaccine vaccine : vaccines){
            vaccineDTOs.add(toDTO(vaccine));
        }
        return vaccineDTOs;
    }

    /**
     * To domain list.
     *
     * @param vaccineDTOs the vaccine dt os
     * @return the list
     */
    public static List<Vaccine> toDomainList(List<VaccineDTO> vaccineDTOs){
        List<Vaccine> vaccines = new java.util.ArrayList<>();
        for(VaccineDTO vaccineDTO : vaccineDTOs){
            vaccines.add(toDomain(vaccineDTO));
        }
        return vaccines;
    }

}
