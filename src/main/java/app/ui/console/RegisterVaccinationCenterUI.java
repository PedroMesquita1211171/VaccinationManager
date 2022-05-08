package app.ui.console;

import app.controller.SpecifyNewVaccinationCenterController;
import app.ui.console.utils.Utils;

/**
 * @author Luís Monteiro - 1211250
 */
public class RegisterVaccinationCenterUI implements Runnable{
    /**
     * Controller used to specify a new vaccination center.
     */
    private SpecifyNewVaccinationCenterController ctrl ;

    /**
     * Instantiates a new Register vaccination center controller.
     */
    public RegisterVaccinationCenterUI(){

        ctrl= new SpecifyNewVaccinationCenterController();
    }
    public void run() {

        int typeOfCenter;
        System.out.println("\n1: Mass Community Vaccination Center\n2: Healthcare Center\n");
        int optRole = Utils.readIntegerFromConsole("Whats The Option?");

        try{
            switch(optRole) {
                case 1:
                    typeOfCenter = 1;
                    break;
                case 2:
                    typeOfCenter = 2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type of center");
            }
            if(typeOfCenter==2){ if(ctrl.createHealthcareCenter(askAddress(), askEmailAdress(),askPhoneNumber(),askFaxNumber(),askWebsiteAddress(), askOpeningHours(), askClosingHours(),askSlotDuration(),askMaxVaccines(),askCoordinator(),askAges(),askArs())){

                String opt= SaveOrNot();

                if(opt.equalsIgnoreCase("yes")){
                    ctrl.addVaccinationCenter();

                    System.out.println("Vaccination Center saved successfully");
                }else if(opt.equalsIgnoreCase("no")){
                    System.out.println("Vaccination Center not saved");
                }else{
                    System.out.println("\nInvalid option\nVaccination center not saved");
                }
            }else{
                System.out.println("\nVaccination Center not saved since it already exists or data is invalid\n");
            }

            }else  if(ctrl.createCommunityCenter(askAddress(), askEmailAdress(),askPhoneNumber(),askFaxNumber(),askWebsiteAddress(), askOpeningHours(), askClosingHours(),askSlotDuration(),askMaxVaccines(),askCoordinator())){

                String opt= SaveOrNot();

                if(opt.equalsIgnoreCase("yes")){
                    ctrl.addVaccinationCenter();

                    System.out.println("Vaccination Center saved successfully");
                }else if(opt.equalsIgnoreCase("no")){
                    System.out.println("Vaccination Center not saved");
                }else{
                    System.out.println("\nInvalid option\nVaccination center not saved");
                }
            }else{
                System.out.println("\nVaccination Center not saved since it already exists or data is invalid\n");
            }
        }catch(NumberFormatException nfe){
            System.out.println("Invalid type of center");
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }

    /**
     * Asks adress.
     *
     * @return adress string
     */
    public String askAddress(){return Utils.readLineFromConsole("Address: ");}

    /**
     * Asks email.
     *
     * @return email string
     */
    public String askEmailAdress(){return Utils.readLineFromConsole("E-mail: ");}

    /**
     * Asks phone number.
     *
     * @return phone number
     */
    public String askPhoneNumber(){return Utils.readLineFromConsole("Phone Number: ");}

    /**
     * Asks fax number.
     *
     * @return fax number.
     */
    public String askFaxNumber(){return Utils.readLineFromConsole("Fax number: ");}

    /**
     * Asks website address.
     *
     * @return website address
     */
    public String askWebsiteAddress(){return Utils.readLineFromConsole("Website Address: ");}

    /**
     * Asks Opening hours.
     *
     * @return opening hours
     */
    public String askOpeningHours(){return Utils.readLineFromConsole("Opening hours: ");}

    /**
     * Asks Closing hours.
     *
     * @return closing hours
     */
    public String askClosingHours(){return Utils.readLineFromConsole("Closing hours: ");}

    /**
     * Asks Slot duration.
     *
     * @return slot duration
     */
    public int askSlotDuration(){return Utils.readIntegerFromConsole("Slot duration: ");}

    /**
     * Asks max vaccines.
     *
     * @return max vaccines
     */
    public int askMaxVaccines(){return Utils.readIntegerFromConsole("Max vaccines: ");}

    /**
     * Asks Opening hours.
     *
     * @return opening hours
     */
    public String askCoordinator(){return Utils.readLineFromConsole("Coordinator: ");}

    /**
     * Asks AGES.
     *
     * @return AGES string
     */
    public String askAges(){return Utils.readLineFromConsole("AGES: ");}

    /**
     * Asks ARS.
     *
     * @return ARS string
     */
    public String askArs(){return Utils.readLineFromConsole("ARS: ");}


    /**
     * Save or not data.
     *
     * @return yes, no or error
     */
    public String SaveOrNot(){
        String opt;
        opt = Utils.readLineFromConsole("Register Vaccination Center (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        }else{
            return "error";
        }

    }
}
