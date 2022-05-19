package app.ui.console;

import app.controller.App;
import app.controller.RegisterEmployeeController;
import app.controller.UserScheduleVaccineController;
import app.domain.model.ScheduleVaccine;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserScheduleVaccineUI implements Runnable{
    private UserScheduleVaccineController ctrl;

    public UserScheduleVaccineUI(){
        ctrl = new UserScheduleVaccineController();
    }
    @Override
    public void run() {

        if (ctrl.createSchedule(askAddress(),askVaccine(),askHour())){
            String opt= SaveOrNot();

            if(opt.equalsIgnoreCase("yes")){
                ctrl.saveSchedule();

                System.out.println("Vaccine scheduled successfully.");
            }else if(opt.equalsIgnoreCase("no")){
                System.out.println("Vaccine not scheduled.");
            }else{
                System.out.println("\nInvalid option\nVaccine not scheduled.");
            }
        }
    }

    public String askAddress(){return Utils.readLineFromConsole("Insert vaccination center address");}

    public String askVaccine(){return Utils.readLineFromConsole("Insert vacccine name:");}

    public String askHour(){return Utils.readLineFromConsole("Insert hour of vaccine admnisitration:");}

    public String SaveOrNot(){
        String opt;
        opt = Utils.readLineFromConsole("Confirm vaccine scheduling (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        }else{
            return "error";
        }

    }
}
