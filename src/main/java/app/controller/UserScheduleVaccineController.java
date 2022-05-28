package app.controller;


import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.Mappers.VaccineMapper;
import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.domain.model.*;

import java.util.List;

public class UserScheduleVaccineController {

    private Company company;
    private ScheduleVaccine schedule;

    public UserScheduleVaccineController(){this(App.getInstance().getCompany());}

    public UserScheduleVaccineController(Company company){
        this.company=company;
        this.schedule= null;
    }

    public boolean createSchedule(SNSUser user, VaccinationCenterDTO vacCenter, VaccineDTO vaccine, String slot){
        try{
            this.schedule = new ScheduleVaccine(user,vC(vacCenter), vac(vaccine), slot);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public void saveSchedule() {
        this.company.getScheduleVaccineStore().addScheduleVaccine(schedule);
    }

    public List<VaccinationCenterDTO> showVacCenter(){
        return VaccinationCenterMapper.toDTOList(this.company.getVaccinationCenterStore().getVaccinationCenterList());
    }

    public List<VaccineDTO> showVaccine(){
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
    public VaccinationCenter vC(VaccinationCenterDTO vaccinationCenterDTO){
        List<VaccinationCenter> vaccinationCenterList = this.company.getVaccinationCenterStore().getVaccinationCenterList();
        for (VaccinationCenter vacCenter: vaccinationCenterList) {
            if(vacCenter.getEmailAddress().equals(vaccinationCenterDTO.getEmailAddress())){
                return vacCenter;
            }
        }
        return null;
    }
    public Vaccine vac(VaccineDTO vaccineDTO){
        List<Vaccine> vaccineList = this.company.getVaccineStore().getVaccineList();
        for (Vaccine vaccine: vaccineList) {
            if(vaccine.getID() == vaccineDTO.getID()){
                return vaccine;
            }
        }
        return null;
    }

    public void checkVaccinations(VaccineDTO vaccineDTO){
        List<SNSUser> snsUsersList = this.company.getSNSUserStore().getSNSUserList();
        List<Vaccine> vaccineList = this.company.getVaccineStore().getVaccineList();
        for (SNSUser snsu : snsUsersList) {
            if(this.company.getAuthFacade().getCurrentUserSession().getUserId().equals(snsu.getEmail())) {
                for (Vaccine vaccine : vaccineList) {
                    if (vaccine.getID() == vaccineDTO.getID()) {
                        throw new IllegalArgumentException("The administration of this vaccine has already been scheduled!");

                    }
                }
            }
        }

    }


}
