package com.luboblog.customer;

import com.luboblog.customer.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    /*
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Customer> findCustomerById(@RequestParam(required = true) int id) {
        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }
    */

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Customer> findCustomerByFirstName(@RequestParam(required = true) String firstName) {
        log.info("firstName = " + firstName);
        Customer customer = repository.findByFirstName(firstName);

        if (customer != null) {
            log.info(customer.toString());
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) { 
        log.info(customer.toString());
        Customer savedCustomer = repository.save(customer);
        log.info("saved customer = " + savedCustomer.toString());
        return new ResponseEntity<Customer>(repository.save(customer), HttpStatus.OK);
    }
}