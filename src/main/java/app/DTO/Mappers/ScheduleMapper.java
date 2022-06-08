package app.DTO.Mappers;

import app.DTO.ScheduleDTO;
import app.domain.model.Schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Schedule mapper.
 */
public class ScheduleMapper {

    /**
     * To dto schedule dto.
     *
     * @param schedule the schedule
     * @return the schedule dto
     */
    public static ScheduleDTO toDTO(Schedule schedule) {
        return new ScheduleDTO(schedule);
    }

    /**
     * To dto list list.
     *
     * @param schedules the schedules
     * @return the list
     */
    public static List<ScheduleDTO> toDTOList(List<Schedule> schedules) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();

        for (Schedule schedule : schedules) {
            scheduleDTOList.add(toDTO(schedule));
        }

        return scheduleDTOList;
    }

    /**
     * To entity schedule.
     *
     * @param scheduleDTO the schedule dto
     * @return the schedule
     */
    public static Schedule toEntity(ScheduleDTO scheduleDTO) {
        return new Schedule(scheduleDTO.getSnsu(),scheduleDTO.getVc(),scheduleDTO.getVaccine(), scheduleDTO.getVaccineDate(), scheduleDTO.getVaccineTimeSlot(), scheduleDTO.getVaccineAdministrationProcess());
    }

    /**
     * To entity list list.
     *
     * @param scheduleDTOList the schedule dto list
     * @return the list
     */
    public static List<Schedule> toEntityList(List<ScheduleDTO> scheduleDTOList) {
        List<Schedule> scheduleList = ScheduleMapper.toEntityList(scheduleDTOList);

        for (ScheduleDTO scheduleDTO : scheduleDTOList) {
            scheduleList.add(toEntity(scheduleDTO));
        }

        return scheduleList;
    }

}
