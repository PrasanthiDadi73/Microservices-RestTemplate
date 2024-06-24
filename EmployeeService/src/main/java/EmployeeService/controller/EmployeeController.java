package EmployeeService.controller;

import EmployeeService.client.AddressClient;
import EmployeeService.dto.EmployeeDTO;
import EmployeeService.entity.Address;
import EmployeeService.entity.Employee;
import EmployeeService.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-service")
public class EmployeeController {

    @Autowired
    private EmployeeRepo empRepo;

    @Autowired
    private AddressClient addressClient;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody EmployeeDTO emp){
            Employee employee=empRepo.save(emp.getEmployee());
            if(employee!=null && employee.getEmpId()>0){
                addressClient.saveAddress(emp.getAddress(),employee.getEmpId());
            }

            return employee;

    }

    @GetMapping("/get")
    public List<Employee> getEmployees(){
        return empRepo.findAll();
    }

    @GetMapping("/employees/{empId}/address")
    public List<Address> getAddressByEmpId(@PathVariable int empId) {
        return addressClient.getAddress(empId);
    }

}

