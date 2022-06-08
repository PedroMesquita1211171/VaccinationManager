package app.domain.model;

import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;

/**
 * The type Waiting room.
 */
public class WaitingRoom {

    private VaccinationCenter vaccinationCenter;
    private Schedule schedule;

    private Tempo arrivalHour;

    /**
     * Instantiates a new Waiting room.
     *
     * @param vaccinationCenter the vaccination center
     * @param schedule          the schedule
     * @param arrivalHour       the arrival hour
     */
    public WaitingRoom(VaccinationCenter vaccinationCenter, Schedule schedule, Tempo arrivalHour){
        this.schedule = schedule;
        checkArrival(arrivalHour);
        this.vaccinationCenter = vaccinationCenter;
        this.arrivalHour = arrivalHour;
    }

    /**
     * Checks whether arrival hour is valid or not through the throwing of an exception
     *
     * @param arrivalHour
     */
    private void checkArrival(Tempo arrivalHour) {
        TimeSlot ts = this.schedule.getVaccineTimeSlot();
        if(!ts.isValid(arrivalHour)) throw new IllegalArgumentException("\nInvalid Arrival Hour!\nNot eligible for Vaccination.\n");
    }

    /**
     * Gets vaccination center.
     *
     * @return the vaccination center
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Sets vaccination center.
     *
     * @param vaccinationCenter the vaccination center
     */
    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    /**
     * Gets schedule.
     *
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Sets schedule.
     *
     * @param schedule the schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Gets arrival hour.
     *
     * @return the arrival hour
     */
    public Tempo getArrivalHour() {
        return arrivalHour;
    }

    /**
     * Sets arrival hour.
     *
     * @param arrivalHour the arrival hour
     */
    public void setArrivalHour(Tempo arrivalHour) {
        this.arrivalHour = arrivalHour;
    }
}
