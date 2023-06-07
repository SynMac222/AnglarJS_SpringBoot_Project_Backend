package com.example.marketplace.controller;

import com.example.marketplace.model.Project;
import com.example.marketplace.model.Role;
import com.example.marketplace.repository.ProjectRepository;
import com.example.marketplace.service.UserDetailService;
import com.example.marketplace.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.marketplace.model.User;
import com.example.marketplace.service.GetUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired private GetUsersService getuserservice;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtilToken;

    @Autowired
    ProjectRepository projectrepository;



    @GetMapping("/test")
    public String test(){
        return "This API is working fine";
    }
//move it to search controller
//    @GetMapping("/getAll")
//    public List<User> getAllUsers(){
//        return getuserservice.getAllUsers();
//    }

    // save user , add user, update user by name CRUD, Authentication. delete
    @PostMapping(value= "/addUser",consumes = {"application/json"})
    public ResponseEntity<Object> ceateUsers(@RequestBody HashMap<String, String> user){

        User userresult = getuserservice.addUser(user);
        return new ResponseEntity<>(userresult,HttpStatus.OK);

    }

    @PutMapping(value ="/update/{id}",consumes = {"application/json"})
    public ResponseEntity<User> updateUserById(@PathVariable("id") int id,@RequestBody HashMap<String, String> user){

        User userresult = getuserservice.updateUser(id,user);
        return new ResponseEntity<>(userresult,HttpStatus.OK);

    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") int id){
//
//        getuserservice.deleteUser(id);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//
//    }


    //=====================New API MAY-11th=================================

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception{
        String username = user.getUsername();
        String password = user.getUser_password();

        System.out.println(username);
        System.out.println(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(username);
        final String jwt = jwtUtilToken.generateToken(userDetails);

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String user(){
        return "Hello, user!";
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return this.getuserservice.save(user);
    }


    @PostMapping("/createUser")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (getuserservice.findByName(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
//        user.setUsertype(Role.USER);
        if(user.getUser_type().equals("ADMIN")){
            user.setUsertype(Role.ADMIN);
        }
        else if(user.getUser_type().equals("USER")){
            user.setUsertype(Role.USER);
        }
        else if(user.getUser_type().equals("Manager")){
            user.setUsertype(Role.Manager);
        }
        else if(user.getUser_type().equals("Designer")){
            user.setUsertype(Role.Designer);
        }
        return new ResponseEntity<>(getuserservice.save(user), HttpStatus.CREATED);
    }


        @PostMapping("/addProject/{id}")
    public Project addProjectToUser(@PathVariable Integer id, @RequestBody Project project){
        User user = this.getuserservice.findOneById(id);

        if(user==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user was found with the given ID");
        }

//        user.addProject(project);
        project.setUser(user);
        this.projectrepository.save(project);
        return project;
    }

    @PutMapping("/update/{id}/{name}")
    public User update(@PathVariable Integer id, @PathVariable String name){
        User user = this.getuserservice.update(id, name);

        if(user==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user was found with the given ID");
        }

        return user;
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable Integer id){
        User user = this.getuserservice.delete(id);

        if(user==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user was found with the given ID");
        }

        return user;
    }

    @PutMapping("/changeUser/{id}")
    public User changeUser(@PathVariable Integer id, @RequestBody User user){
        User changeUser = this.getuserservice.changeUser(id, user);

        if(changeUser==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user was found with the given ID");
        }
        return changeUser;
    }







}
