package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.Item;
import edu.icet.crm.model.ItemCreate;
import edu.icet.crm.model.SuccessResponse;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/by-id")
    public SuccessResponse byId(@RequestParam(name = "id") Long id){
        Customer customer = customerService.searchById(id);

        return SuccessResponse.builder()
                .status("Success")
                .result(customer)
                .build();

    }

    @GetMapping("/by-mobile")
    public SuccessResponse byMobile(@RequestParam(name = "mobile") String mobile){
        Customer customer = customerService.searchByMobile(mobile);

        return SuccessResponse.builder()
                .status("Success")
                .result(customer)
                .build();

    }

    @GetMapping("/all-mobiles")
    public SuccessResponse getAllMobiles(){
        List<String> customer = customerService.getAllMobiles();

        return SuccessResponse.builder()
                .status("Success")
                .result(customer)
                .build();
    }

    @PostMapping
    public SuccessResponse persist(@RequestBody Customer customer){
        Customer savedCustomer = customerService.persist(customer);

        return SuccessResponse.builder()
                .status("Success")
                .result(savedCustomer)
                .build();
    }

    @PutMapping
    public SuccessResponse update(@RequestBody Customer customer){
        Customer savedCustomer = customerService.update(customer);

        return SuccessResponse.builder()
                .status("Success")
                .result(savedCustomer)
                .build();
    }

    @DeleteMapping
    public SuccessResponse delete(@RequestParam(name = "id") Long id){
        customerService.delete(id);

        return SuccessResponse.builder()
                .status("Success")
                .result("Deleted")
                .build();
    }
}
