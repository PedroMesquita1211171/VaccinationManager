package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Nurse ui.
 */
public class NurseUI implements Runnable{
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("List SNS Users in the waiting room ", new ListSNSUsersInWaitingRoomUI()));


        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nNurse Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
