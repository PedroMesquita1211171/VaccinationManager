package app.controller;


import app.domain.model.Company;
import app.domain.model.ScheduleVaccine;

public class UserScheduleVaccineController {

    private Company company;
    private ScheduleVaccine schedule;

    public UserScheduleVaccineController(){this(App.getInstance().getCompany());}

    public UserScheduleVaccineController(Company company){
        this.company=company;
        this.schedule= null;
    }

    public boolean createSchedule(String address, String vaccineName, String hour){
        return true;
    }

    public void saveSchedule() {
        this.company.getScheduleVaccineStore().addScheduleVaccine(schedule);
    }
}
