package app.DTO.Mappers;

import app.DTO.VaccinationCenterDTO;
import app.domain.model.VaccinationCenter;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterMapper {

    public static VaccinationCenterDTO toDTO(VaccinationCenter vaccinationCenter){

        if(vaccinationCenter.getTypeOfCenter().equals("Mass Community Vaccination Center")) return new VaccinationCenterDTO(vaccinationCenter.getFaxNumber(), vaccinationCenter.getEmailAddress(), vaccinationCenter.getAddress(), vaccinationCenter.getPhoneNumber(), vaccinationCenter.getWebsiteAddress(),vaccinationCenter.getOpeningHours(),vaccinationCenter.getClosingHours(),vaccinationCenter.getSlotDuration(),vaccinationCenter.getMaxVaccines(),vaccinationCenter.getCoordinator());
       else if(vaccinationCenter.getTypeOfCenter().equals("Healthcare center")) return new VaccinationCenterDTO(vaccinationCenter.getFaxNumber(), vaccinationCenter.getEmailAddress(), vaccinationCenter.getAddress(), vaccinationCenter.getPhoneNumber(), vaccinationCenter.getWebsiteAddress(),vaccinationCenter.getOpeningHours(),vaccinationCenter.getClosingHours(),vaccinationCenter.getSlotDuration(),vaccinationCenter.getMaxVaccines(),vaccinationCenter.getCoordinator(),vaccinationCenter.getAges(),vaccinationCenter.getArs());
       else return null;
    }

    public static List<VaccinationCenterDTO> toDTOList(List<VaccinationCenter> vacC){
        List<VaccinationCenterDTO> vaccinationCenterDTO = new ArrayList<>();
        for (VaccinationCenter vaccinationCenter : vacC) {
            vaccinationCenterDTO.add(toDTO(vaccinationCenter));
        }
        return vaccinationCenterDTO;
    }

}