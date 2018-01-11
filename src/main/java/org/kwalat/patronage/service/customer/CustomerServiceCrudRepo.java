package org.kwalat.patronage.service;

import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private List<Customer> customers;

    public List<Customer>getAll(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer get(long id){
        return customerRepository.findOne(id);
    }
    public void add(Customer customer){
        customerRepository.save(customer);
    }
    public void delete(long id){
        customerRepository.delete(id);
    }
    public void update(long id, Customer customer){
        customerRepository.save(customer);
    }
}
