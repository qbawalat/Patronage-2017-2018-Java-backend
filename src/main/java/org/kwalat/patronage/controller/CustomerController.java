package org.kwalat.patronage.controller;

import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.service.customer.CustomerServiceCrudRepo;
import org.kwalat.patronage.service.customer.CustomerServiceListaLokalna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceListaLokalna customerServiceCrudRepo;

    @RequestMapping("/customers")
    public List<Customer> getAll(){
        return customerServiceCrudRepo.getAll();
    }

    @RequestMapping("/customers/{id}")
    public Customer get(@PathVariable  Long id){
        return customerServiceCrudRepo.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/customers")
    public void add(@RequestBody Customer customer){
        customerServiceCrudRepo.add(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/customers/{id}")
    public void delete(@PathVariable Long id){
        customerServiceCrudRepo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/customers/{id}")
    public void update(@RequestBody Customer customer, @PathVariable Long id){
        customerServiceCrudRepo.update(id, customer);
    }

}
