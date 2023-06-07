package com.example.marketplace.repository;

import com.example.marketplace.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface TechnicalDetailRepository  extends CrudRepository<Product,Integer> {


}
