package app.ui.console;

import app.controller.SpecifyNewVaccineController;
import app.ui.console.utils.Utils;

public class VaccineUI implements Runnable {

        private SpecifyNewVaccineController controller;
        public VaccineUI() {controller = new SpecifyNewVaccineController();}


    @Override
    public void run() {
        if (controller.createVaccine(askName(), askID(), askDoses(), askRecovery(), askDoseInterval())) {

            System.out.println(controller.showVaccine());

            String opt = SaveOrNot();

            if(opt.equalsIgnoreCase("yes")){
                controller.addVaccine();
                System.out.println("Vaccine saved successfully");
            }else if(opt.equalsIgnoreCase("no")){
                System.out.println("Vaccine not saved");
            }else{
                System.out.println("\nInvalid option\nVaccine not saved");
            }
        }else{
            System.out.println("\nVaccine not saved since it already exists or data is invalid\n");
        }

    }

    public String askName(){
        return Utils.readLineFromConsole("Enter Vaccine Name");
    }
    public int askID(){ return Utils.readIntegerFromConsole("Enter Vaccine ID"); }
    public int askDoses(){
        return Utils.readIntegerFromConsole("Enter Vaccine's Number of Doses");
    }
    public int askRecovery(){
        return Utils.readIntegerFromConsole("Enter Vaccine's Recovery Period");
    }
    public int askDoseInterval(){
        return Utils.readIntegerFromConsole("Enter Vaccine's Dose Interval");
    }

    public String SaveOrNot(){
        String opt;
        opt = Utils.readLineFromConsole("Save Vaccine? (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        } else {
            return "error";
        }
    }
}
