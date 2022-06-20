package app.ui.gui.Utils;

import app.controller.App;
import app.domain.model.VaccinationRecord;
import app.ui.Main;
import org.junit.jupiter.api.DisplayNameGenerator;

import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Scheduler {
    public Scheduler() throws ParseException {
        try{
            Timer scheduler = new Timer();
            Calendar calendar = Calendar.getInstance();

            String[] hours = App.getInstance().getTimerHours().split(":");

            calendar.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            calendar.set(Calendar.HOUR, Integer.parseInt(hours[0]));
            calendar.set(Calendar.MINUTE, Integer.parseInt(hours[1]));
            calendar.set(Calendar.SECOND, Integer.parseInt(hours[2]));

            Date timerHour = calendar.getTime();
            scheduler.schedule(new VaccinationRecord(), timerHour, 86400000);

        }catch (Exception e){}
    }
}
