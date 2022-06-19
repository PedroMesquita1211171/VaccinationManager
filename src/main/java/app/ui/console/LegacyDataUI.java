package app.ui.console;

import app.controller.LegacyDataController;
import app.ui.console.utils.Utils;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LegacyDataUI implements Runnable {
    private LegacyDataController ctrl;
    SimpleDateFormat horas;

    public LegacyDataUI() {
        this.ctrl = new LegacyDataController();
        this.horas = new SimpleDateFormat("HH:mm");
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
            System.out.println("\nData loaded successfully!\nDo you want to sort the date with QuickSort or BubbleSort?\n");
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
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(regex);
            if (tokens.length == 8) {
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                Date data4 =(Date)form.parse(tokens[4]);
                Calendar cal4 = Calendar.getInstance();
                cal4.setTime(data4);
                Date data6 =(Date)form.parse(tokens[6]);
                Calendar cal6 = Calendar.getInstance();
                cal6.setTime(data6);
                Date data5 =(Date)form.parse(tokens[5]);
                Calendar cal5 = Calendar.getInstance();
                cal5.setTime(data5);
                Date data7 =(Date)form.parse(tokens[7]);
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
}
