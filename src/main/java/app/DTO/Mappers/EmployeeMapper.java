package app.DTO.Mappers;

import app.DTO.EmployeeDTO;
import app.domain.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Employee mapper.
 */
public class EmployeeMapper {

    /**
     * To dto employee dto.
     *
     * @param employee the employee
     * @return the employee dto
     */
    public static EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee.getName(), employee.getEmail(), employee.getAddress(), employee.getPhoneNumber(), employee.getCitizenCardNumber(),employee.getRole(), employee.getId());
    }

    /**
     * To dto list.
     *
     * @param emp the emp
     * @return the list
     */
    public static List<EmployeeDTO> toDTOList(List<Employee> emp){
        List<EmployeeDTO> empDTO = new ArrayList<>();
        for (Employee employee : emp) {
            empDTO.add(toDTO(employee));
        }
        return empDTO;
    }

    /**
     * To entity employee.
     *
     * @param empDTO the emp dto
     * @return the employee
     */
    public static Employee toEntity(EmployeeDTO empDTO){
        return new Employee(empDTO.getName(), empDTO.getEmail(), empDTO.getAddress(), empDTO.getPhoneNumber(), empDTO.getCitizenCardNumber(),empDTO.getRole(), empDTO.getEmpID());
    }

    /**
     * To entity list.
     *
     * @param empDTO the emp dto
     * @return the list
     */
    public static List<Employee> toEntityList(List<EmployeeDTO> empDTO){
        List<Employee> emp = new ArrayList<>();
        for (EmployeeDTO employeeDTO : empDTO) {
            emp.add(toEntity(employeeDTO));
        }
        return emp;
    }

}
