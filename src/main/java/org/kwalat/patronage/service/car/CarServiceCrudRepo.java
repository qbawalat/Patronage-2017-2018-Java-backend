package org.kwalat.patronage.service.car;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceCrudRepo implements CarServiceH2 {
    @Autowired
    private CarRepository carRepository;
    private List<Car> cars;

    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
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
