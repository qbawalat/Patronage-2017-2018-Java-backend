package org.kwalat.patronage.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceH2Bean implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer get(Long id) {
        return customerRepository.findOne(id);
    }

    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }

    public void update(Long id, Customer customer) {
        customerRepository.save(customer);
    }
}
