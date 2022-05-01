package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

public class ListEmployeesController {

    private Company company;

    public ListEmployeesController(){
        this(App.getInstance().getCompany());
    }

    public ListEmployeesController(Company company){
        this.company = company;
    }

    public List<Employee> redirectToList(String opt){
        if ("1".equals(opt)) {
            return getReceptionistsList();
        } else if ("2".equals(opt)) {
            return getNurseList();
        } else if ("3".equals(opt)) {
            return getCenterCoordinatorList();
        } else if ("4".equals(opt)) {
            return getAll();
        } else {
            throw new IllegalArgumentException("Not a valid option!");
        }
    }

    public List<Employee> getReceptionistsList(){
        List<Employee> recep = new ArrayList<>();

        for (Employee e : company.getEmployeeStore().getEmployeeList()) {
            if(e.getRole().equals(Constants.ROLE_RECEPTIONIST)){
                recep.add(e);
            }

        }

        return recep;
    }

    public List<Employee> getNurseList(){
        List<Employee> nur = new ArrayList<>();

        for (Employee e : company.getEmployeeStore().getEmployeeList()) {
            if(e.getRole().equals(Constants.ROLE_NURSE)){
                nur.add(e);
            }

        }

        return nur;
    }

    public List<Employee> getCenterCoordinatorList(){
        List<Employee> CC = new ArrayList<>();

        for (Employee e : company.getEmployeeStore().getEmployeeList()) {
            if(e.getRole().equals(Constants.ROLE_CENTER_CORDINATOR)){
                CC.add(e);
            }

        }

        return CC;
    }

    public List<Employee> getAll(){
        return company.getEmployeeStore().getEmployeeList();
    }

}
