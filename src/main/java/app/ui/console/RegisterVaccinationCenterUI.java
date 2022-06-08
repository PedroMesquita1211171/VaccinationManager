package app.ui.console;

import app.DTO.EmployeeDTO;
import app.controller.RegisterVaccinationCenterController;
import app.domain.model.VaccinationCenter;
import app.domain.model.VaccinationCenterDependencies.Tempo;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.regex.Pattern;

public class RegisterVaccinationCenterUI implements Runnable {

    private RegisterVaccinationCenterController ctrl;

    public RegisterVaccinationCenterUI() {
        ctrl = new RegisterVaccinationCenterController();
    }


    @Override
    public void run() {
        try{
            //0 - exit, 1 - Mass Community Vaccination Center, 2 - HealthCare Center
            String typeCenter = askTypeCenter();
            String name = askName();
            String address = askAddress();
            String emailaddress = askEmailAddress();
            String phonenumber = askPhoneNumber();
            String faxNumber = askFaxNumber();
            String website = askWebsite();
            String ages= null, ars = null, region = null;
            if(typeCenter.equals("2")){
                ages = askAges();
                ars = askArs();
                region = askRegion();
            }
            Tempo opHours = askOPHour();
            Tempo clHours = askCLHour(opHours);
            int slotDuration = askSlotDuration();
            int maxVaccines = askMaxVaccines();
            EmployeeDTO centerCoordinator = selectCenterCoordinator();

            if(typeCenter.equals("2")){
                if(ctrl.createVaccinationCenter(name,address,emailaddress,phonenumber,faxNumber,website,opHours,clHours,slotDuration,maxVaccines,centerCoordinator,ages,ars,region)){

                    String opt= SaveOrNot();

                    if(opt.equalsIgnoreCase("yes")){
                        if(ctrl.saveVaccinationCenter())
                            System.out.println("Vaccination Center saved successfully");
                    }else if(opt.equalsIgnoreCase("no")){
                        System.out.println("Vaccination Center not saved");
                    }else{
                        System.out.println("\nInvalid option\nVaccination center not saved");
                    }
                }else{
                    System.out.println("\nVaccination Center not saved since it already exists or data is invalid\n");
                }
            }else if(typeCenter.equals("1")){
                if(ctrl.createVaccinationCenter(name,address,emailaddress,phonenumber,faxNumber,website,opHours,clHours,slotDuration,maxVaccines,centerCoordinator)){

                    System.out.println(ctrl.getVaccinationCenter());
                    String opt= SaveOrNot();

                    if(opt.equalsIgnoreCase("yes")){
                        if(ctrl.saveVaccinationCenter())
                            System.out.println("Vaccination Center saved successfully");
                    }else if(opt.equalsIgnoreCase("no")){
                        System.out.println("Vaccination Center not saved");
                    }else{
                        System.out.println("\nInvalid option\nVaccination center not saved");
                    }
                }else{
                    System.out.println("\nVaccination Center not saved since it already exists or data is invalid\n");
                }
            }else{
                throw new IllegalArgumentException("\nInvalid type of center!\n");
            }


        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("\nSomething went wrong!\nBack to the main menu!\n");
        }
    }

    private String askWebsite() {
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nWebsite: ");

        if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");

        if (input.length() > 3 && input.length() < 50) {
            return input;
        } else {
            System.out.println("\nInvalid website!\n");
            return askWebsite();
        }
    }

    private String askFaxNumber() {
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nFax number: ");

        if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");

        if (input== null || input.isEmpty()){
            System.out.println("\nFax number can't be null or empty!\n");
            return askFaxNumber();
        }else if (input.length()!=9 && input.charAt(0)!='2'){
            System.out.println("\nInvalid fax number format!\n");
            return askFaxNumber();
        }else{
            return input;
        }
    }

    private String askName() {
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nName: ");

        if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");

        if (input.length() > 3&&input.length() < 50) {
            return input;
        } else {
            System.out.println("\nInvalid name!\n");
            return askName();
        }
    }

    public String askAddress() {
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nAddress: ");

        if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");

        if (input.length() > 3 && input.length() < 50) {
            return input;
        } else {
            System.out.println("\nInvalid address!\n");
            return askAddress();
        }
    }

