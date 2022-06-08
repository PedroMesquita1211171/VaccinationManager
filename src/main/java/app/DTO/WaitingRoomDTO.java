package app.DTO;

import app.domain.model.Schedule;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.Tempo;

/**
 * The type Waiting room dto.
 */
public class WaitingRoomDTO {
    private VaccinationCenter vaccinationCenter;
    private Schedule schedule;
    private Tempo arrivalHour;

    /**
     * Instantiates a new Waiting room dto.
     *
     * @param vaccinationCenter the vaccination center
     * @param schedule          the schedule
     * @param arrivalHour       the arrival hour
     */
    public WaitingRoomDTO(VaccinationCenter vaccinationCenter, Schedule schedule, Tempo arrivalHour){
        this.vaccinationCenter = vaccinationCenter;
        this.schedule = schedule;
        this.arrivalHour = arrivalHour;
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
     * Gets schedule.
     *
     * @return the schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Gets arrival hour.
     *
     * @return the arrival hour
     */
    public Tempo getArrivalHour() {
        return arrivalHour;
    }

    @Override
    public String toString() {
        return
                "SNS User: " + this.schedule.getSnsu().getName() + "\n" +
                "Vaccination Center: " + this.vaccinationCenter.getName() + " , " + this.vaccinationCenter.getAddress() + "\n" +
                "Vaccine: " + this.schedule.getVaccine().getBrand() + "\n" +
                "Vaccination Day: " + this.schedule.getVaccineDate() + "\n" +
                        "Arrival Hour: " + this.arrivalHour + "\n"

                ;
    }
}
