package app.ui.console;

import app.controller.App;
import app.controller.SpecifyNewEmployeeController;
import pt.isep.lei.esoft.auth.AuthFacade;

public class RegisterEmployeeUi implements Runnable{

    private SpecifyNewEmployeeController ctrl ;
    private final AuthFacade authFacade;

    public RegisterEmployeeUi(){
        ctrl= new SpecifyNewEmployeeController();
        authFacade = App.getInstance().getCompany().getAuthFacade();
    }

    public void run() {
    }


}
