package app.domain.Store;

import app.domain.model.Employee;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    /**
     * List that will store Employees
     */

    private List<Employee> employeeList;

    /**
     * Declares the employeeList as an ArrayList of type Employee.
     */

    public EmployeeStore(){
        employeeList = new ArrayList<>();
    }

    /**
     * Is used for returning the List of Employees.
     *
     * @return the list of employees
     */
    public List<Employee> getEmployeeList(){
        return employeeList;
    }
    /**
     * Gets the receptionist list.
     *
     * @return the receptionist list
     */
    public List<Employee> getReceptionistList(){
        List<Employee> receptionistList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getRole().equals(Constants.ROLE_RECEPTIONIST)) {
                receptionistList.add(employee);
            }
        }
        return receptionistList;
    }
    /**
     * Gets the Nurse list.
     *
     * @return the Nurse list
     */
    public List<Employee> getNurseList(){
        List<Employee> nurseList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getRole().equals(Constants.ROLE_NURSE)) {
                nurseList.add(employee);
            }
        }
        return nurseList;
    }
    /**
     * Gets the Center Coordinator list.
     *
     * @return the Center Coordinator list
     */
    public List<Employee> getCenterCoordinatorList(){
        List<Employee> centerCoordinatorList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getRole().equals(Constants.ROLE_CENTER_COORDINATOR)) {
                centerCoordinatorList.add(employee);
            }
        }
        return centerCoordinatorList;
    }

    /**
     * Adds a new employee
     * @param e the Employee
     */
    public boolean addEmployee(Employee e){
        if(validateEmployee(e)){
            this.employeeList.add(e);
            return true;
        }
        return false;
    }

    /**
     * Creates a new Employee.
     * @param name the name
     * @param email the email
     * @param address the address
     * @param phoneNumber the phone number
     * @param citizenCardNumber the citizen card number
     * @param role the role
     * @param empID the emp ID
     * @return the Employee
     */
    public Employee createEmployee(String name, String email, String address, String phoneNumber, String citizenCardNumber, String role, String empID){
        return new Employee(name, email, address, phoneNumber, citizenCardNumber, role, empID);
    }

    /**
     * Validates Employee boolean.
     *
     * @param emp the emp
     * @return the boolean
     */
    public boolean validateEmployee (Employee emp) {
        if (emp == null) return false;
        return !getEmployeeList().contains(emp);
    }

}
