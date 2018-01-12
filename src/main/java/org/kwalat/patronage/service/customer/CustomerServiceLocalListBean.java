package org.kwalat.patronage.service.customer;

import org.kwalat.patronage.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceLocalListBean implements CustomerService {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer("Jack", "Bauer", "male", "97123008537"),
            new Customer("Chloe", "O'Brian", "female", "97123002533")
    ));

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
