package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;
import com.example.marketplace.service.ProductsService;
import com.example.marketplace.service.ProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    private ProductsService productsservice;
    // move it to search
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        List<Product> projetslist = productsservice.getAllProducts();
//
//        return new ResponseEntity<>(projetslist, HttpStatus.OK);
//    }

    @PostMapping(value= "/addProduct",consumes = {"application/json"})
    public ResponseEntity<Product> createProduct(@RequestBody HashMap<String, String> product){

        Product result = productsservice.addProduct(product);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @PutMapping(value ="/update/{id}",consumes = {"application/json"})
    public ResponseEntity<Product> updateUserById(@PathVariable("id") int id,@RequestBody HashMap<String, String> product){

        Product result = productsservice.updateProduct(id,product);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") int id){

        productsservice.deleteProduct(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}


