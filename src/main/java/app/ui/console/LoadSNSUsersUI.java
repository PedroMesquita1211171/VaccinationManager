package app.ui.console;

import app.ui.console.utils.LoadSNSUserFromFile;
import app.ui.console.utils.Utils;

import java.io.File;

public class LoadSNSUsersUI implements Runnable {

    private LoadSNSUserFromFile loadSNSUserFromFile;

    public LoadSNSUsersUI() {
        this.loadSNSUserFromFile = new LoadSNSUserFromFile();
    }


    @Override
    public void run() {

        try{
            String option;

            do{
                option = Utils.readLineFromConsole("What type of file do you want to load?\n1 - “;” separated(with header)\n2 - “,” separated\n");

                if(!(option.equals("1")||option.equals("2"))){
                    System.out.println("Invalid option.\nTry again.");
                    option = "invalid";
                }

            }while(option.equals("invalid"));

            String fileName = Utils.readLineFromConsole("Enter the file name/path: ");

            File file = new File(fileName);
            String regex = "";

            if(file.exists()){
                if(option.equals("1")){
                     regex = ";";
                    this.loadSNSUserFromFile.LoadOption(file, regex);

                }else if (option.equals("2")){
                     regex = ",";
                    this.loadSNSUserFromFile.LoadOption(file, regex);

                }
            }
            else{
                System.out.println("File does not exist\nReturning to main menu.");
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }




    }
}
