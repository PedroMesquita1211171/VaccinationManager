package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SNSUserUI implements Runnable{
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Schedule a Vaccine ", new SNSUserScheduleUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nSNS User Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
