package org.kwalat.patronage.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findByLicenceNumber(String licenceNumber);
}
