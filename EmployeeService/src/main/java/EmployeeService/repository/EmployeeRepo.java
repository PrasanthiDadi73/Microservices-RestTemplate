package EmployeeService.repository;

import EmployeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
