package com.company.productservice.dao;

import com.company.productservice.model.Product;

import java.util.List;

public interface ProductDao {
    Product addProduct(Product product);

    Product getProduct(int productId);

    List<Product> getAllProduct();

    void updateProduct(Product product);

    void deleteProduct(int productId);
}
