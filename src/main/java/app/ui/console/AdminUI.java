package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register a new Vaccine Type ", new VaccineTypeUI()));
        options.add(new MenuItem("Register a new employee ", new RegisterEmployeeUi()));
        options.add(new MenuItem("Show List of Employees of a certain role ", new ListEmployeesUI()));
        options.add(new MenuItem("Register a new VaccinationCenter ", new RegisterVaccinationCenterUI()));
        options.add(new MenuItem("Register a new vaccine and its administration process ", new VaccineUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
