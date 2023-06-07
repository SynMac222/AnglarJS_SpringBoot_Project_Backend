package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;
import com.example.marketplace.model.ProjectProduct;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.ProjectProductRepository;
import com.example.marketplace.repository.ProjectRepository;
import com.example.marketplace.service.ProductsService;
import com.example.marketplace.service.ProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/projectproduct")
public class ProjectProductController {

    @Autowired
    private ProjetsService projetsservice;

    @Autowired
    private ProductsService productsservice;

    @Autowired
    private ProjectProductRepository projectproductrepository;

    @PostMapping(value= "/add/{project_id}/{product_id}")
    public ProjectProduct createProduct(@PathVariable("project_id") int project_id,@PathVariable("product_id") int product_id){

        Project project = this.projetsservice.findOneByID(project_id);
        Product product = this.productsservice.findOneById(product_id);

        if(project==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user was found with the given ID");
        }

        ProjectProduct projectproduct=new ProjectProduct(1,project,product);

        return projectproductrepository.save(projectproduct);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") int id){

        projectproductrepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}