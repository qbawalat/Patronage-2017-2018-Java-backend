package org.kwalat.patronage.service.car;

import org.kwalat.patronage.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceLocalListBean implements CarService {

    private static Long nextId = 0L;
    private List<Car> cars = new ArrayList<>();

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
        nextId = nextId + 1L;
        car.setId(nextId);
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