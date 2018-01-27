package org.kwalat.patronage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/api")
@Api(value = "car", description = "Rest API for car operations", tags = "Car API")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display all cars", response = Car.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Resources not found")})
    public List<Car> getAll() {
        return carService.getAll();
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display car", response = Car.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "The resource not found")})
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
