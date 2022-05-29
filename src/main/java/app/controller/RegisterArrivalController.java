package app.controller;

import app.domain.model.*;
import java.util.List;

public class RegisterArrivalController {

    private final Company company;

    public RegisterArrivalController() {
        this.company = App.getInstance().getCompany();
    }

    public List<VaccinationCenter> getCenterList() {
        return this.company.getVaccinationCenterStore().getVaccinationCenterList();
    }

    public List<ScheduleVaccine> getSchedules() {
        return this.company.getScheduleVaccineStore().getScheduledVaccineList();
    }

    public boolean addWaitingRoom(WaitingRoom waitingRoom) {
        return this.company.getWaitingRoomStore().addWaiting(waitingRoom);
    }

    public boolean removeScheduleFromList(ScheduleVaccine schedule) {
        return this.company.getScheduleVaccineStore().getScheduledVaccineList().remove(schedule);
    }
}