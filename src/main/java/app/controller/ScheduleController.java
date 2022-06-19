package app.controller;

import app.DTO.Mappers.SNSUserMapper;
import app.DTO.Mappers.ScheduleMapper;
import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.Mappers.VaccineMapper;
import app.DTO.SNSUserDTO;
import app.DTO.ScheduleDTO;
import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.domain.model.*;
import app.domain.model.ScheduleDependencies.Data;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.shared.CommonMethods;

import java.util.List;

/**
 * The type Schedule controller.
 */
public class ScheduleController {

    private Company company;
    private Schedule schedule;

    /**
     * Instantiates a new Schedule controller.
     */
    public ScheduleController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Schedule controller.
     *
     * @param company the company
     */
    public ScheduleController(Company company){
        this.company = company;
        schedule = null;
    }


    /**
     * Create schedule boolean.
     *
     * @param userDTO               the user dto
     * @param vaccinationCenterDTO  the vaccination center dto
     * @param vaccineDTO            the vaccine dto
     * @param vaccineDate           the vaccine date
     * @param timeSlot              the time slot
     * @param administrationProcess the administration process
     * @return the boolean
     */
    public boolean createSchedule(SNSUserDTO userDTO, VaccinationCenterDTO vaccinationCenterDTO, VaccineDTO vaccineDTO, Data vaccineDate, TimeSlot timeSlot, AdministrationProcess administrationProcess) {
        SNSUser user = SNSUserMapper.toEntity(userDTO);
        VaccinationCenter vaccinationCenter = VaccinationCenterMapper.toEntity(vaccinationCenterDTO);
        Vaccine vaccine = VaccineMapper.toDomain(vaccineDTO);

        this.schedule = this.company.getScheduleStore().createSchedule(user, vaccinationCenter, vaccine, vaccineDate, timeSlot, administrationProcess);


        return this.company.getScheduleStore().validateSchedule(this.schedule);

    }

    /**
     * Save schedule boolean.
     *
     * @return the boolean
     */
    public boolean saveSchedule(){
        boolean a = this.company.getScheduleStore().addSchedule(this.schedule);
        CommonMethods.serializeStore(this.company.getScheduleStore().getScheduleList(),"data\\Schedule.dat");
        return a;
    }

    /**
     * Get vaccination centers list.
     *
     * @return the list
     */
    public List<VaccinationCenterDTO> getVaccinationCenters(){
        return VaccinationCenterMapper.toDTOList(this.company.getVaccinationCenterStore().getVaccinationCenters());
    }

    /**
     * Get vaccines list.
     *
     * @return the list
     */
    public List<VaccineDTO> getVaccines(){
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }

    /**
     * Get sns user sns user dto.
     *
     * @param SNSNumber the sns number
     * @return the sns user dto
     */
    public SNSUserDTO getSNSUser(String SNSNumber){
        for (SNSUser snsu : this.company.getSNSUserStore().getSNSUserList()) {
            if(snsu.getSNSNumber().equals(SNSNumber)){
                return SNSUserMapper.toDTO(snsu);
            }
        }
        throw new IllegalArgumentException("SNS User not found");
    }

    /**
     * Get sns user sns user dto.
     *
     * @return the sns user dto
     */
    public SNSUserDTO getSNSUser(){
        String email = this.company.getAuthFacade().getCurrentUserSession().getUserId().getEmail();
        for (SNSUser snsu : this.company.getSNSUserStore().getSNSUserList()) {
            if(snsu.getEmail().equals(email)){
                return SNSUserMapper.toDTO(snsu);
            }
        }
        throw new IllegalArgumentException("SNS User not found");
    }

    /**
     * Slot available boolean.
     *
     * @param vaccineDate       the vaccine date
     * @param timeSlot          the time slot
     * @param vaccinationCenter the vaccination center
     * @return the boolean
     */
    public boolean slotAvailable(Data vaccineDate, TimeSlot timeSlot, VaccinationCenterDTO vaccinationCenter){
        return this.company.getScheduleStore().slotAvailable(vaccineDate,timeSlot,vaccinationCenter);
    }

    /**
     * Get schedule schedule dto.
     *
     * @return the schedule dto
     */
    public ScheduleDTO getSchedule(){
        return ScheduleMapper.toDTO(this.schedule);
    }

}
