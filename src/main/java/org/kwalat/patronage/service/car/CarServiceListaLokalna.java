package org.kwalat.patronage.service.car;

import org.kwalat.patronage.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceListaLokalna implements CarServiceH2 {
    private List<Car> cars = new ArrayList<>(Arrays.asList(new Car("50-6999", "HONDA", 4, "1900-01-01", "1900-01-01", "ZS502525"), new Car("50-3999", "SKODA", 6, "1901-01-01", "1901-01-01", "GZ502255")));

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public Car get(Long id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst().get();
    }

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public void delete(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    @Override
    public void update(Long id, Car car) {
        for (int i = 0; i < cars.size(); i++) {
            Car currentCar = cars.get(i);
            if (currentCar.getId().equals(id)) {
                cars.set(i, car);
                return;
            }
        }
    }
}