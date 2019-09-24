package com.example.demo.controller;

import com.example.demo.model.CustomerDto;
import com.example.demo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;


    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable("id") int id) {
        logger.info("deleteCustomer.start");
        customerService.deleteCustomer(id);
        ResponseEntity result = new ResponseEntity<Object>("Customer is deleted", HttpStatus.OK);
        logger.info("deleteCustomer.end");
        return result;
    }

    @GetMapping(value = "/customer")
    public ResponseEntity<CustomerDto> getCustomer() {
        logger.info("getCustomer.start");
        ResponseEntity result = new ResponseEntity<Object>(customerService.getCustomer(), HttpStatus.OK);
        logger.info("getCustomer.end");
        return result;
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        logger.info("createCustomer.start");
        customerService.addCustomer(customerDto);
        ResponseEntity result = new ResponseEntity<Object>("create object", HttpStatus.CREATED);
        logger.info("createCustomer.end");
        return result;
    }

    @PutMapping(value = "/customer/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDto customerDto) {
        logger.info("updateCustomer.start");
        customerService.updateCustomer(id, customerDto);
        ResponseEntity result = new ResponseEntity<Object>("update object", HttpStatus.OK);
        logger.info("updateCustomer.end");
        return result;
    }

    @PostMapping(value = "/customerFive")
    public ResponseEntity<CustomerDto> addCustomerInFiveSecond() {
        logger.info("createCustomer.start");
        customerService.addCustomerInFiveSecond();
        ResponseEntity result = new ResponseEntity<Object>("create object", HttpStatus.CREATED);
        logger.info("createCustomer.end");
        return result;
    }
}
