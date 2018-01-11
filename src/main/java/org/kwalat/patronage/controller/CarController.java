package org.kwalat.patronage.controller;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.service.car.CarServiceCrudRepo;
import org.kwalat.patronage.service.car.CarServiceListaLokalna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarServiceCrudRepo carServiceCrudRepo;

    @RequestMapping("/cars")
    public List<Car> getAll() {
        return carServiceCrudRepo.getAll();
    }

    @RequestMapping("/cars/{id}")
    public Car get(@PathVariable Long id) {
        return carServiceCrudRepo.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void add(@RequestBody Car car) {
        carServiceCrudRepo.add(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
    public void delete(@PathVariable Long id) {
        carServiceCrudRepo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
    public void update(@RequestBody Car car, @PathVariable Long id) {
        carServiceCrudRepo.update(id, car);
    }

}
