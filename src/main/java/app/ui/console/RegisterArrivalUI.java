package app.ui.console;

import app.DTO.Mappers.VaccinationCenterMapper;
import app.DTO.ScheduleDTO;
import app.DTO.VaccinationCenterDTO;
import app.controller.WaitingRoomController;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.ui.console.utils.Utils;

import java.util.List;

/**
 * The type Register arrival ui.
 */
public class RegisterArrivalUI implements Runnable{

    private WaitingRoomController ctrl;

    /**
     * Instantiates a new Register arrival ui.
     */
    public RegisterArrivalUI(){
        this.ctrl = new WaitingRoomController();
    }


    @Override
    public void run() {

        try{
            ScheduleDTO sc = askSchedule();

            VaccinationCenterDTO vc = VaccinationCenterMapper.toDTO(sc.getVc());

            Tempo ah = Tempo.tempoAtual();

            if(ctrl.createWaitingRoom(vc,sc,ah)){
                System.out.println(ctrl.showWaitingRoom());

                String opt = askConfirmation();
                if(opt.equalsIgnoreCase("yes")||opt.equalsIgnoreCase("y")){
                    if(ctrl.saveWaitingRoom()){
                        System.out.println("\nSuccessfully introduced Patient into Waiting Room!\n");
                    }else{
                        System.out.println("\nAn Error Occurred.\n");
                    }
                }else{
                    System.out.println("\nPatient was not added into the waiting room list.\nReturning to main menu...\n");
                }
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    private String askConfirmation() {
        String opt;
        opt = Utils.readLineFromConsole("Register Arrival of this SNS User into the waiting room?\n");
        if(opt.equalsIgnoreCase("yes")||opt.equalsIgnoreCase("y") || opt.equalsIgnoreCase("no")||opt.equalsIgnoreCase("n")){
            return opt;
        }else{
            System.out.println("Invalid Option in yes/no block\nTry again\n");
            return askConfirmation();
        }
    }

    private Tempo askArrival() {
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nArrival Hour(HH:MM): ");
        String[] parts = input.split(":");

        if (input.equals("0")){

            throw new IllegalArgumentException("\nReturning to main Menu...\n");

        } else if (parts.length == 2 && parts[0].length() == 2 && parts[1].length() == 2) {

            try {
                if(parts[0].charAt(0)=='0'){
                    parts[0] = parts[0].substring(1);
                }
                if(parts[1].charAt(0)=='0'){
                    parts[1] = parts[1].substring(1);
                }
                return new Tempo(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            } catch (NumberFormatException e) {
                System.out.println("\nIncorrect format!\n");
                return askArrival();
            }

        } else {
            System.out.println("\nIncorrect format!\n");
            return askArrival();
        }
    }

    private ScheduleDTO askSchedule() {
        List<ScheduleDTO> list = ctrl.showSchedules();
        int index = Utils.showAndSelectIndex(list, "Existent schedules for today\n");
        if (index > -1 && index < list.size()) {
            return list.get(index);
        }
        throw new IllegalArgumentException("Invalid index");
    }
}
