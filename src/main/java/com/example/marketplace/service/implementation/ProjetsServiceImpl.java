package com.example.marketplace.service.implementation;

import com.example.marketplace.MarketplaceApplication;
import com.example.marketplace.model.Project;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.ProjectRepository;
import com.example.marketplace.repository.UserRepository;
import com.example.marketplace.service.ProjetsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class ProjetsServiceImpl implements ProjetsService {
    @Autowired ProjectRepository projectrepository;
    @Autowired UserRepository userrepository;

    private static final Logger log = LoggerFactory.getLogger(MarketplaceApplication.class);


    public Project findOneByID(int id){
        return projectrepository.findByProjectid(id);
    }
    @Override
    public List<Project> getAllProjects(){
        List<Project> projectlist = new ArrayList<>();

        for(Project project:projectrepository.findAll()){
            projectlist.add(project);

        }

        return projectlist;

    }
    @Override
    public Project addProject(HashMap<String, String> project){

        if (!userrepository.existsById(project.get("user_id"))) {
            log.info("User is not found by Id: "+project.get("user_id"));
            return null;
        }

        User user = userrepository.findByUserid(Integer.parseInt(project.get("user_id")));
        Project project1 =new Project(Integer.parseInt(project.get("project_id")),project.get("project_name"),user);
        return  projectrepository.save(project1);
    }
    @Override
    public Project  updateProject(int project_id, HashMap<String, String> project){
       
        User user = userrepository.findByUserid(Integer.parseInt(project.get("user_id")));

        if (user==null) {
            log.info("User is not found by Id: "+project.get("user_id"));
            return null;
        }
        Project project1 = new Project(Integer.parseInt(project.get("project_id")),project.get("project_name"),user);
        project1.setProjectid(project_id);
        System.out.println("Update User");
        System.out.println("---------------------------------------");
        System.out.println(project1);
        return projectrepository.save(project1);

    }

    @Override
    public void deletePorject(int project_id){
        Project project = projectrepository.findByProjectid(project_id);
        System.out.println("Delete Project");
        System.out.println("---------------------------------------");
        System.out.println(project);
        projectrepository.deleteById(project_id);
    }

    // search contoller for search


}
