package org.kwalat.patronage.repository;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
    public Customer findByLastName(String lastName);
}
