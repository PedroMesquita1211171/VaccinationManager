package app.ui.console.utils;


import app.controller.RegisterSNSUserController;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadSNSUserFromFile {

    private RegisterSNSUserController ctrl;

    public LoadSNSUserFromFile() {
        this.ctrl = new RegisterSNSUserController();
    }



    public void LoadOption(File file, String regex) {
        try {
            Scanner read = new Scanner(file);
            if(regex.equals(";")) {
                String description = read.nextLine();
            }


            while (read.hasNextLine()) {
                String[] split = read.nextLine().split(regex);
                if(split.length == 8) {
                    //Name, Address, Sex, Phone Number, E-mail, Birth Date, SNS User Number and Citizen Card Number
                   if(ctrl.createSNSUser(split[0],split[1],split[2],split[3],split[4],split[5],split[6],split[7])){
                       ctrl.saveSNSUser();
                   }else{
                       throw new IllegalArgumentException("User was not saved due to having invalid data.\nInterrupting saving process.\n");
                   }
                }else{
                    throw new IllegalArgumentException("Invalid file format.\nInterrupting saving process.\n");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("\nFile is Invalid or not Accessible.\n");
        }
    }
}
