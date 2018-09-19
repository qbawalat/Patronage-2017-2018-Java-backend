package org.kwalat.patronage.customer;

import org.kwalat.patronage.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
    public Customer findByLastName(String lastName);
}
