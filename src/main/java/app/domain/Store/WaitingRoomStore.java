package app.domain.Store;

import app.domain.model.WaitingRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaitingRoomStore {

    public ArrayList<WaitingRoom> waitingRoom;

    public WaitingRoomStore() {
        this.waitingRoom = new ArrayList<>();
    }

    public List<WaitingRoom> getWaitingRoom() {
        return new ArrayList<>(this.waitingRoom);
    }

    public WaitingRoom createWaiting(Date arrivalDate, Date arrivalHour,int snsUserNumber,Date scheduledHour,String centerName,String vaccineName) {
        return new WaitingRoom(arrivalDate,arrivalHour,snsUserNumber,scheduledHour,centerName,vaccineName);
    }

    public boolean validateWaiting(WaitingRoom wait) {
        if (waitingRoom.contains(wait)){
            return false;
        }
        return true;
    }
    public boolean addWaiting(WaitingRoom wait) {
        if (!validateWaiting(wait)) {
            return false;
        }
        return this.waitingRoom.add(wait);
    }
}
