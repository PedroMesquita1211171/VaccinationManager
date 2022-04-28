package app.ui.console;

import app.controller.SpecifyNewVaccineTypeController;
import app.ui.console.utils.Utils;

public class VaccineTypeUI implements Runnable {

    private final SpecifyNewVaccineTypeController ctrl ;

    public VaccineTypeUI() {
       ctrl = new SpecifyNewVaccineTypeController();
    }

    @Override
    public void run() {
        if (ctrl.createVaccineType(askCode(), askDesignation(), askWhoId())) {

            System.out.println(ctrl.showVaccineType());

            String opt = SaveOrNot();

            if(opt.equalsIgnoreCase("yes")){
                ctrl.addVaccineType();
                    System.out.println("Vaccine Type saved successfully");
            }else if(opt.equalsIgnoreCase("no")){
                System.out.println("Vaccine Type not saved");
            }else{
                System.out.println("\nInvalid option\nVaccine Type not saved");
            }
        }else{
            System.out.println("\nVaccine Type not saved since it already exists or data is invalid\n");
        }

    }

    public String askCode(){
       return Utils.readLineFromConsole("Enter Vaccine Type Code");
    }

    public String askDesignation(){
       return Utils.readLineFromConsole("Enter Vaccine Type Designation");
    }

    public String askWhoId(){
       return Utils.readLineFromConsole("Enter Vaccine Type Who Id");
    }

    public String SaveOrNot(){
        String opt;
            opt = Utils.readLineFromConsole("Save Vaccine Type? (yes/no)");
            if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
                return opt;
            }else{
               return "error";
            }

    }

}
