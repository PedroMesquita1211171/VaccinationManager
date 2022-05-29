package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable{

    public ReceptionistUI() {
    }

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register a new SNS User/Client ", new RegisterSNSUserUI()));
        options.add(new MenuItem("Schedule a vaccine ", new ReceptionistScheduleVaccineUI()));
        options.add(new MenuItem("Register someone into waiting room ",new WaitingRoomUI()));




        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist" +
                    " Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}


