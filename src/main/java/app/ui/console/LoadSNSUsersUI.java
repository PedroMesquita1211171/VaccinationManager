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
            String option, confirmation1, confirmation2;

            do{

                do{

                    option = Utils.readLineFromConsole("What type of file do you want to load?\n1 - “;” separated(with header)\n2 - “,” separated\n");

                    if(!(option.equals("1")||option.equals("2"))){
                        System.out.println("\nInvalid option.\nTry again.");
                        option = "invalid";
                    }


                  }while(option.equals("invalid"));

                    confirmation1 = Utils.readLineFromConsole("Is this the correct file type?(y/n)\n");

                    if(!(confirmation1.equalsIgnoreCase("y")||confirmation1.equalsIgnoreCase("yes")||confirmation1.equalsIgnoreCase("n")||confirmation1.equalsIgnoreCase("no"))){
                        throw new IllegalArgumentException("\nInvalid option in yes or no block.\nReturning to main menu.");
                    }

            }while(!(confirmation1.equalsIgnoreCase("y")||confirmation1.equalsIgnoreCase("yes")));



             do{

                 String fileName = Utils.readLineFromConsole("Enter the file name/path: ");

                 confirmation2 = Utils.readLineFromConsole("Is this the correct file type?(y/n)\n");

                 if(!(confirmation2.equalsIgnoreCase("y")||confirmation2.equalsIgnoreCase("yes")||confirmation2.equalsIgnoreCase("n")||confirmation2.equalsIgnoreCase("no"))){
                     throw new IllegalArgumentException("\nInvalid option in yes or no block.\nReturning to main menu.");
                 }

                 if(confirmation2.equalsIgnoreCase("y")||confirmation2.equalsIgnoreCase("yes")){

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
                         System.out.println("\nFile does not exist\nReturning to main menu.");
                     }


                 }


               }while(!(confirmation2.equalsIgnoreCase("y")||confirmation2.equalsIgnoreCase("yes")));


        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }




    }
}
