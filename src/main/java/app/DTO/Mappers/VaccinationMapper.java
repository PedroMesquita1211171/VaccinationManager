package app.DTO.Mappers;

import app.DTO.VaccinationDTO;
import app.domain.model.Vaccination;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccination mapper.
 */
public class VaccinationMapper {
    /**
     * To dto vaccination dto.
     *
     * @param vaccination the vaccination
     * @return the vaccination dto
     */
    public static VaccinationDTO toDTO(Vaccination vaccination) {
        return new VaccinationDTO(vaccination.getAr(), vaccination.getV(), vaccination.getDose(), vaccination.getStatus(), vaccination.getAp());
    }

    /**
     * To domain vaccination.
     *
     * @param vaccinationDTO the vaccination dto
     * @return the vaccination
     */
    public static Vaccination toDomain(VaccinationDTO vaccinationDTO) {
        return new Vaccination(vaccinationDTO.getAr(), vaccinationDTO.getV(), vaccinationDTO.getDose(), vaccinationDTO.getStatus(), vaccinationDTO.getAp());
    }

    /**
     * To dto list.
     *
     * @param vaccinations the vaccinations
     * @return the list
     */
    public static List<VaccinationDTO> toDTO(List<Vaccination> vaccinations) {

        List<VaccinationDTO> vaccinationsDTO = new ArrayList<>();

        for (Vaccination vaccination : vaccinations) {
            vaccinationsDTO.add(toDTO(vaccination));
        }

        return vaccinationsDTO;
    }

    /**
     * To domain list.
     *
     * @param vaccinationsDTO the vaccinations dto
     * @return the list
     */
    public static List<Vaccination> toDomain(List<VaccinationDTO> vaccinationsDTO) {

        List<Vaccination> vaccinations = new ArrayList<>();

        for (VaccinationDTO vaccinationDTO : vaccinationsDTO) {
            vaccinations.add(toDomain(vaccinationDTO));
        }

        return vaccinations;
    }
}
