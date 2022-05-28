package app.ui.console;

import app.DTO.VaccinationCenterDTO;
import app.DTO.VaccineDTO;
import app.controller.UserScheduleVaccineController;
import app.domain.model.SNSUser;
import app.domain.model.VaccinationCenter;
import app.domain.model.Vaccine;
import app.ui.console.utils.Utils;

import java.util.List;

public class UserScheduleVaccineUI implements Runnable{
    private UserScheduleVaccineController ctrl;


    public UserScheduleVaccineUI(){
        ctrl = new UserScheduleVaccineController();
    }
    @Override
    public void run() {

        if (ctrl.createSchedule(ctrl.userLogin(),askVacCenter(),askVaccine(),askSlot())){
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



    public VaccinationCenterDTO askVacCenter(){
        List<VaccinationCenterDTO> vacCenters = this.ctrl.showVacCenter();
        return (VaccinationCenterDTO) Utils.showAndSelectOne(vacCenters, "Choose a vaccination center.");
    }

    public VaccineDTO askVaccine(){
        List<VaccineDTO> vaccine = this.ctrl.showVaccine();
        return (VaccineDTO) Utils.showAndSelectOne(vaccine, "Choose a vaccine.");
    }

    public String askSlot(){
        return "a";//Utils.showAndSelectOne(,"Choose a time slot to be Vaccinated.");
    }

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
