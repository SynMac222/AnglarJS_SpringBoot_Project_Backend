package com.example.marketplace.service;

import com.example.marketplace.model.Product;


import java.util.HashMap;
import java.util.List;

public interface ProductsService {

    Product findOneById(int id);

    public List<Product> getAllProducts();

    public Product addProduct(HashMap<String, String> project);

//     public Product updateProduct(int product_id, HashMap<String, String> project);

    public void deleteProduct(int product_id);

    public Product updateProduct(int id, HashMap<String, String> product);
}
