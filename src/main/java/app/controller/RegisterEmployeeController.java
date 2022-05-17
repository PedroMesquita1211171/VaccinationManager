package app.controller;

import app.DTO.EmployeeDTO;
import app.DTO.Mappers.EmployeeMapper;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.ui.console.utils.Generators;

public class RegisterEmployeeController {


    /**
     *
     * Company and Employee to add.
     */
    private Company company;
    private Employee emp;


    /**
     * Constructors.
     */
    public RegisterEmployeeController() {
        this(App.getInstance().getCompany());
    }

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
     * @return the boolean
     */
    public boolean createEmployee(String name, String email, String address, String phoneNumber, String citizenCardNumber, String role) {
        try{
            this.emp = new Employee(name, email, address, phoneNumber, citizenCardNumber, role);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateEmployee(emp);
    }

    /**
     * Validates vaccine type boolean.
     *
     * @param emp the emp
     * @return the boolean
     */
    public boolean validateEmployee (Employee emp) {
        if (emp == null) return false;
        return !company.getEmployeeStore().getEmployeeList().contains(emp);
    }

    /**
     * Adds employee.
     */
    public void addEmployee() {
        String employeeID = Generators.generateEmployeeID();
        String password = Generators.generateRandomPassword();
        this.company.getEmployeeStore().addEmployee(this.emp);
        this.company.getAuthFacade().addUserWithRole(this.emp.getName(), this.emp.getEmail(),password, this.emp.getRole());

        System.out.println("\nEmployee" +"\n" + "Name: " + this.emp.getName() + "\n" + "Email: " + this.emp.getEmail() + "\n" + "Password: " + password + "\n" + "Role: " + this.emp.getRole() + "\n" + "Employee ID: " + employeeID + "\n");

    }

    /**
     * Shows employee object formated as a DTO.
     *
     * @return employee
     */
    public EmployeeDTO showEmployee() {
        return EmployeeMapper.toDTO(this.emp);
    }
}
