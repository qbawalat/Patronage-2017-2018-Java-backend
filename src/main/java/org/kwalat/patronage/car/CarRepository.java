package org.kwalat.patronage.car;

import org.kwalat.patronage.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findByLicenceNumber(String licenceNumber);
}
