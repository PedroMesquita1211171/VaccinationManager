package app.ui.console;

import app.ui.console.utils.LoadSNSUserFromFile;
import app.ui.console.utils.Utils;

import java.io.File;
import java.text.ParseException;

public class LoadSNSUsersUI implements Runnable {

    private LoadSNSUserFromFile loadSNSUserFromFile;

    public LoadSNSUsersUI() {
        this.loadSNSUserFromFile = new LoadSNSUserFromFile();
    }


    @Override
    public void run() {

        try{
            String confirmation;





             do{

                 String fileName = Utils.readLineFromConsole("Enter the file name/path: ");

                 confirmation = Utils.readLineFromConsole("Is this the correct file type?(y/n)\n");

                 if(!(confirmation.equalsIgnoreCase("y")||confirmation.equalsIgnoreCase("yes")||confirmation.equalsIgnoreCase("n")||confirmation.equalsIgnoreCase("no"))){
                     throw new IllegalArgumentException("\nInvalid option in yes or no block.\nReturning to main menu.");
                 }

                 if(confirmation.equalsIgnoreCase("y")||confirmation.equalsIgnoreCase("yes")){

                     File file = new File(fileName);
                     String regex = "";

                     if(file.exists()){
                         regex = loadSNSUserFromFile.validateFile(file);
                         if((regex.equals(";")||regex.equals(","))){
                             regex = loadSNSUserFromFile.validateFile(file);
                             loadSNSUserFromFile.addToList(file, regex);
                         }
                     }
                     else{
                         System.out.println("\nFile does not exist\nReturning to main menu.");
                     }


                 }


               }while(!(confirmation.equalsIgnoreCase("y")||confirmation.equalsIgnoreCase("yes")));


        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }




    }
}
