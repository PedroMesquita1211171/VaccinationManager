package app.ui.console;

import app.controller.App;
import app.controller.SpecifyNewEmployeeController;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.AuthFacade;

public class
RegisterEmployeeUi implements Runnable{

    private SpecifyNewEmployeeController ctrl ;
    private final AuthFacade authFacade;

    public RegisterEmployeeUi(){
        ctrl= new SpecifyNewEmployeeController();
        authFacade = App.getInstance().getCompany().getAuthFacade();
    }

    public void run() {

        String role;
        System.out.println("\n1: Receptionist\n2: Center Coordinator\n3: Nurse\n");
        int optRole = Utils.readIntegerFromConsole("Whats The Option?");

        try{
            switch(optRole) {
                case 1:
                    role = Constants.ROLE_RECEPTIONIST;
                    break;
                case 2:
                    role = Constants.ROLE_CENTER_CORDINATOR;
                    break;
                case 3:
                    role = Constants.ROLE_NURSE;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Role");
            }


            if(ctrl.createEmployee(askName(), askEmail(),askAddress(),askPhoneNumber(),askCitizenCard(),askEmployeeID(), role)){

                String opt= SaveOrNot();

                if(opt.equalsIgnoreCase("yes")){
                    ctrl.addEmployee();

                    System.out.println("Employee saved successfully");
                }else if(opt.equalsIgnoreCase("no")){
                    System.out.println("Employee Type not saved");
                }else{
                    System.out.println("\nInvalid option\nEmployee not saved");
                }
            }else{
                System.out.println("\nEmployee not saved since it already exists or data is invalid\n");
            }
        }catch(NumberFormatException nfe){
            System.out.println("Invalid Role");
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }

    public String askName(){
        return Utils.readLineFromConsole("Name?");
    }
    public String askEmail(){return Utils.readLineFromConsole("E-mail: ");}
    public String askAddress(){return Utils.readLineFromConsole("Address: ");}
    public String askPhoneNumber(){return Utils.readLineFromConsole("Phone Number: ");}
    public String askCitizenCard(){return Utils.readLineFromConsole("Citizen Card Number: ");}
    public int askEmployeeID(){return Utils.readIntegerFromConsole("Employee ID: ");}

    public String SaveOrNot(){
        String opt;
        opt = Utils.readLineFromConsole("Register Employee (yes/no)");
        if(opt.equalsIgnoreCase("yes") || opt.equalsIgnoreCase("no")){
            return opt;
        }else{
            return "error";
        }

    }

}
