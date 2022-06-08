package app.ui.console;

import app.DTO.EmployeeDTO;
import app.controller.ListEmployeesController;
import app.ui.console.utils.Utils;
import java.util.List;

public class ListEmployeesUI implements  Runnable{

       ListEmployeesController ctrl;

       public ListEmployeesUI(){
           this.ctrl = new ListEmployeesController();
       }


    @Override
    public void run() {

           try{
               System.out.println("\nList Employees\n1-Receptionist\n2-Nurse\n3-Center Coordinator\n\n0-Back");
               int role;

               try{
                   role = Utils.readIntegerFromConsole("Select role: ");
               }catch (NumberFormatException e){
                   throw new IllegalArgumentException("Invalid option");
               }

               switch (role){
                   case 0:
                       System.out.println("\nBack to Main Menu\n");
                       break;
                   case 1:
                       System.out.println("\nList Receptionist\n");
                       printEmployeeList(ctrl.showReceptionists());
                       break;
                   case 2:
                       System.out.println("\nList Nurse\n");
                       printEmployeeList(ctrl.showNurses());
                       break;
                   case 3:
                       System.out.println("\nList Center Coordinator\n");
                       printEmployeeList(ctrl.showCenterCoordinators());
                       break;
                   default:
                       throw new IllegalArgumentException("Invalid option");
               }
           }catch(IllegalArgumentException e){
               System.out.println(e.getMessage());
           }



    }


    public void printEmployeeList(List<EmployeeDTO> list){
        for(EmployeeDTO e : list){
            System.out.println(e);
        }
    }
}
