package app.DTO.Mappers;

import app.DTO.VaccinationCenterDTO;
import app.domain.model.VaccinationCenter;

import java.util.List;

/**
 * The type Vaccination center mapper.
 */
public class VaccinationCenterMapper {
    /**
     * To dto vaccination center dto.
     *
     * @param vc the vc
     * @return the vaccination center dto
     */
    public static VaccinationCenterDTO toDTO(VaccinationCenter vc) {
        if(vc.getTypeOfCenter().equals("HealthCare Center")) {
            return new VaccinationCenterDTO(vc.getName(), vc.getAddress(), vc.getEmailAddress(), vc.getPhoneNumber(), vc.getFaxNumber(), vc.getWebsiteAddress(), vc.getOpeningHours(), vc.getClosingHours(), vc.getSlotDuration(), vc.getMaxVaccines(), vc.getCoordinator(),vc.getAges(),vc.getArs(),vc.getTimeSlots(), vc.getRegion());
        }else if(vc.getTypeOfCenter().equals("Mass Community Vaccination Center")) {
            return new VaccinationCenterDTO(vc.getName(),vc.getAddress(),vc.getEmailAddress(),vc.getPhoneNumber(),vc.getFaxNumber(),vc.getWebsiteAddress(),vc.getOpeningHours(),vc.getClosingHours(),vc.getSlotDuration(),vc.getMaxVaccines(),vc.getCoordinator(),vc.getTimeSlots());
        }else return null;
    }

    /**
     * To entity vaccination center.
     *
     * @param vc the vc
     * @return the vaccination center
     */
    public static VaccinationCenter toEntity(VaccinationCenterDTO vc) {
        if(vc.getTypeOfCenter().equals("HealthCare Center")) {
            return new VaccinationCenter(vc.getName(),vc.getAddress(),vc.getEmailAddress(), vc.getPhoneNumber(), vc.getFaxNumber(),vc.getWebsiteAddress(),vc.getOpeningHours(),vc.getClosingHours(),vc.getSlotDuration(),vc.getMaxVaccines(),vc.getCoordinator(),vc.getAges(),vc.getArs(),vc.getRegion());
        }else if(vc.getTypeOfCenter().equals("Mass Community Vaccination Center")) {
            return new VaccinationCenter(vc.getName(),vc.getAddress(),vc.getEmailAddress(), vc.getPhoneNumber(), vc.getFaxNumber(),vc.getWebsiteAddress(),vc.getOpeningHours(),vc.getClosingHours(),vc.getSlotDuration(),vc.getMaxVaccines(),vc.getCoordinator());
        }else return null;
    }

    /**
     * To entity list list.
     *
     * @param vcDTOs the vc dt os
     * @return the list
     */
    public static List<VaccinationCenter> toEntityList(List<VaccinationCenterDTO> vcDTOs) {
        List<VaccinationCenter> vcList = new java.util.ArrayList<>();
        for(VaccinationCenterDTO vcDTO : vcDTOs) {
            vcList.add(toEntity(vcDTO));
        }
        return vcList;
      }

    /**
     * To dto list list.
     *
     * @param vcList the vc list
     * @return the list
     */
    public static List<VaccinationCenterDTO> toDTOList(List<VaccinationCenter> vcList) {
        List<VaccinationCenterDTO> vcDTOList = new java.util.ArrayList<>();
        for(VaccinationCenter vc : vcList) {
            vcDTOList.add(toDTO(vc));
        }
        return vcDTOList;
      }
    }
