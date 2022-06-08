package app.DTO.Mappers;

import app.DTO.VaccineTypeDTO;
import app.domain.model.VaccineType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vaccine type mapper.
 */
public class VaccineTypeMapper {
    /**
     * To dto vaccine type dto.
     *
     * @param vaccineType the vaccine type
     * @return the vaccine type dto
     */
    public static VaccineTypeDTO toDTO(VaccineType vaccineType) {
        return new VaccineTypeDTO(vaccineType.getCode(),vaccineType.getDesignation(),vaccineType.getVaccineTechnology());
    }

    /**
     * To dto list.
     *
     * @param vaccineTypes the vaccine types
     * @return the list
     */
    public static List<VaccineTypeDTO> toDTOList(List<VaccineType> vaccineTypes) {
        List<VaccineTypeDTO> vaccineTypeDTOS =  new ArrayList<>();
        for (VaccineType vaccineType : vaccineTypes) {
            vaccineTypeDTOS.add(toDTO(vaccineType));
        }
        return vaccineTypeDTOS;
    }

    /**
     * To entity vaccine type.
     *
     * @param vaccineTypeDTO the vaccine type dto
     * @return the vaccine type
     */
    public static VaccineType toEntity(VaccineTypeDTO vaccineTypeDTO) {
        return new VaccineType(vaccineTypeDTO.getCode(),vaccineTypeDTO.getDesignation(),vaccineTypeDTO.getWhoId());
    }

    /**
     * To entity list.
     *
     * @param vaccineTypeDTOS the vaccine type dtos
     * @return the list
     */
    public static List<VaccineType> toEntityList(List<VaccineTypeDTO> vaccineTypeDTOS) {
        List<VaccineType> vaccineTypes =  new ArrayList<>();
        for (VaccineTypeDTO vaccineTypeDTO : vaccineTypeDTOS) {
            vaccineTypes.add(toEntity(vaccineTypeDTO));
        }
        return vaccineTypes;
    }
}
