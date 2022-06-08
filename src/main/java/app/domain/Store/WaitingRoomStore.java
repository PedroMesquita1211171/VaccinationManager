package app.domain.Store;

import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.VaccinationCenterDTO;
import app.domain.model.Schedule;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.domain.model.WaitingRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Waiting room store.
 */
public class WaitingRoomStore {
    private List<WaitingRoom> waitingRoomList;

    /**
     * Instantiates a new Waiting room store.
     */
    public WaitingRoomStore() {
        this.waitingRoomList = new ArrayList<>();
    }

    /**
     * Create waiting room waiting room.
     *
     * @param vaccinationCenter the vaccination center
     * @param schedule          the schedule
     * @param arrivalHour       the arrival hour
     * @return the waiting room
     */
    public WaitingRoom createWaitingRoom(VaccinationCenter vaccinationCenter, Schedule schedule, Tempo arrivalHour) {
        return new WaitingRoom(vaccinationCenter, schedule, arrivalHour);
    }

    /**
     * Validate waiting room boolean.
     *
     * @param wt the wt
     * @return the boolean
     */
    public boolean validateWaitingRoom(WaitingRoom wt) {
        if (wt == null) return false;
        return !waitingRoomList.contains(wt);
    }

    /**
     * Save waiting room boolean.
     *
     * @param wt the wt
     * @return the boolean
     */
    public boolean saveWaitingRoom(WaitingRoom wt) {
        if (validateWaitingRoom(wt)) {
            waitingRoomList.add(wt);
            return true;
        }
        return false;
    }

    /**
     * Gets waiting room list.
     *
     * @return the waiting room list
     */
    public List<WaitingRoom> getWaitingRoomList() {
        return waitingRoomList;
    }

    /**
     * Gets waiting room list of a vaccination center.
     *
     * @param vaccinationCenter the vaccination center
     * @return the waiting room list
     */
    public List<WaitingRoom> getWaitingRoomListOfAVaccinationCenter(VaccinationCenterDTO vaccinationCenter) {
        VaccinationCenter vc = VaccinationCenterMapper.toEntity(vaccinationCenter);
        List<WaitingRoom> waitingRoomList = new ArrayList<>();
        for (WaitingRoom wt : this.waitingRoomList) {
            if (wt.getVaccinationCenter().equals(vc)) {
                waitingRoomList.add(wt);
            }
        }
        return waitingRoomList;
    }

}
