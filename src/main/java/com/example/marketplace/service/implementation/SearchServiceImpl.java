package com.example.marketplace.service.implementation;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;
import com.example.marketplace.model.ProjectProduct;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.ProjectProductRepository;
import com.example.marketplace.repository.ProjectRepository;
import com.example.marketplace.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    ProductRepository productrepository;
    @Autowired
    ProjectRepository projectrepository;
    @Autowired
    ProjectProductRepository projectproductrepository;


    @Override
    public List<Product> getAllProductsBySearch(String intput_search){

        return productrepository.findBySearch(intput_search);


    }
    @Override
    public List<Product> getAllProductsByCondition(String intput_search,String application,String type,String mounting_location,String accessories,String minModelYear, String maxModelYear, Integer minAirflow, Integer maxAirflow,Integer minPower, Integer maxPower,Integer minOperatingVoltage,Integer maxOperatingVoltage,Integer minFanSpeed, Integer maxFanSpeed){
        try{


            minModelYear="01/01/"+minModelYear; // Input String
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy"); // New Pattern
            java.util.Date date = sdf1.parse(minModelYear); // Returns a Date format object with the pattern
            java.sql.Date sqlminModelYear = new java.sql.Date(date.getTime());
            System.out.println(sqlminModelYear); // Outputs : 2013-02-01

            maxModelYear ="12/30/"+(Integer.valueOf(maxModelYear)+1);
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date2 = sdf2.parse(maxModelYear); // Returns a Date format object with the pattern
            java.sql.Date sqlmaxModelYear = new java.sql.Date(date2.getTime());
            System.out.println(sqlmaxModelYear); // Outputs : 2013-02-01
            return productrepository.findByCondition(intput_search,application,type,mounting_location,accessories,sqlminModelYear,sqlmaxModelYear, minAirflow,  maxAirflow, minPower, maxPower, minOperatingVoltage, maxOperatingVoltage, minFanSpeed, maxFanSpeed);

        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;



    }

    @Override
    public List<Product> getProductsByProjectId(int project_id){
        List<Product> productslist = new ArrayList<>();
        Project project=projectrepository.findByProjectid(project_id);
        List<ProjectProduct>  pairtlist= projectproductrepository.findByProject(project);
        for(ProjectProduct projectproduct:pairtlist){
            Product product = projectproduct.getProduct();
            productslist.add(product);
        }

        return productslist;
    }

    @Override
    public List<Project> getProjectsByProductId(int product_id){
        List<Project> projectslist = new ArrayList<>();
        Product product=productrepository.findByProductid(product_id);
        List<ProjectProduct>  pairtlist= projectproductrepository.findByProduct(product);
        for(ProjectProduct projectproduct:pairtlist){
            Project project = projectproduct.getProject();
            projectslist.add(project);
        }

        return projectslist;
    }
}
