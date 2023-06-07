package com.example.marketplace.model;

import com.example.marketplace.model.Product;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int product_type_id;

    private String application;
    private String type;
    private String mounting_location;
    private String accessories;

    private Date model_year;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName = "product_id")
    private Product product;


    public ProductType() {
    }

    public ProductType(String application, String type, String mounting_location, String accessories, Date model_year, Product product) {
        this.application = application;
        this.type = type;
        this.mounting_location = mounting_location;
        this.accessories = accessories;
        this.model_year = model_year;
        this.product = product;
    }

    public int getProduct_type_id() {
        return product_type_id;
    }

    public String getApplication() {
        return application;
    }

    public String getType() {
        return type;
    }

    public String getMounting_location() {
        return mounting_location;
    }

    public String getAccessories() {
        return accessories;
    }

    public Date getModel_year() {
        return model_year;
    }

//    public Product getProduct() {
//        return product;
//    }

    @Override
    public String toString() {
        return "ProductType{" +
                "product_type_id=" + product_type_id +
                ", application='" + application + '\'' +
                ", type='" + type + '\'' +
                ", mounting_location='" + mounting_location + '\'' +
                ", accessories='" + accessories + '\'' +
                ", model_year=" + model_year +
//                ", product=" + product +
                '}';
    }
}
