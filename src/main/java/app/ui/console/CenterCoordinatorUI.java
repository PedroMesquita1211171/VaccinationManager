package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Center coordinator ui.
 */
public class CenterCoordinatorUI implements Runnable{

    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Get a List of all Vaccines ", new ListVaccinesUI()));
        options.add(new MenuItem("Get a the analysis of a Vaccinaton Center's performance ", new CenterPerformanceUI()));
        options.add(new MenuItem("Load data from a legacy system",new LegacyDataUI()));


        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nCenter Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
