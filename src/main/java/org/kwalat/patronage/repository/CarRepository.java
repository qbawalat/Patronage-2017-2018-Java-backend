package org.kwalat.patronage.repository;

import org.kwalat.patronage.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findByLicenceNumber(String licenceNumber);
}
