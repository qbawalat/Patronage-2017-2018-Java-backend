package org.kwalat.patronage.car;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "car", description = "Rest API for car operations", tags = "Car API")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Request is not valid"),
        @ApiResponse(code = 500, message = "Request is valid, but can't be processed now"),
        @ApiResponse(code = 503, message = "The server is undergoing maintenance."),
})
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display all cars", response = Car.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cars displayed"),
            @ApiResponse(code = 404, message = "Cars not found")
    })
    public List<Car> getAll() {
        return carService.getAll();
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display car", response = Car.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The car was displayed."),
            @ApiResponse(code = 404, message = "This car was not found"),
            @ApiResponse(code = 410, message = "The car has been intentionally moved")
    })
    public Car get(@PathVariable Long id) {
        return carService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    @ApiOperation(value = "Add car", response = Car.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Car added")
    })
    public void add(@Valid @RequestBody Car car) {
        carService.add(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
    @ApiOperation(value = "Delete car", response = Car.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "The car has been deleted"),
            @ApiResponse(code = 404, message = "The car was not found")
    })
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
    @ApiOperation(value = "Modify car", response = Car.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The car has been modified"),
            @ApiResponse(code = 304, message = "The same customer already exists")
    })
    public void update(@Valid @RequestBody Car car, @PathVariable Long id) {
        carService.update(id, car);
    }

}
