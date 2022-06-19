package app.ui;

import app.domain.model.VaccinationRecord;
import app.ui.console.MainMenuUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Main.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
//Teste
public class Main extends TimerTask {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws ParseException {

        try
        {
            MainMenuUI menu = new MainMenuUI();

            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        //the Date and time at which you want to execute
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter.parse("2022-06-19 21:23:00");

        //Now create the time and schedule it
        Timer timer = new Timer();

        timer.schedule(new Main(), date, 86400000);
        //int period = 10000;//10secs ---> 86400000 = 1 day

    }

    @Override
    public void run() {
        VaccinationRecord.main();
    }
}
