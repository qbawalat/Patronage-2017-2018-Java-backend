package org.kwalat.patronage.service;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    private List<Car> cars;

    public List<Car>getAll(){
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    public Car get(long id){
        return carRepository.findOne(id);
    }
    public void add(Car car){
            carRepository.save(car);
    }
    public void delete(long id){
        carRepository.delete(id);
    }
    public void update(long id, Car car){
        carRepository.save(car);
    }
}
