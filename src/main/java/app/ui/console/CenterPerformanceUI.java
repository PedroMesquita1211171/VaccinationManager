package app.ui.console;


import app.controller.CenterPerformanceController;
import app.ui.console.utils.Utils;


import java.util.ArrayList;
import java.util.Scanner;

public class CenterPerformanceUI implements Runnable {

    private CenterPerformanceController ctrl;

    public void run() {
        String  confirmation,filename;
        do{

            filename = askFilePath();
            confirmation = askConfirmation();

        }while(!((confirmation.equals("y") || confirmation.equals("Y"))));
        System.out.println("Select the duration of time intervals to analyze:");
        int m;
        do{
            m = validateTimeIntervalDuration();
            confirmation = askConfirmation();

        }while(!((confirmation.equals("y") || confirmation.equals("Y"))));
            ArrayList<Integer> performanceList = ctrl.readInfoFromCSV(filename, m);
            System.out.println(" The results for time intervals of "+m+" minutes, using the chosen csv file are");
            System.out.println("[");
            for (int i=0; i<=performanceList.size(); i++){
                    if (i< performanceList.size()-1) {
                        System.out.print(performanceList.get(i)+",");
                    }else  System.out.print(performanceList.get(i));
            }
            System.out.print("]");
            System.out.println("");
            System.out.println("The max sum contiguous sublist is:");
            for (int i=0; i<=ctrl.maxsumsublist(performanceList).size(); i++){
                if (i< ctrl.maxsumsublist(performanceList).size()-1) {
                        System.out.print(ctrl.maxsumsublist(performanceList).get(i)+",");
                }else  System.out.print(ctrl.maxsumsublist(performanceList).get(i));
            }
            System.out.println("");
            System.out.println("The maximum sum of max sum contiguous sublist elements is:");
            System.out.println(ctrl.maxsum(performanceList));
            System.out.println("");
            System.out.println("The time interval corresponding to the maximum sum of sublist elements is:");
            System.out.println("["+ctrl.intervalStart(ctrl.maxsumsublist(performanceList))+","+ctrl.intervalEnd(ctrl.maxsumsublist(performanceList)));
    }

    private String askFilePath() {
        String input = Utils.readLineFromConsole("\nEnter the file name/path: ");
        if(!input.endsWith(".csv")){
            System.out.println("\nInvalid file format.\nPlease try again.\n");
            return askFilePath();
        }
        return input;
    }

    private String askConfirmation() {
        String input = Utils.readLineFromConsole("\nDo you want to load the file? (y/n): ");
        if (!input.equals("y") && !input.equals("Y") && !input.equals("n") && !input.equals("N")) {
            System.out.println("\nInvalid input.\nPlease try again.\n");
            return askConfirmation();
        }
        return input;
    }

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
