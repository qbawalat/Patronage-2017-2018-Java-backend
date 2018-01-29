package org.kwalat.patronage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "customer", description = "Rest API for customer operations", tags = "Customer API")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Request is not valid"),
        @ApiResponse(code = 500, message = "Request is valid, but can't be processed now"),
        @ApiResponse(code = 503, message = "The server is undergoing maintenance."),
})
public class CustomerController {

    @Qualifier("customerServiceH2Bean")
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display all customers", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customers displayed"),
            @ApiResponse(code = 404, message = "Customers not found")
    })
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Display customer", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The customer was displayed."),
            @ApiResponse(code = 404, message = "This customer was not found"),
            @ApiResponse(code = 410, message = "The customer has been intentionally moved")
    })
    public Customer get(@PathVariable Long id) {
        return customerService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    @ApiOperation(value = "Add customer", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Customer added")
    })
    public void add(@RequestBody Customer customer) {
        customerService.add(customer);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    @ApiOperation(value = "Delete customer", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "The customer has been deleted"),
            @ApiResponse(code = 404, message = "The customer was not found")
    })
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    @ApiOperation(value = "Modify customer", response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The customer has been modified"),
            @ApiResponse(code = 304, message = "The same customer already exists")
    })
    public void update(@RequestBody Customer customer, @PathVariable Long id) {
        customerService.update(id, customer);
    }

}
