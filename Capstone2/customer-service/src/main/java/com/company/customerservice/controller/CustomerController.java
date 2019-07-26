package com.company.customerservice.controller;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.exception.NotFoundException;
import com.company.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/customer")
@CacheConfig(cacheNames = {"customercache"})
public class CustomerController {
    @Autowired
    CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @CachePut(key = "#result.getCustomerId()")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer){
        return customerDao.addCustomer(customer);
    }

    @Cacheable
    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        Customer customer = customerDao.getCustomer(customerId);
        if(customer == null){
            throw new NotFoundException("Customer could not be retrieved for id " + customerId);
        }
        return customer;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }

    @CacheEvict(key = "#customer.getCustomerId()")
    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer){
        if(customer.getCustomerId() == 0){
            customer.setCustomerId(customerId);
        }
        if(customerId != customer.getCustomerId()){
            throw new IllegalArgumentException("Customer ID on path must match the ID in the customer object");
        }
        customerDao.updateCustomer(customer);
    }

    @CacheEvict
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerDao.deleteCustomer(customerId);
    }

}
