package app.ui.console;

import app.DTO.VaccinationCenterDTO;
import app.DTO.WaitingRoomDTO;
import app.controller.ListSNSUsersInWaitingRoomController;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListSNSUsersInWaitingRoomUI implements Runnable {

    private ListSNSUsersInWaitingRoomController ctrl;

    public ListSNSUsersInWaitingRoomUI() {
        this.ctrl = new ListSNSUsersInWaitingRoomController();
    }

    @Override
    public void run() {

        try{
            VaccinationCenterDTO vc = askCenter();

            List<WaitingRoomDTO> waitingRooms = ctrl.getWaitingRoomUsers(vc);

            if(waitingRooms.isEmpty()) {
                System.out.println("\nNo users in waiting room.\nReturning to main menu...\n");
            } else {
                showWaitingRooms(waitingRooms);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void showWaitingRooms(List<WaitingRoomDTO> waitingRooms) {
        for (WaitingRoomDTO wt : waitingRooms) {
            System.out.println(wt);
        }
        Utils.readLineFromConsole("Press ENTER to continue...");
    }

    private VaccinationCenterDTO askCenter() {
        List<VaccinationCenterDTO> vcList = ctrl.getVaccinationCenters();
        int index = Utils.showAndSelectIndex(vcList, "Select a vaccination center: \n");
        if(index > -1 && index < vcList.size()) {
            return vcList.get(index);
        }
        throw new IllegalArgumentException("Invalid index");
    }
}
