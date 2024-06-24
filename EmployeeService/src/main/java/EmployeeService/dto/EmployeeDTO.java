package EmployeeService.dto;

import EmployeeService.entity.Address;
import EmployeeService.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private Employee employee;
    private List<Address> address;
}
