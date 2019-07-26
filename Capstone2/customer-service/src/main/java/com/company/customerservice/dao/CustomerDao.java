package com.company.customerservice.dao;

import com.company.customerservice.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer addCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

    void updateCustomer(Customer customer);

    List<Customer> getAllCustomer();
}
