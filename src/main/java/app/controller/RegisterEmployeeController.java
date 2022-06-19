package app.controller;

import app.DTO.EmployeeDTO;
import app.DTO.Mappers.EmployeeMapper;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.CommonMethods;
import app.ui.console.utils.Generators;

/**
 * The type Register employee controller.
 */
public class RegisterEmployeeController {


    /**
     *
     * Company and Employee to add.
     */
    private Company company;
    private Employee emp;


    /**
     * Instantiates a new Register employee controller.
     */
    public RegisterEmployeeController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new Register employee controller.
     *
     * @param company the company
     */
    public RegisterEmployeeController(Company company) {
        this.company = company;
        this.emp = null;
    }

    /**
     * Creates and verifies new employees.
     *
     * @param name              employee's name
     * @param email             employee's email
     * @param address           employee's address
     * @param phoneNumber       employee's phone number
     * @param citizenCardNumber employee's citizen card number
     * @param role              employee's role
     * @param empID             the emp id
     * @return the boolean
     */
    public boolean createEmployee(String name, String email, String address, String phoneNumber, String citizenCardNumber, String role, String empID) {

        this.emp = this.company.getEmployeeStore().createEmployee(name, email, address, phoneNumber, citizenCardNumber, role, empID);

        return this.company.getEmployeeStore().validateEmployee(this.emp);
    }


    /**
     * Adds employee as a System user and to the employee store.
     *
     * @return if the employee was added
     */
    public boolean saveEmployee() {
        String password = Generators.generateRandomPassword();
        boolean a = this.company.getEmployeeStore().addEmployee(this.emp);
        boolean b = this.company.getAuthFacade().addUserWithRole(this.emp.getName(), this.emp.getEmail(),password, this.emp.getRole());
         if(a && b){
             System.out.println("\nEmployee" +"\n" + "Name: " + this.emp.getName() + "\n" + "Email: " + this.emp.getEmail() + "\n" + "Password: " + password + "\n" + "Role: " + this.emp.getRole() + "\n" + "Employee ID: " + emp.getId() + "\n");

             CommonMethods.serializeStore(this.company.getEmployeeStore().getEmployeeList(),"data\\Employee.dat");

             return true;
         }
         return false;
    }

    /**
     * Shows employee object formated as a DTO.
     *
     * @return employee in DTO format
     */
    public EmployeeDTO showEmployee() {
        return EmployeeMapper.toDTO(this.emp);
    }
}
