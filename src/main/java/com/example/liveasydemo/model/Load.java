package com.example.liveasydemo.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int loadid;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private UUID shipperId;
    private String date;

    public Load() {
        // Default constructor required by JPA
    }

    // Constructors, getters, and setters
    public Load(String loadingPoint, String unloadingPoint, String productType, String truckType,
                int noOfTrucks, double weight, String comment, UUID shipperId, String date) {
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
