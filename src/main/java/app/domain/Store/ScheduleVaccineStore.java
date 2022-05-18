package app.domain.Store;

import app.domain.model.ScheduleVaccine;
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

    public ScheduleVaccine createScheduleVaccine(String nameUser, String phoneNumber, String vaccinationCenter, String vaccine, String hour){
        return new ScheduleVaccine(nameUser, phoneNumber, vaccinationCenter, vaccine, hour);
    }
}
