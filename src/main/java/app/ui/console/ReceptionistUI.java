package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable {

    public ReceptionistUI() {
    }


    @Override
    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a new SNS User ", new RegisterSNSUserUI()));
        options.add(new MenuItem("Schedule a Vaccine for a SNS User ", new RecepcionistScheduleUI()));
        options.add(new MenuItem("Register the Arrival of a SNS User ", new RegisterArrivalUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
