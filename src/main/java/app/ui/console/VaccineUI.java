package app.ui.console;

import app.controller.SpecifyNewVaccineController;
import app.ui.console.utils.Utils;

/**
 * The type Vaccine ui.
 *
 * @author Pedro Mesquita - 1211171
 */
public class VaccineUI implements Runnable {

        private SpecifyNewVaccineController controller;

    /**
     * Instantiates a new controller to use in the UI.
     */
    public VaccineUI() { controller = new SpecifyNewVaccineController(); }


    @Override
    public void run() {
        try{
            if (controller.createVaccine(askName(), askID(), askBrand(), askDoses(), askDosage(), askRecovery(), askDoseInterval())) {

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
        }catch(NumberFormatException e){
            System.out.println("Numeric fields must be numeric");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Ask name string.
     *
     * @return the string
     */
    public String askName(){
        return Utils.readLineFromConsole("Enter Vaccine Name");
    }

    /**
     * Ask id int.
     *
     * @return the int
     */
    public int askID(){ return Utils.readIntegerFromConsole("Enter Vaccine ID"); }

    /**
     * Ask brand string.
     *
     * @return the string
     */
    public String askBrand(){return Utils.readLineFromConsole("Enter Vaccine Brand");}

    /**
     * Ask doses int.
     *
     * @return the int
     */
    public int askDoses(){
        return Utils.readIntegerFromConsole("Enter Vaccine's Number of Doses");
    }
    public int askRecovery(){
        return Utils.readIntegerFromConsole("Enter Vaccine's Recovery Period");
    }

    /**
     * Ask dose interval int.
     *
     * @return the int
     */
    public int askDoseInterval(){
        return Utils.readIntegerFromConsole("Enter Vaccine's Dose Interval");
    }

    /**
     * Save or not string.
     *
     * @return the string
     */
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
