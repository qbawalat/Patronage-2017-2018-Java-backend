package org.kwalat.patronage.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceLocalListBean implements CustomerService {

    private static Long nextId = 0L;
    private List<Customer> customers = new ArrayList<Customer>();

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer get(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().get();
    }

    @Override
    public void add(Customer customer) {
        nextId = nextId + 1L;
        customer.setId(nextId);
        customers.add(customer);
    }

    @Override
    public void delete(Long id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }

    @Override
    public void update(Long id, Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer currentCustomer = customers.get(i);
            if (currentCustomer.getId().equals(id)) {
                customers.set(i, customer);
                return;
            }
        }
    }
}