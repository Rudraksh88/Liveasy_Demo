package com.example.liveasydemo.model;

import jakarta.persistence.*;

import java.util.UUID;
//import jakarta.persistence.Entity;

//import javax.persistence.Id;
//import jakarta.persistence.Id;
// import jakarta.persistence.Id;

@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int loadid;
//    @Column(name = "loading_point")
    private String loadingPoint;
//    @Column(name = "unloading_point")
    private String unloadingPoint;
//    @Column(name = "product_type")
    private String productType;
//    @Column(name = "truck_type")
    private String truckType;
//    @Column(name = "no_of_trucks")
    private int noOfTrucks;
//    @Column(name = "weight")
    private double weight;
//    @Column(name = "comment")
    private String comment;
//    @Column(name = "shipperid")
    private UUID shipperId;
//    @Column(name = "date")
    private String date;

    public Load() {
        // Default constructor required by JPA
    }

    // Constructors, getters, and setters
    public Load(String loadingPoint, String unloadingPoint, String productType, String truckType,
                int noOfTrucks, double weight, String comment, UUID shipperId, String date) {
        // this.loadId = loadId;
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.comment = comment;
        this.shipperId = shipperId;
        this.date = date;
    }

    // Getters
    @Column(name = "loadid")
    public int getLoadId() {
        return loadid;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public int getNoOfTrucks() {
        return noOfTrucks;
    }

    public double getWeight() {
        return weight;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public UUID getShipperId() {
        return shipperId;
    }

    // Setters
    public void setLoadId(int loadid) {
        this.loadid = loadid;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public void setNoOfTrucks(int noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setShipperId(UUID shipperId) {
        this.shipperId = shipperId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
