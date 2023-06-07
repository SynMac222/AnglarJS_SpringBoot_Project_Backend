package com.example.marketplace.controller;

import com.example.marketplace.model.Project;
import com.example.marketplace.model.User;
import com.example.marketplace.service.GetUsersService;
import com.example.marketplace.service.ProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/projects")
public class ProjectsController {

    @Autowired
    private ProjetsService projetsservice;

    @GetMapping("/test")
    public String test(){
        return "This API is working fine";
    }
    //move it to search controller
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Project>> getAllProjects(){
//        List<Project> projetslist = projetsservice.getAllProjects();
//
//        return new ResponseEntity<>(projetslist, HttpStatus.OK);
//    }

    @PostMapping(value= "/addProject",consumes = {"application/json"})
    public ResponseEntity<Project> ceateUsers(@RequestBody HashMap<String, String> project){

        Project result = projetsservice.addProject(project);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @PutMapping(value ="/update/{id}",consumes = {"application/json"})
    public ResponseEntity<Project> updateUserById(@PathVariable("id") int id,@RequestBody HashMap<String, String> project){

        Project result = projetsservice.updateProject(id,project);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") int id){

        projetsservice.deletePorject(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


}
