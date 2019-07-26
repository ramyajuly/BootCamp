package com.company.customerservice.controller;

import com.company.customerservice.dao.CustomerDao;
import com.company.customerservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerDao customerDao;

    @Test
    public void customerGetRoute() throws Exception {
        Customer actualCustomer = new Customer("firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222");

        Customer expectedCustomer = new Customer(actualCustomer.getCustomerId(), "firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222");
        when(customerDao.getCustomer(1)).thenReturn(expectedCustomer);


        this.mockMvc.perform(get("/customer/{customerId}", 1).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.firstName", is("firstName")));
    }

    @Test
    public void customerPostRoute() throws Exception {
        Customer actualCustomer = new Customer("firstName", "lastName",
                "street", "city", "zip", "email", "phone");

        Customer expectedCustomer = new Customer(1, "firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222");

        when(customerDao.addCustomer(actualCustomer)).thenReturn(expectedCustomer);
        this.mockMvc.perform(post("/customer")
                .content(asJsonString(actualCustomer))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(asJsonString(expectedCustomer)))
                .andExpect(jsonPath("$.firstName", is("firstName")));
    }


    @Test
    public void customerPutRoute() throws Exception {
        Customer customer = new Customer(1, "firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222");
        doNothing().when(customerDao).updateCustomer(customer);
        this.mockMvc.perform(put("/customer/{customerId}", customer.getCustomerId()).content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void customerDeleteRoute() throws Exception {
        Customer customer = new Customer(1, "firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222");
        doNothing().when(customerDao).deleteCustomer(customer.getCustomerId());

        this.mockMvc.perform(delete("/customer/{customerId}", customer.getCustomerId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer))).andExpect(status().isNoContent());
    }

    @Test
    public void customerGetAllRoute() throws Exception {
        List<Customer> actualCustomerList = Arrays.asList(new Customer(1,"firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222"), new Customer(2,"firstName", "lastName",
                "street", "city", "zip", "email@email", "2222222222"));
        when(customerDao.getAllCustomer()).thenReturn(actualCustomerList);
        this.mockMvc.perform(get("/customer"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerId", is(1)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
