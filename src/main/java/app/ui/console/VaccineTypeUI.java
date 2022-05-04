package app.ui.console;

import app.controller.SpecifyNewVaccineTypeController;
import app.ui.console.utils.Utils;

/**
 * UI used to specify a new vaccine type.
 *
 * @author Henrique Pinto - 1211201
 */
public class VaccineTypeUI implements Runnable {

    /**
     * Controller used to specify a new Vaccine Type.
     */
    private SpecifyNewVaccineTypeController ctrl ;

    public VaccineTypeUI() {
       ctrl = new SpecifyNewVaccineTypeController();
    }

    /**
     * Runnable that is used to activate the UI.
     */

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
    public String askWhoId(){
       return Utils.readLineFromConsole("Enter Vaccine Type Who Id");
    }

    /**
     * Save or not data.
     *
     * @return yes, no or error
     */
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
