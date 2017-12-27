package org.kwalat.patronage.repository;

import org.kwalat.patronage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
  //  List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}
