package app.ui.console;

import app.controller.AnalyzeCenterController;
import app.ui.gui.Utils.Sum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AnalyzeCenterUI implements Runnable{
    private AnalyzeCenterController ctrl;
    private final static Scanner sc = new Scanner(System.in);
    private final static String DATE_FORMAT = "dd-MM-yyyy";
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public AnalyzeCenterUI() {
        this.ctrl = new AnalyzeCenterController();
    }

    @Override
    public void run() {

        try{
            System.out.print("Type the day you want to analyze (dd-mm-yyyy): ");
            String date = sc.nextLine();
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println("Type time interval(30,20,10,5,1): ");
            int timeInterval = Integer.parseInt(sc.nextLine());
            verifyTimeInterval(timeInterval);

            int[] result = ctrl.result(timeInterval, localDate);
            System.out.print("Contiguous max sublist: ");

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }

            int[] resultMDISC = Sum.Max(ctrl.getList(timeInterval, localDate));

            System.out.print("\nMDISC contiguous max Sublist: ");

            for (int i = 0; i < resultMDISC.length; i++) {
                System.out.print(resultMDISC[i] + " ");
            }
        }catch(NumberFormatException nfe){
            System.out.println("Invalid input\nTry again.");
        }
        catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }


    }

    private void verifyTimeInterval(int timeInterval) {
        List<Integer> timeIntervals = List.of(30,20,10,5,1);
        if(!timeIntervals.contains(timeInterval))
            throw new IllegalArgumentException("Invalid time interval\nTry again.");
    }
}
