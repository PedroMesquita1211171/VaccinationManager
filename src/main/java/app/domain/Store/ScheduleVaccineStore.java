package app.domain.Store;

import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.domain.model.SNSUser;
import app.domain.model.ScheduleVaccine;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;

import java.util.ArrayList;
import java.util.List;

public class ScheduleVaccineStore {

    private List<ScheduleVaccine> scheduleVaccineList;

    public ScheduleVaccineStore() {
        this.scheduleVaccineList = new ArrayList<>();
    }

    public List<ScheduleVaccine> getVaccineList(){
        return scheduleVaccineList;
    }

    public void addScheduleVaccine(ScheduleVaccine scheduleVaccine) {
        this.scheduleVaccineList.add(scheduleVaccine);
    }

    public boolean validateScheduleVaccine (ScheduleVaccine scheduleVaccine){
        if (scheduleVaccine == null) return false;
        return !getVaccineList().contains(scheduleVaccine);
    }

    public ScheduleVaccine createScheduleVaccine(SNSUser user, VaccinationCenter v, Vaccine vaccine, String hour){
        return new ScheduleVaccine(user, v, vaccine, hour);
    }

}
