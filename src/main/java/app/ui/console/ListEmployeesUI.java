package app.ui.console;

import app.controller.ListEmployeesController;
import app.domain.model.Employee;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.util.List;

public class ListEmployeesUI implements Runnable{

    ListEmployeesController ctrl;

    public ListEmployeesUI(){
        this.ctrl = new ListEmployeesController();
    }

    @Override
    public void run() {
        try{
              System.out.println("1 - Receptionists\n" +
                              "2 - Nurses\n" +
                              "3 - Center Coordinators\n" +
                              "4 - All\n\n" +
                              "0 - Cancel\n");

                      String opt = Utils.readLineFromConsole("Select Option to List: ");

                      if(!opt.equals("0")){

                          showList(ctrl.redirectToList(opt));

                      }
        }catch(IllegalArgumentException iae){
            System.out.println("\n"+iae.getMessage()+"\n");
        }
    }

    public void showList(List<Employee> list){
        for (Employee e : list) {
            System.out.println("\n"+e+"\n");
        }
    }


}
