package app.controller;

import app.DTO.EmployeeDTO;
import app.DTO.Mappers.EmployeeMapper;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pedro Mesquita - 1211171
 */
public class ListEmployeesController {

    private Company company;

    /**
     * Instantiates a new List employees controller.
     */
    public ListEmployeesController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Instantiates a new List employees controller.
     *
     * @param company the company
     */
    public ListEmployeesController(Company company){
        this.company = company;
    }

    /**
     * Redirect to list.
     *
     * @param opt the option
     * @return the list
     */
    public List<EmployeeDTO> redirectToList(String opt){
        if ("1".equals(opt)) {
            return EmployeeMapper.toDTOList(getReceptionistsList());
        } else if ("2".equals(opt)) {
            return EmployeeMapper.toDTOList(getNurseList());
        } else if ("3".equals(opt)) {
            return EmployeeMapper.toDTOList(getCenterCoordinatorList());
        } else if ("4".equals(opt)) {
            return EmployeeMapper.toDTOList(getAll());
        } else {
            throw new IllegalArgumentException("Not a valid option!");
        }
    }

    /**
     * Get receptionists list.
     *
     * @return the list
     */
    public List<Employee> getReceptionistsList(){
        List<Employee> recep = new ArrayList<>();

        for (Employee e : company.getEmployeeStore().getEmployeeList()) {
            if(e.getRole().equals(Constants.ROLE_RECEPTIONIST)){
                recep.add(e);

            }


        }
        if(recep.isEmpty()){
            throw new IllegalArgumentException("There are no receptionists!");
        }

        return recep;
    }

    /**
     * Get nurse list.
     *
     * @return the list
     */
    public List<Employee> getNurseList(){
        List<Employee> nur = new ArrayList<>();

        for (Employee e : company.getEmployeeStore().getEmployeeList()) {
            if(e.getRole().equals(Constants.ROLE_NURSE)){
                nur.add(e);
            }

        }
        if(nur.isEmpty()){
            throw new IllegalArgumentException("There are no nurses!");
        }

        return nur;
    }

    /**
     * Get center coordinator list.
     *
     * @return the list
     */
    public List<Employee> getCenterCoordinatorList(){
        List<Employee> CC = new ArrayList<>();

        for (Employee e : company.getEmployeeStore().getEmployeeList()) {
            if(e.getRole().equals(Constants.ROLE_CENTER_CORDINATOR)){
                CC.add(e);
            }

        }

        if(CC.isEmpty()){
            throw new IllegalArgumentException("There are no center coordinators!");
        }

        return CC;
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Employee> getAll(){

        if(company.getEmployeeStore().getEmployeeList().isEmpty()){
            throw new IllegalArgumentException("There are no employees!");
        }

        return company.getEmployeeStore().getEmployeeList();
    }

}
