package com.example.marketplace.repository;

import com.example.marketplace.model.Description;
import com.example.marketplace.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
//    String findAllByProduct_id(int Product_id);
//    List<Project> findByProduct_id(int Product_id);

// find by brand -> list,  fin yb certification, by description, combination,
    Product findByProductid(int productid);

    List<Product> findByProductbrandLike(String product_brand);

    List<Product> findByCertification(String certification);

    Product findByDescription(Description description);

    @Query ("SELECT p FROM Product p WHERE p.certification like %?1%")
    List<Product> findByCertif(String certification);

    @Query ("SELECT p FROM Product p join p.description d on p.productname like %?1% or p.productbrand like %?1% or p.certification like %?1% or d.model like %?1% or d.manufacturer like %?1%  or d.series like %?1%" )
    List<Product> findBySearch(String input_search);

    @Query ("SELECT p FROM Product p join p.description d on p.productname = ?1 join p.producttype pt on pt.application = ?2 and pt.type =?3 and pt.mounting_location =?4 and pt.accessories =?5 and pt.model_year between ?6 and ?7 join p.technicaldetail td on td.airflow between ?8 and ?9 and td.power between ?10 and ?11 and td.operating_voltage between ?12 and ?13 and td.fan_speed between ?14 and ?15" )
    List<Product> findByCondition(String intput_search, String application, String type, String mounting_location, String accessories, Date minModelYear, Date maxModelYear,Integer minAirflow, Integer maxAirflow,Integer minPower, Integer maxPower,Integer minOperatingVoltage,Integer maxOperatingVoltage,Integer minFanSpeed, Integer maxFanSpeed);

//or p.productbrand like %?1% or p.certification like %?1% or d.model like %?1% or d.manufacturer like %?1%  or d.series like %?1%
}
