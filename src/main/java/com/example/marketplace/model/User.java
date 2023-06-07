package com.example.marketplace.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userid;

    private String username;

    @Enumerated(EnumType.STRING)
    @Column(name ="user_type")
    private Role usertype;

    @Column(name ="user_password")
    private String user_password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<Project> projectList = new HashSet<>();




    public User(){}

    public User(String username, Role usertype, String user_password) {
        this.username = username;
        this.usertype = usertype;
        this.user_password = user_password;
    }

    @Override
    public String toString(){
        return String.format("User[Username=%s,user_type=%s , user_password=%s]",username,usertype,user_password);
    }

    public String getUsername(){
        return this.username;
    }

    public Role getUser_type() {
        return usertype;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsertype(Role usertype) {
        this.usertype = usertype;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void addProject(Project project) {
        this.projectList.add(project);
    }
}
