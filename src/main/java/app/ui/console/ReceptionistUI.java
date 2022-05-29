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
        options.add(new MenuItem("Register someone into waiting room ",new WaitingRoomUI()));
        options.add(new MenuItem("Option 3 ", new ShowTextUI("You Chose Option 3")));

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
