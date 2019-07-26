package com.company.productservice.controller;

import com.company.productservice.dao.ProductDao;
import com.company.productservice.exception.NotFoundException;
import com.company.productservice.model.Product;
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
@RequestMapping("/products")
@CacheConfig(cacheNames = {"productcache"})
public class ProductController {
    @Autowired
    ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @CachePut(key = "#result.getProductId()")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productDao.addProduct(product);
    }

    @Cacheable
    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable("productId") int productId) {
        Product product = productDao.getProduct(productId);
        if(product == null){
            throw new NotFoundException("Product could not be retrieved for id " + productId);
        }
        return product;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }


    @CacheEvict(key = "#product.getProductId()")
    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        product.setProductId(productId);
        if(product.getProductId()==0){
            product.setProductId(productId);
        }
        if(productId !=product.getProductId()){
            throw new IllegalArgumentException("Product ID on path must match the id on the product object");
        }
        productDao.updateProduct(product);
    }

    @CacheEvict
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") int productId) {
        productDao.deleteProduct(productId);
    }
}
