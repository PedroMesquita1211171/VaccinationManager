package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.model.VaccineType;
import app.domain.shared.Constants;

public class SpecifyNewEmployeeController {

    private Company company;
    private Employee emp;

    public SpecifyNewEmployeeController() {
        this(App.getInstance().getCompany());
    }

    public SpecifyNewEmployeeController(Company company) {
        this.company = company;
        this.emp = null;
    }

    public boolean createEmployee(String name, String email, String address, String phoneNumber, String citizenCardNumber, int employeeID, String role) {
        try{
            this.emp = new Employee(name, email, address, phoneNumber, citizenCardNumber, employeeID, role);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }

        return validateEmployee(emp);
    }

    public boolean validateEmployee (Employee emp) {
        if (emp == null) return false;
        return !company.getEmployeeStore().getEmployeeList().contains(emp);
    }

    public void addEmployee() {
        this.company.addEmployee(emp);
        String password;
    }

    public String showEmployee() {
        return this.emp.toString();
    }
}
