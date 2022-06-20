package app.domain.Store;

import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.VaccinationCenterDTO;
import app.domain.model.SNSUser;
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

    /**
     * Gets SNS User in the waiting room by its sns number.
     *
     * @param snsNumber the sns number
     * @return the SNS User in the waiting room
     */
    public SNSUser getSNSUserInTheWaitingRoomByItsSNSNumber(String snsNumber) {
        for (WaitingRoom wt : this.waitingRoomList) {
            if (wt.getSchedule().getSnsu().getSNSNumber().equals(snsNumber)) {
                return wt.getSchedule().getSnsu();
            }
        }
        throw new IllegalArgumentException("There is no SNS User in the waiting room with such SNS Number");
    }

    /**
     * Gets Vaccination Center of sns user in the waiting room by its sns number.
     *
     * @param snsNumber the sns number
     * @return the Vaccination Center of sns user in the waiting room
     */
    public VaccinationCenter getVaccinationCenterBySNSNumber(String snsNumber) {
        for (WaitingRoom wt : this.waitingRoomList) {
            if (wt.getSchedule().getSnsu().getSNSNumber().equals(snsNumber)) {
                return wt.getVaccinationCenter();
            }
        }
        throw new IllegalArgumentException("There is no SNS User in the waiting room with such SNS Number");
    }

    public void setWaitingRoomList(List<WaitingRoom> readObject) {
        for (WaitingRoom w : readObject) {
            this.waitingRoomList.add(w);
        }

        }
        public int vaccinationsperCenter(VaccinationCenter vaccinationCenter){
            int count = 0;
            for (WaitingRoom w:waitingRoomList) {
                if (w.getVaccinationCenter().equals(vaccinationCenter)){
                    count++;
                }
            }
            return count;
        }
    }
