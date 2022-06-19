package app.ui.console.utils;


import app.domain.model.SNSUser;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The type Write users to file.
 */
public class WriteUsersToFile {
    /**
     * Writes SNS User useful info for login into a text file
     * @param snsu
     * @param password
     */

   // public void writeSNSUserToFile(SNSUser snsu, String password){
   //     try {
   //         writer = new FileWriter("SNSUsers.txt", true);
   //         writer.write("\n\n" + "SNS User" + "\n" + "Email: " + snsu.getEmail() + "\n" + "Name: " + snsu.getName() + "\n" + "Password: " + password + "\n");
   //         writer.close();
   //     } catch (IOException ex) {
   //         System.out.println("Error while creating file\nSNS User not added");
   //         authFacade.removeUser(snsu.getEmail());
   //     }
   //
   // }
    /**
     * Writes Employees useful info for login into a text file
     * @param e
     * @param password
     * @param employeeID
     */

   //public void writeEmployeeToFile(Employee e, String password, String employeeID){
   //    try {
   //        writer = new FileWriter("Employees.txt", true);
   //        writer.write("\n\n" + "Employee" +"\n" + "Email: " + e.getEmail() + "\n" + "Name: " + e.getName() + "\n" + "EmployeeID "+ employeeID+ "\n" + "Password: " + password + "\n" + "Role: " + e.getRole() + "\n");
   //        writer.close();
   //    } catch (IOException ex) {
   //        System.out.println("Error while creating file\nEmployee not added");
   //        authFacade.removeUser(e.getEmail());
   //    }
   //
   //}
}
