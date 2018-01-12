package org.kwalat.patronage.service.car;

import org.kwalat.patronage.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    public List<Car> getAll();

    public Car get(Long id);

    public void add(Car car);

    public void delete(Long id);

    public void update(Long id, Car car);
}
