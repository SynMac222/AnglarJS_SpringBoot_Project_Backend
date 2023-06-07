package com.example.marketplace.service.implementation;

import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import com.example.marketplace.service.GetUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class GetUsersImpl implements GetUsersService {
    @Autowired UserRepository userrepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers( ){
        List<User> relist = new ArrayList<>();
        for(User user:userrepository.findAll()){
            relist.add(user);
        }
        return relist;
    }

    // Method CRUD , PROJECTS ,products ,PROJECTS products
    // r

    public User addUser(HashMap<String, String> user){
        Role role = Role.USER;
        System.out.println(user.get("user_type"));
        if(user.getOrDefault("user_type","USER").equals("ADMIN")){
                 role = Role.ADMIN;
        }
        else if(user.getOrDefault("user_type","USER").equals("USER")){
             role = Role.USER;
        }
        else if(user.getOrDefault("user_type","USER").equals("Manager")){
             role = Role.Manager;
        }
        else if(user.getOrDefault("user_type","USER").equals("Designer")){
             role = Role.Designer;
        }
        User user1 = new User(user.get("username"), role,user.get("user_password"));
        System.out.println("Add User");
        System.out.println("---------------------------------------");
        User useradded = userrepository.save(user1);
        System.out.println(useradded);
        return useradded;
    }

    public User updateUser(int id, HashMap<String, String> user){
        User user1 = new User(user.get("username"),Role.USER,user.get("user_password"));
        user1.setUserid(id);
        System.out.println("Update User");
        System.out.println("---------------------------------------");
        User userupdated = userrepository.save(user1);
        System.out.println(userupdated);
        return userupdated;
    }

    public void deleteUser(int id){
        userrepository.deleteById(String.valueOf(id));


    }



    //==============================New Implementation MAY 11th=====================

//    public List<User> findAll(){ return this.userrepository.findAll();
//    }

    public User findOneById(Integer id){
        return this.userrepository.findById(String.valueOf(id)).orElse(null);
    }

    public User findByName(String name){
        return this.userrepository.findByUsername(name).orElse(null);
    }

    public List<User> findByType(String type){
        return this.userrepository.findAllByUsertype(type);
    }

    public List<User> findByNameAndType(String name, String type){
        return this.userrepository.findAllByUsertypeAndUsername(type,name);
    }



    @Override
    public User save(User user){
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        return this.userrepository.save(user);
    }


    @Override
    public User update(Integer id, String name) {
        Optional<User> userToUpdateOptional = this.userrepository.findById(String.valueOf(id));

        if(!userToUpdateOptional.isPresent()){
            return null;
        }

        User userToUpdate = userToUpdateOptional.get();
        userToUpdate.setUsername(name);
        User updatedUser = this.userrepository.save(userToUpdate);
        return updatedUser;
    }


    public User changeUser(Integer id, User user) {
        Optional<User> userToChangeOptional = this.userrepository.findById(String.valueOf(id));

        if(!userToChangeOptional.isPresent()){
            return null;
        }

        User userToChange = userToChangeOptional.get();
        userToChange.setUsername(user.getUsername());
        userToChange.setUsertype(user.getUser_type());
        userToChange.setUser_password(user.getUser_password());
        return this.userrepository.save(userToChange);
    }

    public User delete(Integer id){
        Optional<User> userToDeleteOptional = this.userrepository.findById(String.valueOf(id));

        if(!userToDeleteOptional.isPresent()){
            return null;
        }

        User userToDelete = userToDeleteOptional.get();
        this.userrepository.delete(userToDelete);
        return userToDelete;
    }


}
