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

    private final VaccinationCenterMapper centerMapper;

    private final VaccineMapper vaccineMapper;

    private final VaccinationCenterStore centerStore;

    private final VaccineStore vaccineStore;

    private final ScheduleVaccineStore schedule;


    public UserScheduleVaccineController(){this(App.getInstance().getCompany());}

    public UserScheduleVaccineController(Company company){
            this.company = App.getInstance().getCompany();
            this.centerStore = company.getVaccinationCenterStore();
            this.vaccineStore = company.getVaccineStore();
            this.centerMapper = new VaccinationCenterMapper();
            this.vaccineMapper = new VaccineMapper();
            this.schedule = new ScheduleVaccineStore();
    }

    public boolean createSchedule(Date scheduleDate, Date scheduleHour, int snsUserID, String centerName, String vaccineName){
        try{
            this.schedule = new ScheduleVaccine(scheduleDate,scheduleHour, snsUserID, centerName, vaccineName);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public List<VaccinationCenterDTO> vacCenterList(){
        return VaccinationCenterMapper.toDTOList(this.company.getVaccinationCenterStore().getVaccinationCenterList());
    }

    public List<VaccineDTO> vaccineList(){
        return VaccineMapper.toDTOList(this.company.getVaccineStore().getVaccineList());
    }

    public SNSUser userLogin(){
        List<SNSUser> snsUsersList = this.company.getSNSUserStore().getSNSUserList();
        for (SNSUser snsu : snsUsersList) {
            if(this.company.getAuthFacade().getCurrentUserSession().getUserId().equals(snsu.getEmail())){
                return snsu;
            }
        }
        return null;
    }

    public List<ScheduleVaccine> getScheduleList() {
        return company.getScheduleVaccineStore().getScheduledVaccineList();
    }

    public ScheduleVaccineStore getSchedule() {
        return company.getScheduleVaccineStore();
    }

    public boolean checkScheduleDateAndCenterAndVaccine(Date scheduleDate, String centerName, String vaccineName) {
        return schedule.findSchedule(scheduleDate, centerName, vaccineName);
    }
    public boolean scheduleVaccineWithEntries(String email, int snsUserNumber, String centerName, String vaccineName, Date scheduleDate, String slotDuration, String maxVaccinesPerSlot, String openingHour, String closingHour) {
        return schedule.scheduleVaccineWithEntries(email, snsUserNumber, centerName, vaccineName, scheduleDate, slotDuration, maxVaccinesPerSlot, openingHour, closingHour);
    }

    public boolean checkForDuplicateSchedule(String vaccineName, String snsUserNumber) {
        return schedule.checkForDuplicateSchedule(vaccineName, snsUserNumber);
    }
}
