package com.example.marketplace.service;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;

import java.util.List;


public interface SearchService {
    public List<Product> getAllProductsBySearch(String intput_search);

    public List<Product> getAllProductsByCondition(String intput_search,String application,String type,String mounting_location,String accessories,String minModelYear, String maxModelYear,Integer minAirflow, Integer maxAirflow,Integer minPower, Integer maxPower,Integer minOperatingVoltage,Integer maxOperatingVoltage,Integer minFanSpeed, Integer maxFanSpeed);

    public List<Product> getProductsByProjectId(int project_id);
    public List<Project> getProjectsByProductId(int product_id);
}
