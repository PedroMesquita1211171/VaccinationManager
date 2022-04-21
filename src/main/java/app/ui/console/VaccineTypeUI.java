package app.ui.console;

import app.VaccineRelated.VaccineType;
import app.controller.SpecifyNewVaccineTypeController;
import app.ui.console.utils.Utils;

public class VaccineTypeUI implements Runnable {

    public VaccineTypeUI() {
    }

    @Override
    public void run() {
        SpecifyNewVaccineTypeController controller = new SpecifyNewVaccineTypeController();
        controller.createVaccineType(askCode(), askDesignation(), askWhoId());

        if(SaveOrNot() == 'Y'){
            if(controller.saveVaccineType()) {
                System.out.println("Vaccine Type saved successfully");
            }else{
                System.out.println("Vaccine Type not saved since it already exists or invalid data");
            }
        }else if(SaveOrNot() == 'N'){
            System.out.println("Vaccine Type not saved");
        }else{
            System.out.println("Invalid input\nVaccine Type not saved");
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

    public char SaveOrNot(){
        return Utils.readLineFromConsole("Save Vaccine Type? (Y/N)").toUpperCase().charAt(0);
    }

}
