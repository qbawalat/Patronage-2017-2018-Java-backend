package org.kwalat.patronage.customer;

import org.kwalat.patronage.customer.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();

    public Customer get(Long id);

    public void add(Customer car);

    public void delete(Long id);

    public void update(Long id, Customer car);
}
