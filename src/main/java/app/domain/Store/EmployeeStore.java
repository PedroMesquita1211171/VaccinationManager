package app.domain.Store;

import app.domain.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {

    private List<Employee> employeeList;

    public EmployeeStore(){
        employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public void addEmployee(Employee emp){
        this.employeeList.add(emp);
    }

}
