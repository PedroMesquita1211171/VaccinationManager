package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Nurse ui.
 */
public class NurseUI implements Runnable{

    /**
     * Instantiates a new Nurse ui.
     */
    public NurseUI(){
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Consult list of users in the waiting room ", new RegisterSNSUserUI()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nNurse" +
                    " Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
