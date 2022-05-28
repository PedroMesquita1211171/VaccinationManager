package app.ui.console.utils;


import app.controller.RegisterSNSUserController;
import app.domain.model.SNSUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Pure Fabrication created Class in order to load SNS users from specified file.
 *
 * @author Henrique Pinto - 1211201
 *
 */
public class LoadSNSUserFromFile {

    /**
     * Controller used to register SNS users and Date parser.
     */
    private RegisterSNSUserController ctrl;
    /**
     * The Date Format.
     */
    SimpleDateFormat format;
    /**
     * Temporary SNSUserList.
     */
    List<SNSUser> snsUserList;

    /**
     * Constructor. Initializes the controller and the date parser.
     */
    public LoadSNSUserFromFile() {
        this.ctrl = new RegisterSNSUserController();
        this.format = new SimpleDateFormat("dd/MM/yyyy");
        this.snsUserList = new ArrayList<>();
    }


    /**
     * Loads the file with a specific regex.
     *
     * @param file  the file to load
     * @param regex the regex used in the file
     */
    public void addToList(File file, String regex) {
        try {
            Scanner read = new Scanner(file);

            if(regex.equals(";")) {
                String description = read.nextLine();
            }


            while (read.hasNextLine()) {
                String[] split = read.nextLine().split(regex);
                try {
                    if(split.length == 8) {

                            //Name, Address, Sex, Phone Number, E-mail, Birth Date, SNS User Number and Citizen Card Number
                            if(ctrl.createSNSUser(split[0],split[1],split[2],split[3],split[4],format.parse(split[5]),split[6],split[7])){

                                snsUserList.add(new SNSUser(split[0],split[1],split[2],split[3],split[4],format.parse(split[5]),split[6],split[7]));

                            }else{
                                throw new IllegalArgumentException("User was not saved due to having invalid data.\nInterrupting saving process.\n");
                            }
                    } else{
                        throw new IllegalArgumentException("Invalid file format.\nInterrupting saving process.\n");
                    }
                }catch (ParseException e) {
                    throw new IllegalArgumentException("User was not saved due to having invalid data.\nInterrupting saving process.\n");

                }


            }

            saveSNSUsers(snsUserList);

        } catch (FileNotFoundException e) {
            System.out.println("\nFile is Invalid or not Accessible.\n");
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Save sns users.
     *
     * @param snsUserList the sns user list
     */
    public void saveSNSUsers (List<SNSUser> snsUserList) {
        for (SNSUser snsUser : snsUserList) {
            try{
                //Name, Address, Sex, Phone Number, E-mail, Birth Date, SNS User Number and Citizen Card Number
                if(ctrl.createSNSUser(snsUser.getName(),snsUser.getAddress(),snsUser.getGender(),snsUser.getPhoneNumber(),snsUser.getEmail(),snsUser.getBirthDate(),snsUser.getSNSNumber(),snsUser.getCitizenCardNumber())){
                    if(!ctrl.saveSNSUser()){
                        throw new IllegalArgumentException("User was not saved due to already being registered.\n");
                    }
                }
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * Validates file.
     *
     * @param file
     * @return the regex
     */
    public String validateFile(File file) {
        checkfileextension(file);
        try {
            Scanner verify = new Scanner(file);
            String line = verify.nextLine();
            if(line.contains(";")) {
                return ";";
            }else if(line.contains(",")) {
                return ",";
            }else{
                throw new IllegalArgumentException("Invalid file format.\n");
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File is Invalid or not Accessible.");
        }


    }

    /**
     * Checks file extension.
     *
     * @param file
     */
    public void checkfileextension(File file) {
        if(!file.getName().endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file format.\n");
        }
    }
}
