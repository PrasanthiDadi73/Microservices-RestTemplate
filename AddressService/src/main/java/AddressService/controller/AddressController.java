package AddressService.controller;

import AddressService.entity.Address;
import AddressService.repository.AddressRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add-service")
public class AddressController {

    @Autowired
    private AddressRepo addRepo;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address add){
        return addRepo.save(add);
    }

    @GetMapping("/get")
    public List<Address> getAddress(){
        return addRepo.findAll();
    }

    @GetMapping("/getAddres" +
            "sByEmpId/{empId}")
    public Address getAddressByID(@PathVariable int empId){
        return addRepo.findByEmpId(empId);
    }
}
