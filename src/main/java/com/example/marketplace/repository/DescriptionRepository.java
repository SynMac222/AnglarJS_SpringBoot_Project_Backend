package com.example.marketplace.repository;

import com.example.marketplace.model.Description;
import com.example.marketplace.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DescriptionRepository extends CrudRepository<Description,Integer> {

    List<Description> findByManufacturer(String manufacturer);

    List<Description> findByModelLike(String model);

    List<Description> findBySeries(String series);
}