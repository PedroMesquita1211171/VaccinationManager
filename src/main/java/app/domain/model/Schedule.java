package app.domain.model;


import app.domain.model.ScheduleDependencies.Data;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;
import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Schedule.
 */
public class Schedule implements Serializable {

    private SNSUser snsu;
    private VaccinationCenter vc;
    private Vaccine vaccine;

    private Data vaccineDate;
    private TimeSlot vaccineTimeSlot;
    private AdministrationProcess vaccineAdministrationProcess;

    /**
     * Instantiates a new Schedule.
     *
     * @param snsu                         the snsu
     * @param vc                           the vc
     * @param vaccine                      the vaccine
     * @param vaccineDate                  the vaccine date
     * @param vaccineTimeSlot              the vaccine time slot
     * @param vaccineAdministrationProcess the vaccine administration process
     */
    public Schedule(SNSUser snsu, VaccinationCenter vc, Vaccine vaccine, Data vaccineDate, TimeSlot vaccineTimeSlot, AdministrationProcess vaccineAdministrationProcess) {
        this.snsu = snsu;
        this.vc = vc;
        this.vaccine = vaccine;
        this.vaccineDate = vaccineDate;
        this.vaccineTimeSlot = vaccineTimeSlot;
        this.vaccineAdministrationProcess = vaccineAdministrationProcess;
    }

    /**
     * Gets snsu.
     *
     * @return the snsu
     */
    public SNSUser getSnsu() {
        return snsu;
    }

    /**
     * Sets snsu.
     *
     * @param snsu the snsu
     */
    public void setSnsu(SNSUser snsu) {
        this.snsu = snsu;
    }

    /**
     * Gets vc.
     *
     * @return the vc
     */
    public VaccinationCenter getVc() {
        return vc;
    }

    /**
     * Sets vc.
     *
     * @param vc the vc
     */
    public void setVc(VaccinationCenter vc) {
        this.vc = vc;
    }

    /**
     * Gets vaccine.
     *
     * @return the vaccine
     */
    public Vaccine getVaccine() {
        return vaccine;
    }

    /**
     * Sets vaccine.
     *
     * @param vaccine the vaccine
     */
    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    /**
     * Gets vaccine date.
     *
     * @return the vaccine date
     */
    public Data getVaccineDate() {
        return vaccineDate;
    }

    /**
     * Sets vaccine date.
     *
     * @param vaccineDate the vaccine date
     */
    public void setVaccineDate(Data vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    /**
     * Gets vaccine time slot.
     *
     * @return the vaccine time slot
     */
    public TimeSlot getVaccineTimeSlot() {
        return vaccineTimeSlot;
    }

    /**
     * Sets vaccine time slot.
     *
     * @param vaccineTimeSlot the vaccine time slot
     */
    public void setVaccineTimeSlot(TimeSlot vaccineTimeSlot) {
        this.vaccineTimeSlot = vaccineTimeSlot;
    }

    /**
     * Gets vaccine administration process.
     *
     * @return the vaccine administration process
     */
    public AdministrationProcess getVaccineAdministrationProcess() {
        return vaccineAdministrationProcess;
    }

    /**
     * Sets vaccine administration process.
     *
     * @param vaccineAdministrationProcess the vaccine administration process
     */
    public void setVaccineAdministrationProcess(AdministrationProcess vaccineAdministrationProcess) {
        this.vaccineAdministrationProcess = vaccineAdministrationProcess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(snsu, schedule.snsu) && Objects.equals(vaccine, schedule.vaccine) && Objects.equals(vaccineAdministrationProcess, schedule.vaccineAdministrationProcess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snsu, vaccine, vaccineAdministrationProcess);
    }
}
