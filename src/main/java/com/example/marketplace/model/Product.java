package com.example.marketplace.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="product_id")
    private int productid;

    @Column(name ="product_name")
    private String productname;

    @Column(name ="product_brand")
    private String productbrand;

    private String certification;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product",cascade=CascadeType.ALL)
    Set<ProjectProduct> projectproduct = new HashSet<>();

    //set

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="technical_detail_id",referencedColumnName = "technical_detail_id")
    private TechnicalDetail technicaldetail;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="description_id",referencedColumnName = "description_id")
    private Description description;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="product_type_id",referencedColumnName = "product_type_id")
    private ProductType producttype;



    public Product() {

    }

    public Product(String productname,String product_brand, String certification,TechnicalDetail technicaldetail,Description description,ProductType producttype) {
        this.productname = productname;
        this.productbrand = product_brand;
        this.certification = certification;
        this.technicaldetail = technicaldetail;
        this.producttype = producttype;
        this.description= description;
    }

    public int getProduct_id() {
        return productid;
    }



    public String getProduct_brand() {
        return productbrand;
    }

    public String getCertification() {
        return certification;
    }

    public String getProductname(){return productname;}



        public TechnicalDetail getTechnicaldetail() {
        return technicaldetail;
    }

    public Description getDescription() {
        return description;
    }

    public ProductType getProducttype() {
        return producttype;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "product_id=" + productid +
//
//                ", product_brand='" + productbrand + '\'' +
//                ", certification='" + certification + '\'' +
////
//                '}';
//    }

    public void setTechnicaldetail(TechnicalDetail technicaldetail) {
        this.technicaldetail = technicaldetail;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setProductbrand(String productbrand) {
        this.productbrand = productbrand;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Override
    public String toString() {
        if(producttype==null || technicaldetail==null || description==null){
            return "Product{" +
                    "productid=" + productid +
                    ", productname='" + productname + '\'' +
                    ", productbrand='" + productbrand + '\'' +
                    ", certification='" + certification + '\'' +

                    '}';
        }

        return "Product{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", productbrand='" + productbrand + '\'' +
                ", certification='" + certification + '\'' +
                ", projectproduct=" + projectproduct +
                ", technicaldetail=" + technicaldetail +
                ", description=" + description +
                ", producttype=" + producttype +
                '}';
    }
}
