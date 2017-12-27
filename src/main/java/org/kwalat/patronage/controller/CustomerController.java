package org.kwalat.patronage.controller;

import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.repository.CustomerRepository;
import org.kwalat.patronage.service.CustomerService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @RequestMapping("/customers/{id}")
    public Customer get(@PathVariable  long id){
        return customerService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/customers")
    public void add(@RequestBody Customer customer){
        customerService.add(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/customers/{id}")
    public void delete(@PathVariable long id){
        customerService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/customers/{id}")
    public void update(@RequestBody Customer customer){
        customerService.update(customer);
    }

}
