package app.ui.console.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class Created in order to Respect Solid principles
 * Single Responsibility (Each class is responsible for a single function)
 * And to respect GRASP principle
 * Pure Fabrication and Information expert
 */
public class CSVConverter {

    /**
     * Read info from csv array list.
     *
     * @param filePath the file path
     * @param m        the m
     * @return the array list
     */
    public ArrayList<Integer>  readInfoFromCSV(String filePath, int m)  {
        Path pathToFile = Paths.get(filePath);
        Calendar calendar = GregorianCalendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        ArrayList<Integer>mdiscMatrix = new ArrayList<>(720/m);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
                ArrayList<String> arrivalDate = new ArrayList<>();
                ArrayList<String> departureDate = new ArrayList<>();
                String line;
                String[] tokens1;
                ArrayList<Calendar> arrivalTime = new ArrayList<>();
                ArrayList<Calendar> departureTime= new ArrayList<>();
                br.readLine();
                while ((line = br.readLine()) != null) {
                    tokens1 = line.split(";",8);
                    arrivalDate.add(tokens1[5].trim());
                    departureDate.add(tokens1[7].trim());

                }
                arrivalTime = DateParser.StringToCalendar(arrivalDate);
                departureTime = DateParser.StringToCalendar(departureDate);
               mdiscMatrix=arrayListToMatrix(arrivalTime,departureTime,m);
            }catch (IOException ioe) { ioe.printStackTrace(); }
        return mdiscMatrix;
    }

    /**
     * Array list to matrix array list.
     *
     * @param arrivalTime   the arrival time
     * @param departureTime the departure time
     * @param m             the m
     * @return the array list
     */
    public ArrayList<Integer> arrayListToMatrix(ArrayList<Calendar> arrivalTime, ArrayList<Calendar> departureTime, int m){
        int intervalTime = 720/m;
        ArrayList<Integer> mdiscArray = new ArrayList<>();
            Calendar timeSlotLimit = (Calendar) arrivalTime.get(0).clone();
            timeSlotLimit.set(Calendar.HOUR, 8);
            timeSlotLimit.set(Calendar.MINUTE, m);
            int centerPerformance = 0;
            for (int n = 0; n < intervalTime; n++) {
                for (int i = 0; i < arrivalTime.size(); i++) {
                    if (isDateInSlot(arrivalTime.get(i), timeSlotLimit)) {
                            centerPerformance++;
                    }
                    if (isDateInSlot(departureTime.get(i), timeSlotLimit)) {
                            centerPerformance--;
                    }
                    timeSlotLimit.add(Calendar.MINUTE, m);
                }
                mdiscArray.add(centerPerformance);
                centerPerformance = 0;
            }
            return mdiscArray;
    }

    /**
     * Is date in slot boolean.
     *
     * @param calendar      the calendar
     * @param timeSlotLimit the time slot limit
     * @return the boolean
     */
    public boolean isDateInSlot(Calendar calendar, Calendar timeSlotLimit){
        return calendar.before(timeSlotLimit);
    }

}
