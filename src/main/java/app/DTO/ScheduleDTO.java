package app.DTO;

import app.domain.model.SNSUser;
import app.domain.model.Schedule;
import app.domain.model.ScheduleDependencies.Data;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;

/**
 * The type Schedule dto.
 */
public class ScheduleDTO {
    private SNSUser snsu;
    private VaccinationCenter vc;
    private Vaccine vaccine;


    private Data vaccineDate;
    private TimeSlot vaccineTimeSlot;
    private AdministrationProcess vaccineAdministrationProcess;

    /**
     * Instantiates a new Schedule dto.
     *
     * @param schedule the schedule
     */
    public ScheduleDTO(Schedule schedule) {
        this.snsu = schedule.getSnsu();
        this.vc = schedule.getVc();
        this.vaccine = schedule.getVaccine();
        

        this.vaccineDate = schedule.getVaccineDate();
        this.vaccineTimeSlot = schedule.getVaccineTimeSlot();
        this.vaccineAdministrationProcess = schedule.getVaccineAdministrationProcess();
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
    public String toString() {
        return "\nScheduling Info\n" + "SNS User Number: " + this.snsu.getSNSNumber() + "\n" +
                "Vaccination Center: " + this.vc.getName() + "\n" +
                        "Vaccine: " + this.vaccine.getBrand() + "\n" +
                "Date: " + this.vaccineDate.toString() + " " + this.vaccineTimeSlot.toString() + "\n"+
                this.vaccineAdministrationProcess.toString() + "\n";
    }
}
