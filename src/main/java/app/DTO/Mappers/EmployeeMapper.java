package app.DTO.Mappers;

import app.DTO.EmployeeDTO;
import app.domain.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee.getName(), employee.getEmail(), employee.getAddress(), employee.getPhoneNumber(), employee.getCitizenCardNumber(),employee.getRole());
    }

    public static List<EmployeeDTO> toDTOList(List<Employee> emp){
        List<EmployeeDTO> empDTO = new ArrayList<>();
        for (Employee employee : emp) {
            empDTO.add(toDTO(employee));
        }
        return empDTO;
    }

}
