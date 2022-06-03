package app.domain.Store;

import app.domain.model.WaitingRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Waiting room store.
 */
public class WaitingRoomStore {

    /**
     * The Waiting room.
     */
    public ArrayList<WaitingRoom> waitingRoom;

    /**
     * Instantiates a new Waiting room store.
     */
    public WaitingRoomStore() {
        this.waitingRoom = new ArrayList<>();
    }

    /**
     * Gets waiting room.
     *
     * @return the waiting room
     */
    public List<WaitingRoom> getWaitingRoom() {
        return new ArrayList<>(this.waitingRoom);
    }

    /**
     * Create waiting waiting room.
     *
     * @param arrivalDate   the arrival date
     * @param arrivalHour   the arrival hour
     * @param snsUserNumber the sns user number
     * @param scheduledHour the scheduled hour
     * @param centerName    the center name
     * @param vaccineName   the vaccine name
     * @return the waiting room
     */
    public WaitingRoom createWaiting(Date arrivalDate, Date arrivalHour,String snsUserNumber,Date scheduledHour,String centerName,String vaccineName) {
        return new WaitingRoom(arrivalDate,arrivalHour,snsUserNumber,scheduledHour,centerName,vaccineName);
    }

    /**
     * Validate waiting boolean.
     *
     * @param wait the wait
     * @return the boolean
     */
    public boolean validateWaiting(WaitingRoom wait) {
        if (waitingRoom.contains(wait)){
            return false;
        }
        return true;
    }

    /**
     * Add waiting boolean.
     *
     * @param wait the wait
     * @return the boolean
     */
    public boolean addWaiting(WaitingRoom wait) {
        if (!validateWaiting(wait)) {
            return false;
        }
        return this.waitingRoom.add(wait);
    }
}
