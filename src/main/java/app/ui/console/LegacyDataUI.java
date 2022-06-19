package app.ui.console;

import app.controller.LegacyDataController;
import app.domain.model.LegacyData;
import app.ui.console.utils.BubbleSort;
import app.ui.console.utils.QuickSort;
import app.ui.console.utils.Utils;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * The type Legacy data ui.
 */
public class LegacyDataUI implements Runnable {
    private LegacyDataController ctrl;
    public BubbleSort bubble;
    public QuickSort quick;
    /**
     * The Horas.
     */
    SimpleDateFormat horas;

    /**
     * Instantiates a new Legacy data ui.
     */
    public LegacyDataUI() {
        this.ctrl = new LegacyDataController();
        this.horas = new SimpleDateFormat("HH:mm");
        this.bubble = new BubbleSort();
        this.quick = new QuickSort();

    }

    @Override
    public void run() {
        try {
            String confirmation, filePath;
            do {
                filePath = askFilePath();
                confirmation = askConfirmation();
            } while (!((confirmation.equals("y") || confirmation.equals("Y"))));
            String regex = returnRegex(filePath);
            loadData(filePath, regex);
            ctrl.saveLegacyDataList();
            System.out.println("\nData loaded successfully!\nHow do you want to sort the data?\n");
            String sorts;
            List<LegacyData> list = ctrl.getLegacyDataList();
            do{
                sorts = askSort();
                if(sorts.equals("1")){
                    int a = Integer.parseInt(askData());
                    ctrl.printLegacyDataList(quick.sort(list, a));
                }else if(sorts.equals("2")){
                    int b= Integer.parseInt(askData());
                    ctrl.printLegacyDataList(bubble.bubbleSort(list, b));
                }else{
                    System.out.println("\nInvalid option.\n");
                }
            }while (!(sorts.equals("1") || sorts.equals("2")));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadData(String filePath, String regex) throws ParseException {
        Scanner sc;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("\nFile not found or not accessible.\n");
        }
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(regex);
            if (tokens.length == 8) {
                SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                Date data4 = form.parse(tokens[4]);
                Calendar cal4 = Calendar.getInstance();
                cal4.setTime(data4);
                Date data5 =form.parse(tokens[5]);
                Calendar cal5 = Calendar.getInstance();
                cal5.setTime(data5);
                Date data6 =form.parse(tokens[6]);
                Calendar cal6 = Calendar.getInstance();
                cal6.setTime(data6);
                Date data7 =form.parse(tokens[7]);
                Calendar cal7 = Calendar.getInstance();
                cal7.setTime(data7);
                try {
                    ctrl.createLegacyDataList(tokens[0], tokens[1], tokens[2], tokens[3], cal4, cal5, cal6, cal7);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e.getMessage() + "\nInterrupting saving process.\n");
                }
            } else {
                throw new IllegalArgumentException("\nInvalid file format.\nLoad a valid file.\n");
            }
        }
    }

    private String returnRegex(String filePath) {
        Scanner scr = null;
        try {
            scr = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("\nFile not found or not accessible.\n");
        }
        String firstLine = scr.nextLine();
        if (firstLine.contains(";")) {
            return ";";
        } else if (firstLine.contains(",")) {
            return ",";
        }
        throw new IllegalArgumentException("\nInvalid file format.\nLoad a Valid file.\n");
    }

    private String askFilePath() {
        String input = Utils.readLineFromConsole("\nEnter the file name/path: ");
        if (!input.endsWith(".csv")) {
            System.out.println("\nInvalid file format.\nPlease try again.\n");
            return askFilePath();
        }
        return input;
    }

    private String askConfirmation() {
        String input = Utils.readLineFromConsole("\nAre you sure you want to load this file? (y/n): ");
        if (!(input.equals("y") || input.equals("Y"))) {
            System.out.println("\nReturning to main menu...\n");
            return askConfirmation();
        }
        return input;
    }
    private String askSort(){
        String input = Utils.readLineFromConsole("\n1. QuickSort\n2. BubbleSort\n");
        if(!(input.equals("1") || input.equals("2"))){
            System.out.println("\nInvalid option.\n");
            return askSort();
        }
        return input;
    }
    private String askData(){
        String input = Utils.readLineFromConsole("\nBy which data do you want to sort?\n1.Arrival date time\n2.Leaving date time\n");
        if(!(input.equals("1") || input.equals("2"))){
            System.out.println("\nInvalid option.\n");
            return askData();
        }
        return input;
    }

}
