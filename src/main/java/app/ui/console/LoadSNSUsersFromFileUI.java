package app.ui.console;

import app.controller.LoadSNSUsersFromFileController;
import app.ui.console.utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class LoadSNSUsersFromFileUI implements Runnable {



    private LoadSNSUsersFromFileController ctrl;
    SimpleDateFormat format;

    public LoadSNSUsersFromFileUI() {
        this.ctrl = new LoadSNSUsersFromFileController();
        this.format = new SimpleDateFormat("dd-MM-yyyy");
    }

    @Override
    public void run() {
        try{
            String confirmation, filePath;
            do{

                filePath = askFilePath();
                confirmation = askConfirmation();

            }while(!((confirmation.equals("y") || confirmation.equals("Y"))));

            String regex = returnRegex(filePath);

            loadUsers(filePath, regex);

            ctrl.saveSNSUserList();

            System.out.println("\nUsers loaded successfully!\nReturning to main menu...\n");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }






    }

    private void loadUsers(String filePath, String regex) {
        Scanner sc;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("\nFile not found or not accessible.\n");
        }

        if(regex.equals(";")){
            sc.nextLine();
        }

        while(sc.hasNextLine()){


            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] split = line.split(regex);
                if(split.length == 8){
                    try {
                        if(split[2].contains("/")){
                            split[2] = split[2].replace("/", "-");
                        }
                        ctrl.createSNSUserList(split[0],split[3],split[1],split[4],split[5],format.parse(split[2]),split[6],split[7]);
                    } catch (ParseException e) {
                        throw new IllegalArgumentException("\nInvalid date format.\nInterrupting saving process.\n");
                    }catch (IllegalArgumentException e){
                        throw new IllegalArgumentException(e.getMessage()+"\nInterrupting saving process.\n");
                    }
                }else{
                    throw new IllegalArgumentException("\nInvalid file format.\nLoad a Valid file.\n");
                }
            }
        }
    }

    private String returnRegex(String filePath) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("\nFile not found or not accessible.\n");
        }
        String firstLine = sc.nextLine();
        if(firstLine.contains(";")){
            return ";";
        }else if(firstLine.contains(",")){
            return ",";
        }
        throw new IllegalArgumentException("\nInvalid file format.\nLoad a Valid file.\n");
    }

    private String askConfirmation() {
        String input = Utils.readLineFromConsole("\nDo you want to load the file? (y/n): ");
        if(!input.equals("y") && !input.equals("Y") && !input.equals("n") && !input.equals("N")){
            System.out.println("\nInvalid input.\nPlease try again.\n");
            return askConfirmation();
        }
        return input;
    }

    private String askFilePath() {
        String input = Utils.readLineFromConsole("\nEnter the file name/path: ");
        if(!input.endsWith(".csv")){
            System.out.println("\nInvalid file format.\nPlease try again.\n");
            return askFilePath();
        }
        return input;
    }
}
