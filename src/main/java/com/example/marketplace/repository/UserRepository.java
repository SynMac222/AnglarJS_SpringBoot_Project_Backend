package com.example.marketplace.repository;

import com.example.marketplace.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
//    List<User> findByUsername(String username);

    User findByUserid(int id);

//    User findAll, findUserbytype, findby Name and type,

    List<User> findAllByUsername(String Username);

    List<User>  findAllByUsertype(String usertype);

    List<User>  findAllByUsertypeAndUsername(String usertype,String username);



    //=================New repo method======================
    Optional<User> findByUsername(String name); // need to fix the deplicate name problem?


}
