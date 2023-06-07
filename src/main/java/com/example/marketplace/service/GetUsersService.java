package com.example.marketplace.service;

import com.example.marketplace.model.User;

import java.util.HashMap;
import java.util.List;

public interface GetUsersService {
  public List<User> getAllUsers();

  public User addUser(HashMap<String, String> user);

  public User updateUser(int id, HashMap<String, String> user);

  public void deleteUser(int id);

  //============================New Service Interface============================
  public User save(User user);


//  public List<User> findAll();

  public User findOneById(Integer id);

  public User findByName(String name);

  public List<User> findByType(String type);

  public List<User> findByNameAndType(String name, String type);

  public User update(Integer id, String name);

  public User delete(Integer id);

  public User changeUser(Integer id, User user);


}
