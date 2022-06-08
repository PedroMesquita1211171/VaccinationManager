package app.ui.console;

import app.controller.SpecifyNewVaccineTypeController;
import app.ui.console.utils.Utils;

/**
 * UI used to specify a new vaccine type.
 *
 * @author Henrique Pinto - 1211201
 */
public class SpecifyNewVaccineTypeUI implements Runnable {

    /**
     * Controller used to specify a new Vaccine Type.
     */
    private SpecifyNewVaccineTypeController ctrl ;

    public SpecifyNewVaccineTypeUI() {
       ctrl = new SpecifyNewVaccineTypeController();
    }

    /**
     * Runnable that is used to activate the UI.
     */

    @Override
    public void run() {

        try {
            if (ctrl.createVaccineType(askCode(), askDesignation(), askVaccineTechnology())) {

                System.out.println(ctrl.showVaccineType());

                String opt = SaveOrNot();

                if(opt.equalsIgnoreCase("yes")){
                    if(ctrl.saveVaccineType()){
                        System.out.println("Vaccine Type saved successfully");
                    }else{
                        System.out.println("Error saving Vaccine Type\nReturning to main menu\n");
                    }
                }else if(opt.equalsIgnoreCase("no")){
                    System.out.println("Vaccine Type not saved\nReturning to main menu\n");
                }else{
                    System.out.println("\nInvalid option\nVaccine Type not saved\nReturning to main menu\n");
                }
            }else{
                System.out.println("\nVaccine Type not saved since it already exists or data is invalid\n");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(NullPointerException e){
            System.out.println("Error. Returning to main menu");
        }



    }

    /**
     * Asks code.
     *
     * @return Vaccine Type code
     */
    public String askCode(){
       return Utils.readLineFromConsole("Enter Vaccine Type Code");
    }

    /**
     * Asks designation.
     *
     * @return Vaccine Type designation
     */
    public String askDesignation(){
       return Utils.readLineFromConsole("Enter Vaccine Type Designation");
    }

    /**
     * Asks whoId.
     *
     * @return Vaccine Type whoId
     */
    public String askVaccineTechnology(){
       return Utils.readLineFromConsole("Enter Vaccine Technology for given Type");
    }

    /**
     * Save or not data.
     *
     * @return yes, no or error
     */
    public String SaveOrNot(){
        String opt = Utils.readLineFromConsole("Save Vaccine Type? (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
                return opt;
            }else{
               return "error";
            }

    }

}
