package app.ui.console.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * Class Created in order to Respect Solid principles
 * Single Responsibility (Each class is responsible for a single function)
 */
public class DateParser {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    private static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public static ArrayList<Calendar> StringToCalendar(ArrayList<String> dateList){

        ArrayList<Calendar> calendarList = new ArrayList<>();

        for (String d : dateList) {
            try {
                calendarList.add(dateToCalendar(sdf.parse(d)));
            } catch (ParseException e) {
                System.out.println("Invalid Date.");
            }
        }

        return calendarList;
    }
}
