package AddressService.repository;

import AddressService.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
    Address findByEmpId(int empId);
}
