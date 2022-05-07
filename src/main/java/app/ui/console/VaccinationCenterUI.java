package app.ui.console;

import app.controller.App;
import app.controller.SpecifyNewEmployeeController;
import app.controller.SpecifyNewVaccinationCenterController;
import pt.isep.lei.esoft.auth.AuthFacade;
/**
 * @author Luís Monteiro - 1211250
 */
public class VaccinationCenterUI implements Runnable{
    /**
     * Controller used to specify a new vaccination center.
     */
    private SpecifyNewVaccinationCenterController ctrl ;

    public RegisterEmployeeUi(){
        ctrl= new SpecifyNewEmployeeController();
        authFacade = App.getInstance().getCompany().getAuthFacade();
    }
}
