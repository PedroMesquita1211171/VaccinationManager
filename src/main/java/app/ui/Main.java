package app.ui;

import app.domain.model.VaccinationRecord;
import app.ui.console.MainMenuUI;
import app.ui.gui.Utils.Scheduler;
import javafx.scene.Scene;

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
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws ParseException {


        new Scheduler();
        try
        {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
