package app.ui.console;

import app.DTO.VaccineTypeDTO;
import app.controller.SpecifyNewVaccineController;
import app.domain.model.VaccineDependencies.AdministrationProcess;
import app.domain.model.VaccineDependencies.AgeGroup;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SpecifyNewVaccineUI implements Runnable{

    private SpecifyNewVaccineController ctrl;
    private  List<AdministrationProcess> admp;
    private VaccineTypeDTO vaccineType;

   public SpecifyNewVaccineUI() {
       this.ctrl = new SpecifyNewVaccineController();
       this.admp= new ArrayList<>();

   }



    @Override
    public void run() {

       String confirmation = "no", brand, lotNumber;
       AgeGroup ageGroup;
       int doses, days;
       double dosage;


        try{
            do{
                int vaccineTypeIndex = Utils.showAndSelectIndex(ctrl.getVaccineTypes(), "Select a vaccine type");

                if(vaccineTypeIndex == -1){

                    throw new IllegalArgumentException("\nReturning to main Menu...\n");

                }else{

                    vaccineType = ctrl.getVaccineTypes().get(vaccineTypeIndex);
                    System.out.println("\n### Vaccine Type selected ###\n");
                    System.out.println(vaccineType);

                    brand = askBrand();

                    lotNumber = askLotNumber();


                    String confirmationAdmin = "continue";
                    int ageGroupIndex = 0;
                    int initAge = 0;
                    int endAge = 0;
                    do{
                        if(ageGroupIndex== 0){
                            initAge = askInitAge();
                            endAge = askEndAge(initAge);
                            ageGroup = new AgeGroup(initAge,endAge);
                        }else{
                            initAge = endAge + 1;
                            endAge = askEndAge(initAge);
                            ageGroup = new AgeGroup(initAge,endAge);
                        }

                        doses = askDosesPerGroup();
                        dosage = askDosagePerGroup();
                        days = askNumberOfDaysPerGroup();

                        confirmationAdmin = askConfirmationAdmin();

                        if(confirmationAdmin.equals("continue")){
                            admp.add(new AdministrationProcess(ageGroup,doses,dosage,days));
                            ageGroupIndex++;

                        }else{
                            admp.add(new AdministrationProcess(ageGroup,doses,dosage,days));
                            break;
                        }

                    }while(confirmationAdmin.equals("continue"));


                }
                if(ctrl.createVaccine(vaccineType, brand, lotNumber, admp)){
                    System.out.println(ctrl.getVaccine());
                    confirmation = askConfirmation();
                    if(confirmation.equalsIgnoreCase("y")|| confirmation.equalsIgnoreCase("yes")){
                        if(ctrl.saveVaccine()) {
                            System.out.println("\nVaccine saved successfully\n");
                        }else{
                            System.out.println("\nVaccine not saved since it is already on the System.\n");
                        }
                    }
                }




            }while(confirmation.equalsIgnoreCase("n")||confirmation.equalsIgnoreCase("no"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


   }


   // These functions serve to ask and confirmate inputs.
    public String askConfirmation(){
        String input = Utils.readLineFromConsole("Do you wish to save the Vaccine? (y/n): ");
        if(input.equalsIgnoreCase("y")||input.equalsIgnoreCase("yes")||input.equalsIgnoreCase("no")||input.equalsIgnoreCase("n")){
            return input;
        }else{
            System.out.println("\nInvalid input for confirmation!\n");
            return askConfirmation();
        }
    }
    public String askBrand(){
        String input = Utils.readLineFromConsole("Brand: ");
        if(input.length()>2){
            return input;
        }else{
            System.out.println("\nInvalid input for brand!\n");
            return askBrand();
        }
    }
    public String askLotNumber(){
        String input = Utils.readLineFromConsole("Lot Number: ");
        try{
            Long.parseLong(input);
            if(input.length()>2){
                return input;
            }else{
                System.out.println("\nInvalid input for lot number!\n");
                return askLotNumber();
            }
        }catch(NumberFormatException e){
            System.out.println("\nInvalid input for lot number!\n");
            return askLotNumber();
        }
    }
    public int askInitAge(){
        String input = Utils.readLineFromConsole("Initial age: ");
        try{
            int age = Integer.parseInt(input);
            if(age>0){
                return age;
            }else{
                System.out.println("\nInvalid input for age!\n");
                return askInitAge();
            }
        }catch(NumberFormatException e){
            System.out.println("\nInvalid input for age!\n");
            return askInitAge();
        }
    }
    public int askEndAge(int initAge){
        System.out.println("\nInitial age was defined as: " + initAge);
        String input = Utils.readLineFromConsole("End age: ");
        try{
            int age = Integer.parseInt(input);
            if(age>0&&age>initAge){
                return age;
            }else{
                System.out.println("\nInvalid input for age!\n");
                return askEndAge(initAge);
            }
        }catch(NumberFormatException e){
            System.out.println("\nInvalid input for age!\n");
            return askEndAge(initAge);
        }
    }
    public int askDosesPerGroup(){
        String input = Utils.readLineFromConsole("Doses per group: ");
        try{
            int doses = Integer.parseInt(input);
            if(doses>0&&doses<=100){
                return doses;
            }else{
                System.out.println("\nInvalid input for doses!\n");
                return askDosesPerGroup();
            }
        }catch(NumberFormatException e){
            System.out.println("\nInvalid input for doses!\n");
            return askDosesPerGroup();
        }
    }
    public double askDosagePerGroup(){
        String input = Utils.readLineFromConsole("Dosage per group: ");
        try{
            double dosage = Double.parseDouble(input);
            if(dosage>0&&dosage<=100){
                return dosage;
            }else{
                System.out.println("\nInvalid input for dosage!\n");
                return askDosagePerGroup();
            }
        }catch(NumberFormatException e){
            System.out.println("\nInvalid input for dosage!\n");
            return askDosagePerGroup();
        }
    }
    public int askNumberOfDaysPerGroup(){
        String input = Utils.readLineFromConsole("Number of days per group: ");
        try{
            int days = Integer.parseInt(input);
            if(days>0&&days<=366){
                return days;
            }else{
                System.out.println("\nInvalid input for days!\n");
                return askNumberOfDaysPerGroup();
            }
        }catch(NumberFormatException e){
            System.out.println("\nInvalid input for days!\n");
            return askNumberOfDaysPerGroup();
        }
    }
    public String askConfirmationAdmin(){
        String input = Utils.readLineFromConsole("Want to register another age group? (y/n): ");
        if(input.equalsIgnoreCase("y")||input.equalsIgnoreCase("yes")){
            return "continue";
        }else if(input.equalsIgnoreCase("no")||input.equalsIgnoreCase("n")){
            return "stop";
        }else{
            System.out.println("\nInvalid input for confirmation!\n");
            return askConfirmationAdmin();
        }
    }
}
