package com.example.marketplace.service.implementation;

import com.example.marketplace.MarketplaceApplication;
import com.example.marketplace.model.*;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.ProjectRepository;
import com.example.marketplace.repository.UserRepository;
import com.example.marketplace.service.ProductsService;
import com.example.marketplace.service.ProjetsService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductRepository productrepository;
    @Autowired
    UserRepository userrepository;

    private static final Logger log = LoggerFactory.getLogger(MarketplaceApplication.class);

    @Override
    public Product findOneById(int id){
        return productrepository.findByProductid(id);
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> productslist = new ArrayList<>();

        for(Product product:productrepository.findAll()){
            productslist.add(product);
        }

        return productslist;

    }
    @Override
    public Product addProduct(HashMap<String, String> product){
        JSONObject jsonObject = new JSONObject( product);
//        jsonObject.get("product_brand");


        Product productobj =new Product(product.get("product_name"),product.get("product_brand"),product.get("certification"),null,null,null);


        TechnicalDetail technicaldetail = new TechnicalDetail(Integer.parseInt(product.get("airflow")),Integer.parseInt(product.get("power")),Integer.parseInt(product.get("operating_voltage")),Integer.parseInt(product.get("fan_speed")),productobj);
        Description description = new Description(product.get("manufacture"),product.get("series"),product.get("model"),productobj);
        ProductType producttype = new ProductType(product.get("application"),product.get("type"),product.get("mounting_location"),product.get("accessories"), Date.valueOf(product.get("model_year")),productobj);
        productobj.setTechnicaldetail(technicaldetail);
        productobj.setDescription(description);
        productobj.setProducttype(producttype);
        return  productrepository.save(productobj);
    }
    @Override
    public Product updateProduct(int id, HashMap<String, String> product){
        productrepository.findById(id);
        Optional<Product> productToUpdateOptional = this.productrepository.findById(id);

        if(!productToUpdateOptional.isPresent()){
            return null;
        }

        Product productToUpdate = productToUpdateOptional.get();
        productToUpdate.setProductname(product.get("product_name"));
        productToUpdate.setProductbrand(product.get("product_brand"));
        productToUpdate.setCertification(product.get("certification"));
        Product updatedProduct = this.productrepository.save(productToUpdate);
        return updatedProduct;

    }

    @Override
    public void deleteProduct(int product_id){
        Product product = productrepository.findByProductid(product_id);
        System.out.println("Delete Product");
        System.out.println("---------------------------------------");
        System.out.println(product);
        productrepository.deleteById(product_id);
    }


}