    public String askEmailAddress() {
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nEmail address: ");
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(input).matches()&&!input.isEmpty()) {
            return input;
        }else if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");
        else {
            System.out.println("\nInvalid email address");
            return askEmailAddress();
        }
    }
    public String askAges(){
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nAGES: ");
        if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");
        if (input!=null&&!input.isEmpty())
            return input;
        else{
            System.out.println("Invalid AGES");
            return askAges();
        }
    }
    public String askArs(){
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nARS: ");
        if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");
        if (input!=null&&!input.isEmpty())
            return input;
        else{
            System.out.println("Invalid AGES");
            return askArs();
        }
    }
    public String askPhoneNumber(){
        String input = Utils.readLineFromConsole("\nPress 0 to exit\nPhone number: ");
        if(input.length()==9&&input.charAt(0) == '9')
            return input;
        else if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");
        else {
            System.out.println("\nInvalid phone number");
            return askEmailAddress();
        }
    }

        public String askTypeCenter () {
            System.out.println("\n1: Mass Community Vaccination Center\n2: Healthcare Center\n");

            String input = Utils.readLineFromConsole("\nPress 0 to exit\nType of center: ");

            if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");

            if (input.equals("1") || input.equals("2")) {
                return input;
            } else {
                System.out.println("\nInvalid type of center!\n");
                return askTypeCenter();
            }
        }
        public String askRegion(){
            String input = Utils.readLineFromConsole("\nPress 0 to exit\nRegion: ");

            if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");

            if (input.length() > 3&&input.length() < 50) {
                return input;
            } else {
                System.out.println("\nInvalid region!\n");
                return askRegion();
            }
        }
        public int askMaxVaccines(){

             try {
                 String input = Utils.readLineFromConsole("\nPress 0 to exit\nMax vaccines: ");
                 if (input.equals("0")) throw new IllegalArgumentException("\nReturning to main Menu...\n");
                 return Integer.parseInt(input);
             }catch (NumberFormatException e){
                 System.out.println("\nInvalid max vaccines!\nInput must be a number!\n");
                 return askMaxVaccines();
             }
        }

        public Tempo askOPHour() {
            String input = Utils.readLineFromConsole("\nPress 0 to exit\nOpening hour(HH:MM): ");
            String[] parts = input.split(":");

            if (input.equals("0")){

                throw new IllegalArgumentException("\nReturning to main Menu...\n");

            } else if (parts.length == 2 && parts[0].length() == 2 && parts[1].length() == 2) {

                    try {
                        if(parts[0].charAt(0)=='0'){
                            parts[0] = parts[0].substring(1);
                        }
                        if(parts[1].charAt(0)=='0'){
                            parts[1] = parts[1].substring(1);
                        }
                        return new Tempo(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("\nIncorrect format!\n");
                        return askOPHour();
                    }

            } else {
                System.out.println("\nIncorrect format!\n");
                return askOPHour();
            }
        }

        public Tempo askCLHour(Tempo OPHour) {
            String input = Utils.readLineFromConsole("\nPress 0 to exit\nClosing hour(HH:MM): ");
            String[] parts = input.split(":");

            if (input.equals("0")){

                throw new IllegalArgumentException("\nReturning to main Menu...\n");

            } else if (parts.length == 2 && parts[0].length() == 2 && parts[1].length() == 2 && new Tempo(Integer.parseInt(parts[0]), Integer.parseInt(parts[0])).isMaior(OPHour)) {

                try {
                    if(parts[0].charAt(0)=='0'){
                        parts[0] = parts[0].substring(1);
                    }
                    if(parts[1].charAt(0)=='0'){
                        parts[1] = parts[1].substring(1);
                    }
                    return new Tempo(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                } catch (NumberFormatException e) {
                    System.out.println("\nIncorrect format!\n");
                    return askCLHour(OPHour);
                }

            } else {
                System.out.println("\nIncorrect format!\n");
                return askCLHour(OPHour);
            }
        }
        public EmployeeDTO selectCenterCoordinator(){
            List<EmployeeDTO> centerCoordinators = ctrl.centerCoordinatorsList();
          int index = Utils.showAndSelectIndex(centerCoordinators,"\nSelect a Center Coordinator: ");

          if(index == -1) throw new IllegalArgumentException("\nReturning to main Menu...\n");

          if( index>=0 && index< centerCoordinators.size() ){
              return centerCoordinators.get(index);
          }else{
              System.out.println("\nInvalid index!\n");
              return selectCenterCoordinator();
          }
    }
    public int askSlotDuration(){
        try{
            String slotDuration = Utils.readLineFromConsole("\nPress 0 to exit\nSlot duration(in minutes/a number): ");
            int slotdurint = Integer.parseInt(slotDuration);
            if(slotDuration == "0"){
                throw new IllegalArgumentException("\nReturning to main Menu...\n");
            }else if(slotdurint>0&&slotdurint<60){
                return slotdurint;
            }else{
                System.out.println("\nInvalid slot duration!\nIt must be specified in between 1 and 60 minutes!\n");
                return askSlotDuration();
            }
        }catch (NumberFormatException e){
            System.out.println("\nInvalid format!\n");
            return askSlotDuration();
        }
    }
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

