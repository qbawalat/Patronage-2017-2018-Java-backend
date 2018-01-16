package org.kwalat.patronage.controller;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/cars")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @RequestMapping("/cars/{id}")
    public Car get(@PathVariable Long id) {
        return carService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void add(@Valid @RequestBody Car car) {
        carService.add(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
    public void update(@Valid @RequestBody Car car, @PathVariable Long id) {
        carService.update(id, car);
    }

}
