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

/**
 * The type Scheduler.
 */
public class Scheduler {
    /**
     * Instantiates a new Scheduler.
     *
     * @throws ParseException the parse exception
     */
    public Scheduler() throws ParseException {
        try{
            Timer scheduler = new Timer();
            Calendar calendar = Calendar.getInstance();
            TimerTask alo = new TimerTask(){

                @Override
                public void run() {
                    new VaccinationRecord().run();
                }
            };

            String[] hours = App.getInstance().getTimerHours().split(":");

            calendar.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            calendar.set(Calendar.HOUR, Integer.parseInt(hours[0]));
            calendar.set(Calendar.MINUTE, Integer.parseInt(hours[1]));
            calendar.set(Calendar.SECOND, Integer.parseInt(hours[2]));

            Date timerHour = calendar.getTime();
            scheduler.schedule(alo, timerHour, 86400000);

        }catch (Exception e){}
    }
}
