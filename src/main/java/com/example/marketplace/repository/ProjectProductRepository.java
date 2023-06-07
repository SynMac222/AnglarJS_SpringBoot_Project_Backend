package com.example.marketplace.repository;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;
import com.example.marketplace.model.ProjectProduct;
import com.example.marketplace.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ProjectProductRepository extends CrudRepository<ProjectProduct,Integer> {

    // two find by productID, by projectID. n
    List<ProjectProduct> findByProject(Project project);
    List<ProjectProduct> findByProduct(Product product);

}
