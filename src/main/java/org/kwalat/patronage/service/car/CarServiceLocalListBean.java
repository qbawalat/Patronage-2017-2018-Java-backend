package org.kwalat.patronage.service.car;

import org.kwalat.patronage.conditions.LocalListServiceCondition;
import org.kwalat.patronage.model.Car;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Conditional(value = LocalListServiceCondition.class)
class CarServiceLocalListBean implements CarService {

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
    public void add(@Valid @RequestBody Car car) {
        nextId = nextId + 1L;
        car.setId(nextId);
        cars.add(car);
    }

    @Override
    public void delete(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    @Override
    public void update(Long id, @Valid @RequestBody Car car) {
        for (int i = 0; i < cars.size(); i++) {
            Car currentCar = cars.get(i);
            if (currentCar.getId().equals(id)) {
                cars.set(i, car);
                return;
            }
        }
    }
}