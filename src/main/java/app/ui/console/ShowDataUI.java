package app.ui.console;

import app.controller.ShowDataController;
import app.domain.model.US16.RegistoDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ShowDataUI implements Runnable{

    private ShowDataController ctrl;
    private static final Scanner sc = new Scanner(System.in);
    private final String format = "M/d/yyyy H:mm";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);


    public ShowDataUI() {
        this.ctrl = new ShowDataController();
    }

    public ShowDataUI(ShowDataController ctrl) {
        this.ctrl = ctrl;
    }
    @Override
    public void run() {
        try{
            int algorithm;
            int order;
            System.out.println("Choose the algorithm to sort the data:");
            System.out.println("1 - Bubble Sort");
            System.out.println("2 - Quick Sort");
            algorithm = Integer.parseInt(sc.nextLine());
            System.out.println("Choose the order to sort the data:");
            System.out.println("1 - Arrival Date and Time");
            System.out.println("2 - Leaving Date and Time");
            System.out.println("3 - Arrival Date and Time (Descending)");
            System.out.println("4 - Leaving Date and Time (Descending)");
            order = Integer.parseInt(sc.nextLine());

            List<RegistoDTO> registos = ctrl.processResult(algorithm, order);

            if(registos.size() > 0)
                System.out.println("SNS User Number | Arrival Date and Time | Leaving Date and Time");

            for (RegistoDTO registo : registos)
                System.out.println(registo.getSnsUserNumber() + " | " + registo.getArrivalDateTime().format(formatter) + " | " + registo.getLeavingDateTime().format(formatter));

            if(registos.size() == 0)
                System.out.println("Empty data set.\nTry loading data first.");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
