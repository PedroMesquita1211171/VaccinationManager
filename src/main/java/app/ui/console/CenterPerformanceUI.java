package app.ui.console;


import app.controller.CenterPerformanceController;
import app.ui.console.utils.Utils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Center performance ui.
 */
public class CenterPerformanceUI implements Runnable {

    public CenterPerformanceController ctrl;

    public CenterPerformanceUI(){
        ctrl = new CenterPerformanceController();
    }

    @Override
    public void run() {

        String confirmation, filePath;
        do {

            filePath = askFilePath();
            confirmation = askConfirmation();

        } while (!((confirmation.equals("y") || confirmation.equals("Y"))));
        int m;
        do {
            m = validateTimeIntervalDuration();
            confirmation = askConfirmation();

        } while (!((confirmation.equals("y") || confirmation.equals("Y"))));
        ArrayList<Integer> performanceList = ctrl.readInfoFromCSV(filePath, m);
        System.out.println(" The results for time intervals of " + m + " minutes, using the chosen csv file are");
        System.out.print("[");
        for (int i = 0; i <= performanceList.size()-1; i++) {
            if (i < performanceList.size() - 1) {
                System.out.print(performanceList.get(i) + ",");
            } else System.out.print(performanceList.get(i));
        }
        System.out.print("]");
        System.out.println("");
        System.out.println("The max sum contiguous sublist is:");
        System.out.print("[");
        for (int i = 0; i <= ctrl.maxsumsublist(performanceList).size()-1; i++) {
            if (i < ctrl.maxsumsublist(performanceList).size()-1) {
                System.out.print(ctrl.maxsumsublist(performanceList).get(i) + ",");
            } else System.out.print(ctrl.maxsumsublist(performanceList).get(i));
        }
        System.out.print("]");
        System.out.println("");
        System.out.println("The maximum sum of max sum contiguous sublist elements is:");
        System.out.println(ctrl.maxsum(performanceList));
        System.out.println("");
        System.out.println("The time interval corresponding to the maximum sum of sublist elements is:");
        try {
            System.out.println(ctrl.timeIntervalOfSublist(performanceList,filePath,m));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long sytemRunTime = System.currentTimeMillis();
        ctrl.benchmarkComparrission(performanceList, sytemRunTime);
    }

    private String askFilePath() {
        String input = Utils.readLineFromConsole("\nEnter the file path: ");
        if(!input.endsWith(".csv")){
            System.out.println("\nInvalid file format.\nPlease try again.\n");
            return askFilePath();
        }
        return input;
    }

    private String askConfirmation() {
        String input = Utils.readLineFromConsole("\nDo you want to proceed? (y/n): ");
        if (!input.equals("y") && !input.equals("Y") && !input.equals("n") && !input.equals("N")) {
            System.out.println("\nInvalid input.\nPlease try again.\n");
            return askConfirmation();
        }
        return input;
    }

    /**
     * Validate time interval duration int.
     *
     * @return the int
     */
    public int validateTimeIntervalDuration(){
        int m;
        System.out.println("\nEnter the time interval duration: ");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        if(m<1 || m>60){
            System.out.println("\nInvalid value.\nPlease try again.\n");
            return validateTimeIntervalDuration();
        }
        return m;
    }
}
