package com.company.productservice.dao;

import com.company.productservice.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoJdbcTemplateImplTest {
    @Autowired
    ProductDao productDao;

    @Before
    public void setUp() {
        List<Product> productList = productDao.getAllProduct();
        for (Product product : productList) {
            productDao.deleteProduct(product.getProductId());
        }
    }

    @Test
    public void getAddDeleteProduct() {
        Product actualProduct = new Product("ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));
        productDao.addProduct(actualProduct);

        Product expectProduct = new Product(actualProduct.getProductId(), "ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));

        Assert.assertEquals(expectProduct, actualProduct);
        productDao.deleteProduct(actualProduct.getProductId());
        Assert.assertNull(productDao.getProduct(actualProduct.getProductId()));
    }

    @Test
    public void updateProduct() {
        Product actualProduct = new Product("ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"));
        productDao.addProduct(actualProduct);

        actualProduct.setProductName("updatedProductName");
        actualProduct.setProductDescription("updatedProductdescription");
        actualProduct.setListPrice(new BigDecimal("40.00"));
        actualProduct.setUnitCost(new BigDecimal("46.00"));
        productDao.updateProduct(actualProduct);
        Product expectedProduct = productDao.getProduct(actualProduct.getProductId());
        Assert.assertEquals(expectedProduct, actualProduct);
    }




    @Test
    public void getAllProduct() {
        List<Product> actualProductList = new ArrayList<>();
        actualProductList.add(productDao.addProduct(new Product("ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"))));
        actualProductList.add(productDao.addProduct(new Product("ProductName", "ProductDescription",
                new BigDecimal("12.23"), new BigDecimal("23.45"))));
        Assert.assertEquals(2, actualProductList.size());
    }
}
