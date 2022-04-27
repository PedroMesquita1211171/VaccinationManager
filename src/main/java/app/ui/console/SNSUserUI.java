package app.ui.console;

import app.controller.SpecifyNewSNSUserController;
import app.ui.console.utils.Utils;

public class SNSUserUI implements Runnable{

    private SpecifyNewSNSUserController ctrl;

    public SNSUserUI() {
        ctrl = new SpecifyNewSNSUserController();
    }

    @Override
    public void run() {
        if (ctrl.createSNSUser(askname(), askaddress(), askgenderoption(), askPhoneNumber(), askEmail(), askBirthDate(), askSNSNumber(), askCCNumber())) {;

            System.out.println(ctrl.showSNSUser());

            String opt = SaveOrNot();

             if(opt.equalsIgnoreCase("yes")){
                 ctrl.saveSNSUser();
                     System.out.println("SNS User saved successfully");
             }else if(opt.equalsIgnoreCase("no")){
                 System.out.println("SNS User not saved");
             }else{
                 System.out.println("\nInvalid option\nSNS User not saved");
             }
         }
         }

    public String askname(){
        return Utils.readLineFromConsole("Enter the name of the user: ");
    }
    public String askaddress(){
        return Utils.readLineFromConsole("Enter the address of the user: ");
    }
    public String askgenderoption() {
        System.out.println("\n1. Male");
        System.out.println("2. Female");
        System.out.println("3. Non-binary");
        System.out.println("other - I don't want to specify");
        return Utils.readLineFromConsole("Select intended option: ");
    }

    public String askPhoneNumber(){
        return Utils.readLineFromConsole("Enter the phone number of the user: ");
    }

    public String askEmail(){
        return Utils.readLineFromConsole("Enter the email of the user: ");
    }

    public String askBirthDate(){
        return Utils.readLineFromConsole("Enter the birth date of the user: ");
    }

    public String askSNSNumber(){
        return Utils.readLineFromConsole("Enter the SNS number of the user: ");
    }

    public String askCCNumber(){
        return Utils.readLineFromConsole("Enter the citizen card number of the user: ");
    }

    public String SaveOrNot(){

      //  System.out.println(ctrl.showSNSUser());

        String opt;
        opt = Utils.readLineFromConsole("Save SNS User? (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        }else{
            return "error";
        }

    }
}
