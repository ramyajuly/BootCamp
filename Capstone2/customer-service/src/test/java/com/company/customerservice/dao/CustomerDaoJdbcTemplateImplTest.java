package com.company.customerservice.dao;

import com.company.customerservice.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoJdbcTemplateImplTest {
    @Autowired
    CustomerDao customerDao;

    @Before
    public void setUp() {
        List<Customer> customerList = customerDao.getAllCustomer();
        for (Customer customer : customerList) {
            customerDao.deleteCustomer(customer.getCustomerId());
        }
    }

    @Test
    public void getAddDeleteCustomer() {
        Customer actualCustomer = new Customer("firstName", "lastName",
                "street", "city", "zip", "email", "phone");
        customerDao.addCustomer(actualCustomer);
        Customer expectedCustomer = new Customer(actualCustomer.getCustomerId(), "firstName", "lastName",
                "street", "city", "zip", "email", "phone");
        Assert.assertEquals(expectedCustomer, actualCustomer);
        customerDao.deleteCustomer(actualCustomer.getCustomerId());
        Assert.assertNull(customerDao.getCustomer(actualCustomer.getCustomerId()));
    }

    @Test
    public void updateCustomer() {
        Customer actualCustomer = new Customer("firstName", "lastName",
                "street", "city", "zip", "email", "phone");
        customerDao.addCustomer(actualCustomer);
        actualCustomer.setFirstName("updatedFirstName");
        actualCustomer.setLastName("updatedLastName");
        actualCustomer.setStreet("updatedStreet");
        actualCustomer.setCity("updatedCity");
        actualCustomer.setZip("updatedZip");
        actualCustomer.setEmail("updatedEmail");
        actualCustomer.setPhone("updatedPhone");

        customerDao.updateCustomer(actualCustomer);
        Customer expectedCustomer = customerDao.getCustomer(actualCustomer.getCustomerId());
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void getAllCustomer() {
        List<Customer> actualCustomerList = new ArrayList<>();
        actualCustomerList.add(customerDao.addCustomer(new Customer("firstName", "lastName",
                "street", "city", "zip", "email", "phone")));
        actualCustomerList.add(customerDao.addCustomer(new Customer("firstName", "lastName",
                "street", "city", "zip", "email", "phone")));
        Assert.assertEquals(2, actualCustomerList.size());
    }
}
