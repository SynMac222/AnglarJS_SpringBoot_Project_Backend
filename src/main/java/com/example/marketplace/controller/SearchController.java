package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;
import com.example.marketplace.model.User;
import com.example.marketplace.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchservice;
    @Autowired
    private ProductsService productsservice;
    @Autowired
    private GetUsersService getuserservice;
    @Autowired
    private ProjetsService projetsservice;


    @GetMapping(value = "/search")
    public List<Product> searchProductsBySearch(@RequestParam("input_search") String intput_search){

        return searchservice.getAllProductsBySearch(intput_search);


    }

    @GetMapping(value = "/condition")
    public List<Product> searchProductsByCondition(@RequestParam("input_search") String intput_search, @RequestParam("application") String application, @RequestParam("type") String type, @RequestParam("mounting_location") String mounting_location, @RequestParam("accessories") String accessories, @RequestParam("minModelYear") String minModelYear, @RequestParam("maxModelYear") String maxModelYear,@RequestParam("minAirflow") Integer minAirflow,@RequestParam("maxAirflow") Integer maxAirflow,@RequestParam("minPower") Integer minPower,@RequestParam("maxPower") Integer maxPower,@RequestParam("minOperatingVoltage") Integer minOperatingVoltage,@RequestParam("maxOperatingVoltage") Integer maxOperatingVoltage,@RequestParam("minFanSpeed") Integer minFanSpeed,@RequestParam("maxFanSpeed") Integer maxFanSpeed){

        return searchservice.getAllProductsByCondition(intput_search,application,type,mounting_location,accessories,minModelYear,maxModelYear, minAirflow,  maxAirflow, minPower, maxPower, minOperatingVoltage, maxOperatingVoltage, minFanSpeed, maxFanSpeed);


    }



    @GetMapping("products/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> projetslist = productsservice.getAllProducts();

        return new ResponseEntity<>(projetslist, HttpStatus.OK);
    }

    @GetMapping("/projects/getAll")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projetslist = projetsservice.getAllProjects();

        return new ResponseEntity<>(projetslist, HttpStatus.OK);
    }

    @GetMapping("/users/getAll")
    public List<User> getAllUsers(){
        return getuserservice.getAllUsers();
    }



    @GetMapping(value = "/getProductsByProjectId")
    public List<Product> getProductsByProjectId(@RequestParam("ProjectId") int project_id){
        return searchservice.getProductsByProjectId(project_id);
    }


    @GetMapping(value = "/getProjectsByProductId")
    public List<Project> getProjectsByProductId(@RequestParam("ProductId") int product_id){
        return searchservice.getProjectsByProductId(product_id);
    }


}
