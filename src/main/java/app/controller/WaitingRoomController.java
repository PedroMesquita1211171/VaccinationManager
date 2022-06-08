package app.controller;

import app.DTO.Mappers.ScheduleMapper;
import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.Mappers.WaitingRoomMapper;
import app.DTO.ScheduleDTO;
import app.DTO.VaccinationCenterDTO;
import app.DTO.WaitingRoomDTO;
import app.domain.model.Company;
import app.domain.model.Schedule;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.model.WaitingRoom;

import java.util.List;

/**
 * The type Waiting room controller.
 */
public class WaitingRoomController {

    private Company company;
    private WaitingRoom wt;
    private Schedule schedule;

    /**
     * Instantiates a new Waiting room controller.
     */
    public WaitingRoomController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Waiting room controller.
     *
     * @param company the company
     */
    public WaitingRoomController(Company company){
        this.company = company;
    }

    /**
     * Create waiting room boolean.
     *
     * @param vc the vc
     * @param sc the sc
     * @param ah the ah
     * @return the boolean
     */
    public boolean createWaitingRoom(VaccinationCenterDTO vc, ScheduleDTO sc, Tempo ah){
        schedule = ScheduleMapper.toEntity(sc);
        this.wt = this.company.getWaitingRoomStore().createWaitingRoom(VaccinationCenterMapper.toEntity(vc), schedule,ah);


        return this.company.getWaitingRoomStore().validateWaitingRoom(this.wt);
    }


    /**
     * Save waiting room boolean.
     *
     * @return the boolean
     */
    public boolean saveWaitingRoom(){
        if(this.company.getWaitingRoomStore().saveWaitingRoom(this.wt)){
            this.company.getScheduleStore().removeSchedule(schedule);
            return true;
        }
        return false;
    }

    /**
     * Show schedules list.
     *
     * @return the list
     */
    public List<ScheduleDTO> showSchedules(){
        return ScheduleMapper.toDTOList(this.company.getScheduleStore().showTodaySchedules());
    }

    /**
     * Show waiting room waiting room dto.
     *
     * @return the waiting room dto
     */
    public WaitingRoomDTO showWaitingRoom(){
        return WaitingRoomMapper.toDTO(this.wt);
    }

}
