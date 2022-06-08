package app.controller;

import app.DTO.EmployeeDTO;
import app.DTO.Mappers.EmployeeMapper;
import app.domain.model.Company;

import java.util.List;

/**
 * The type List employees controller.
 */
public class ListEmployeesController {

    private Company company;

    /**
     * Instantiates a new List employees controller.
     *
     * @param company the company
     */
    public ListEmployeesController(Company company) {
        this.company = company;
    }

    /**
     * Instantiates a new List employees controller.
     */
    public ListEmployeesController() {
       this(App.getInstance().getCompany());
    }


    /**
     * Show receptionists list.
     *
     * @return the list
     */
    public List<EmployeeDTO> showReceptionists(){
        List<EmployeeDTO> list = EmployeeMapper.toDTOList(this.company.getEmployeeStore().getReceptionistList());

        if(list.size() == 0) throw new IllegalArgumentException("\nThere are no receptionists\n");

        return list;
    }

    /**
     * Show nurses list.
     *
     * @return the list
     */
    public List<EmployeeDTO> showNurses(){
        List<EmployeeDTO> list = EmployeeMapper.toDTOList(this.company.getEmployeeStore().getNurseList());

        if(list.size() == 0) throw new IllegalArgumentException("\nThere are no nurses\n");

        return list;
    }

    /**
     * Show center coordinators list.
     *
     * @return the list
     */
    public List<EmployeeDTO> showCenterCoordinators(){
         List<EmployeeDTO> list = EmployeeMapper.toDTOList(this.company.getEmployeeStore().getCenterCoordinatorList());

        if(list.size() == 0) throw new IllegalArgumentException("\nThere are no center coordinators\n");

        return list;
    }
}
