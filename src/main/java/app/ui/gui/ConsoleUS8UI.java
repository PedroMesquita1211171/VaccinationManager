package app.ui.gui;

import app.DTO.VaccineDTO;
import app.controller.RecordVaccinationController;
import app.ui.console.utils.Utils;

import java.util.List;

public class ConsoleUS8UI implements Runnable{

    private RecordVaccinationController ctrl;
    private List<VaccineDTO> vaccines;


    public ConsoleUS8UI() {
        ctrl = new RecordVaccinationController();
        vaccines = ctrl.getVaccines();
    }

    @Override
    public void run() {
         try{
             String SNSNumber = readSNSNumber();
             VaccineDTO vaccine = vaccines.get(Utils.showAndSelectIndex(vaccines, "Select a vaccine\n"));
             int doseNumber = readDoseNumber();

             //creating and saving process
             if(ctrl.createVaccination(SNSNumber, vaccine, doseNumber)){
                 String confirmation = Utils.readLineFromConsole("Confirm vaccination? (y/n)");
                 if(confirmation.equalsIgnoreCase("y")||confirmation.equalsIgnoreCase("yes")){
                     if(ctrl.saveVaccination()){
                         System.out.println("Vaccination recorded with success!");
                     }else{
                         System.out.println("\nVaccination not saved since it was already recorded!\n");
                     }
                 }else if(confirmation.equalsIgnoreCase("n")||confirmation.equalsIgnoreCase("no")){
                     throw new IllegalArgumentException("Vaccination not recorded.");
                 }else{
                     throw new IllegalArgumentException("Invalid input for (y/n).");
                 }

             }else{
                 System.out.println("\nVaccination not saved since it was already recorded!\n");
             }
         }catch(Exception e){
             System.out.println(e.getMessage()+"Interrupting Saving process.\n");
         }



    }

    private int readDoseNumber() {
        String input = Utils.readLineFromConsole("Enter the dose number\n");
        try{
            Integer.parseInt(input);
            if(Integer.parseInt(input) < 1){
                throw new IllegalArgumentException("Dose number must be greater than 0");
            }

        }catch (NumberFormatException e){
            System.out.println("Dose Number must be an integer! Try again!");
            return readDoseNumber();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDoseNumber();
        }
        return Integer.parseInt(input);
    }

    private String readSNSNumber() {
        String input = Utils.readLineFromConsole("Enter SNS Number: ");
        try{
            Long.parseLong(input);
        }catch(NumberFormatException e){
            System.out.println("SNS Number must be a number!");
            return readSNSNumber();
        }
        return input;
    }
}
