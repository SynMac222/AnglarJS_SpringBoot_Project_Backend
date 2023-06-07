package com.example.marketplace.model;

import jakarta.persistence.*;


@Entity
public class Description {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int description_id;

    private String manufacturer;

    private String series;


    private String model;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName = "product_id")
    private Product product;

    public Description() {
    }

    public Description(String manufacturer, String series, String model, Product product) {
        this.manufacturer = manufacturer;
        this.series = series;
        this.model = model;

        this.product = product;
    }

    public int getDescription_id() {
        return description_id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }



//    public Product getProduct() {
//        return product;
//    }

    @Override
    public String toString() {
        return "Description{" +
                "description_id=" + description_id +
                ", manufacturer='" + manufacturer + '\'' +
                ", series='" + series + '\'' +
                ", model='" + model + '\'' +
//                ", product=" + product +
                '}';
    }
}
