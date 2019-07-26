package com.company.productservice.controller;

import com.company.productservice.dao.ProductDao;
import com.company.productservice.model.Product;
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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductDao productDao;

    @Test
    public void productGetRoute() throws Exception {
        Product expectProduct = new Product(1, "ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));

        when(productDao.getProduct(1)).thenReturn(expectProduct);
        this.mockMvc.perform(get("/products/{productId}", 1).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.productName", is("ProductName")));
    }

    @Test
    public void productPostRoute() throws Exception {
        Product actualProduct = new Product("ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));

        Product expectProduct = new Product(1, "ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));

        when(productDao.addProduct(actualProduct)).thenReturn(expectProduct);
        this.mockMvc.perform(post("/products")
                .content(asJsonString(actualProduct))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(asJsonString(expectProduct)))
                .andExpect(jsonPath("$.productName", is("ProductName")));
    }


    @Test
    public void productPutRoute() throws Exception {
        Product product = new Product(1, "ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));
        doNothing().when(productDao).updateProduct(product);
        this.mockMvc.perform(put("/products/{productId}", product.getProductId()).content(asJsonString(product))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }



        @Test
        public void productDeleteRoute() throws Exception {
            Product product = new Product(1, "ProductName", "ProductDescription",
                    new BigDecimal("12.23"), new BigDecimal("23.45"));
            doNothing().when(productDao).deleteProduct(product.getProductId());

            this.mockMvc.perform(delete("/products/{productId}", product.getProductId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(product))).andExpect(status().isNoContent());
        }

       @Test
       public void productGetAllRoute() throws Exception {
        List<Product> actualProductList = Arrays.asList(new Product(1,"ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45")),new Product(2,"ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45")));

           when(productDao.getAllProduct()).thenReturn(actualProductList);
           this.mockMvc.perform(get("/products"))
                   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                   .andExpect(jsonPath("$", hasSize(2)))
                   .andExpect(status().isOk())
                   .andExpect(jsonPath("$[0].productId", is(1)));
       }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
