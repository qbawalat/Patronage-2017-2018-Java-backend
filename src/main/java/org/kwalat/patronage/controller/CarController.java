package org.kwalat.patronage.controller;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.service.car.CarServiceH2Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarServiceH2Bean carServiceH2Bean;

    @RequestMapping("/cars")
    public List<Car> getAll() {
        return carServiceH2Bean.getAll();
    }

    @RequestMapping("/cars/{id}")
    public Car get(@PathVariable Long id) {
        return carServiceH2Bean.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void add(@RequestBody Car car) {
        carServiceH2Bean.add(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
    public void delete(@PathVariable Long id) {
        carServiceH2Bean.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
    public void update(@RequestBody Car car, @PathVariable Long id) {
        carServiceH2Bean.update(id, car);
    }

}
