package com.example.marketplace.repository;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Project;
import com.example.marketplace.model.ProjectProduct;
import com.example.marketplace.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project,Integer> {

// findby product,  find project by username, find project by userid,list

    Project findByProjectid(int project_id);
    Set<Project> findByUser(User user);

    Set<Project> findByprojectnameLike(String projetname);


}
