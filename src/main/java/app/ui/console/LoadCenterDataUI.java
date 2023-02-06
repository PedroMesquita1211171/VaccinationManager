package app.ui.console;

import app.controller.LoadCenterDataController;
import app.domain.model.US16.RegistoDTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoadCenterDataUI implements Runnable {

    private LoadCenterDataController ctrl;
    private final static Scanner sc = new Scanner(System.in);

    public LoadCenterDataUI() {
        this.ctrl = new LoadCenterDataController();
    }
    @Override
    public void run() {
        System.out.print("Insert the file path: ");
        String filePath = sc.nextLine();
        try {
            ctrl.load(filePath);

            System.out.println("Data loaded successfully");
            List<RegistoDTO> registos = ctrl.getRegistos();

            System.out.println("\nSNS Number | Vaccine Name | Dose Number | Scheduled Time | Arrival Time | Administration Time | Leave Time\n");
            for (RegistoDTO registo : registos)
                System.out.println(registo);

            System.out.println("Do you want to save the data? (Y/N)");
            String answer = sc.nextLine();

            if(answer.equalsIgnoreCase("Y")){
                ctrl.saveRegistos();
                System.out.println("Data saved successfully");
            }else if(answer.equalsIgnoreCase("N")){
                System.out.println("Data not saved\nOld data was deleted\n");
            }else{
                System.out.println("Invalid answer");
                run();
            }

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            run();
        } catch (IOException e) {
            System.out.println("Error reading the file\nTry again\n");
            run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            run();
        }

    }
}
