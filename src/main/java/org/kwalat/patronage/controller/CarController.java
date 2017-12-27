package org.kwalat.patronage.controller;

import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/cars")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @RequestMapping("/cars/{id}")
    public Car get(@PathVariable  long id){
        return carService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/cars")
    public void add(@RequestBody Car car){
        carService.add(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/cars/{id}")
    public void delete(@PathVariable long id){
        carService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/cars/{id}")
    public void update(@RequestBody Car car){
        carService.update(car);
    }

}
