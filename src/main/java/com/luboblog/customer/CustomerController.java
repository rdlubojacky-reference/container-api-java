package com.luboblog.customer;

import com.luboblog.customer.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        
        return new ResponseEntity<Customer>(repository.findByFirstName(firstName), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(Customer customer) { 
        return new ResponseEntity<Customer>(repository.save(customer), HttpStatus.OK);
    }
}