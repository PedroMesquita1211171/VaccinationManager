package app.controller;

import app.domain.model.*;
import java.util.List;

/**
 * The type Register arrival controller.
 */
public class RegisterArrivalController {

    private final Company company;

    /**
     * Instantiates a new Register arrival controller.
     */
    public RegisterArrivalController() {
        this.company = App.getInstance().getCompany();
    }

    /**
     * Gets center list.
     *
     * @return the center list
     */
    public List<VaccinationCenter> getCenterList() {
        return this.company.getVaccinationCenterStore().getVaccinationCenterList();
    }

    /**
     * Gets schedules.
     *
     * @return the schedules
     */
    public List<ScheduleVaccine> getSchedules() {
        return this.company.getScheduleVaccineStore().getScheduledVaccineList();
    }

    /**
     * Add waiting room boolean.
     *
     * @param waitingRoom the waiting room
     * @return the boolean
     */
    public boolean addWaitingRoom(WaitingRoom waitingRoom) {
        return this.company.getWaitingRoomStore().addWaiting(waitingRoom);
    }

    /**
     * Remove schedule from list boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean removeScheduleFromList(ScheduleVaccine schedule) {
        return this.company.getScheduleVaccineStore().getScheduledVaccineList().remove(schedule);
    }
}