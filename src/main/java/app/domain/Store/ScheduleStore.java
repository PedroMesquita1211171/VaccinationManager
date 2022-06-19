package app.domain.Store;

import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.VaccinationCenterDTO;
import app.domain.model.SNSUser;
import app.domain.model.Schedule;
import app.domain.model.ScheduleDependencies.Data;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.TimeSlot;
import app.domain.model.Vaccine;
import app.domain.model.VaccineDependencies.AdministrationProcess;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Schedule store.
 */
public class ScheduleStore {

    private List<Schedule> scheduleList;

    /**
     * Instantiates a new Schedule store.
     */
    public ScheduleStore() {
        scheduleList = new ArrayList<>();
    }

    /**
     * Create schedule schedule.
     *
     * @param snsu                         the snsu
     * @param vc                           the vc
     * @param vaccine                      the vaccine
     * @param vaccineDate                  the vaccine date
     * @param vaccineTimeSlot              the vaccine time slot
     * @param vaccineAdministrationProcess the vaccine administration process
     * @return the schedule
     */
    public Schedule createSchedule(SNSUser snsu, VaccinationCenter vc, Vaccine vaccine, Data vaccineDate, TimeSlot vaccineTimeSlot, AdministrationProcess vaccineAdministrationProcess){
        return new Schedule(snsu, vc, vaccine, vaccineDate, vaccineTimeSlot, vaccineAdministrationProcess);
    }

    /**
     * Validate schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean validateSchedule(Schedule schedule){
        if(schedule == null)return false;
        return !scheduleList.contains(schedule);
    }

    /**
     * Add schedule boolean.
     *
     * @param schedule the schedule
     * @return the boolean
     */
    public boolean addSchedule(Schedule schedule) {
        if (validateSchedule(schedule)) {
            scheduleList.add(schedule);
            return true;
        }
        return false;
    }


    /**
     * Slot available boolean.
     *
     * @param vaccineDate the vaccine date
     * @param timeSlot    the time slot
     * @param vc          the vc
     * @return the boolean
     */
    public boolean slotAvailable(Data vaccineDate, TimeSlot timeSlot, VaccinationCenterDTO vc){
        int count = 0;
        for (Schedule e : scheduleList) {
            if (e.getVaccineDate().equals(vaccineDate) && e.getVaccineTimeSlot().equals(timeSlot) && VaccinationCenterMapper.toDTO(e.getVc()).equals(vc)) {
                count++;
            }
        }
        return count < vc.getMaxVaccines();
    }

    /**
     * Show today schedules list.
     *
     * @return the list
     */
    public List<Schedule> showTodaySchedules(){
        List<Schedule> today = new ArrayList<>();

        for (Schedule s : scheduleList) {
            if(s.getVaccineDate().equals(Data.dataAtual())){
                today.add(s);
            }
        }
        return today;
    }

    /**
     * Removes schedule.
     *
     * @param schedule the schedule
     */
    public void removeSchedule(Schedule schedule) {
       scheduleList.remove(schedule);
    }
}
