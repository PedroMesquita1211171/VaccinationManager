package app.ui.console;

import app.controller.ListEmployeesController;
import app.domain.model.Employee;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.util.List;

/**
 * @author Pedro Mesquita - 1211171
 */
public class ListEmployeesUI implements Runnable{

    /**
     * The Controller
     */
    ListEmployeesController ctrl;

    public ListEmployeesUI(){
        this.ctrl = new ListEmployeesController();
    }

    /**
     * Runnable that is used to activate the UI.
     */

    @Override
    public void run() {
        boolean success = false;
        do{
            try{
                System.out.println("1 - Receptionists\n" +
                        "2 - Nurses\n" +
                        "3 - Center Coordinators\n" +
                        "4 - All\n\n" +
                        "0 - Cancel\n");

                String opt = Utils.readLineFromConsole("Select Option to List: ");

                if(opt.equals("0")){
                    System.out.println("\nReturning to Admin Menu...\n");
                    success = true;
                }else{
                    List<Employee> list = ctrl.redirectToList(opt);

                    showList(list);
                    success = true;
                }

            }catch(IllegalArgumentException iae){
                System.out.println("\n"+iae.getMessage()+"\n");
            }

        }while(!success);

    }

    /**
     * Shows list of Employees asked.
     *
     * @param list List of Employees to be shown.
     */
    public void showList(List<Employee> list){
        for (Employee e : list) {
            System.out.println("\n"+e+"\n");
        }
    }


}
