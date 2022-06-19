package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Admin ui.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class AdminUI implements Runnable{
    /**
     * Instantiates a new Admin ui.
     */
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a new Employee ", new RegisterEmployeeUI()));
        options.add(new MenuItem("Specify a new Vaccine Type ", new SpecifyNewVaccineTypeUI()));
        options.add(new MenuItem("List Employees ", new ListEmployeesUI()));
        options.add(new MenuItem("Specify a new Vaccine and its Administration Process ", new SpecifyNewVaccineUI()));
        options.add(new MenuItem("Register a Vaccination Center ", new RegisterVaccinationCenterUI()));
        options.add(new MenuItem("Load a set of Users through an CSV ", new LoadSNSUsersFromFileUI()));

        int option;
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
