package org.kwalat.patronage.service.car;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceH2Bean implements CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car get(Long id) {
        return carRepository.findOne(id);
    }

    public void add(Car car) {
        carRepository.save(car);
    }

    public void delete(Long id) {
        carRepository.delete(id);
    }

    public void update(Long id, Car car) {
        carRepository.save(car);
    }
}
