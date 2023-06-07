package com.example.marketplace.service;

import com.example.marketplace.model.Project;
import com.example.marketplace.model.User;

import java.util.HashMap;
import java.util.List;

public interface ProjetsService {
    Project findOneByID(int id);
    public List<Project> getAllProjects();

    public Project addProject(HashMap<String, String> project);

    public Project updateProject(int project_id, HashMap<String, String> project);

    public void deletePorject(int project_id);
}
