package com.example.marketplace.model;

import jakarta.persistence.*;

@Entity
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JoinColumn(name="project_product")
    private  int projectproduct;

    // name
   @ManyToOne(fetch= FetchType.EAGER)
   @JoinColumn(name="project_id")
    private Project project;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="product_id")
   private Product product;


    public ProjectProduct() {
    }

    public ProjectProduct(int project_product, Project project, Product product) {
        this.projectproduct = project_product;
        this.project = project;
        this.product = product;
    }

    public int getProject_product() {
        return projectproduct;
    }

    public Project getProject() {
        return project;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProjectProduct{" +
                "projectproduct=" + projectproduct +
//                ", project=" + project +
//                ", product=" + product+
                '}';
    }
}
