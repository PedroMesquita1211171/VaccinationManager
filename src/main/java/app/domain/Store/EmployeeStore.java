package app.domain.Store;

import app.domain.model.Employee;

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
     * Adds a new employee
     * @param e the Employee
     */
    public void addEmployee(Employee e){
        this.employeeList.add(e);
    }

}
