package app.controller;


import app.domain.model.Company;
import app.domain.model.SNSUser;
import app.domain.model.ScheduleVaccine;
import app.domain.Store.ScheduleVaccineStore;
import app.domain.Store.VaccinationCenterStore;
import app.domain.Store.VaccineStore;
import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.Mappers.VaccineMapper;
import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;

import java.util.Date;
import java.util.List;

public class UserScheduleVaccineController {

    private final Company company;
    private ScheduleVaccine scheduleVaccine;


    public UserScheduleVaccineController(){this(App.getInstance().getCompany());}

    public UserScheduleVaccineController(Company company){
            this.company = App.getInstance().getCompany();
            this.scheduleVaccine = null;
    }

    public boolean createSchedule(Date scheduleDate, Date scheduleHour, String snsUserID, String centerAddress, String vaccineName){
        try{
            this.scheduleVaccine = this.company.getScheduleVaccineStore().createScheduleVaccine(scheduleDate,scheduleHour, snsUserID, centerAddress, vaccineName);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return this.company.getScheduleVaccineStore().validateScheduleVaccine(this.scheduleVaccine);
    }


    public boolean saveSchedule(){
        return this.company.getScheduleVaccineStore().saveSchedule(this.scheduleVaccine);
    }

    public List<VaccinationCenterDTO> vacCenterList(){
        return VaccinationCenterMapper.toDTOList(this.company.getVaccinationCenterStore().getVaccinationCenterList());
    }

    public List<VaccineDTO> vaccineList(){
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }

    public SNSUser userLogin(){
        return this.company.getSNSUserStore().returnLoggedSNSUser(this.company.getAuthFacade().getCurrentUserSession().getUserId().getEmail());
    }
}
