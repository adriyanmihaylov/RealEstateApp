package com.realestateapp.realestateapp.models;

import java.util.Date;

public class NewProperty {


    private String title;
    private Date date;
    private String description;
    private int size;
    private int bedrooms;
    private int baths;
    private int price;
    private String author;
    private String status;
    private int floors;
    private int garages;
    private int area;
    private String type;
    private int BeforePriceLabel;
    private int AfterPriceLabel;
    private String propertyId;
    private String address;

    public NewProperty(String title, Date date,
                       String description, int size, int bedrooms,
                       int baths, int price, String author,
                       String status, int floors, int garages, int area, String type, int beforePriceLabel, int afterPriceLabel, String propertyId, String address) {

        this.title = title;
        this.date = date;
        this.description = description;
        this.size = size;
        this.bedrooms = bedrooms;
        this.baths = baths;
        this.price = price;
        this.author = author;
        this.status = status;
        this.floors = floors;
        this.garages = garages;
        this.area = area;
        this.type = type;
        this.BeforePriceLabel = beforePriceLabel;
        this.AfterPriceLabel = afterPriceLabel;
        this.propertyId = propertyId;
        this.address = address;
    }
    public NewProperty(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getGarages() {
        return garages;
    }

    public void setGarages(int garages) {
        this.garages = garages;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getBeforePriceLabel() {
        return BeforePriceLabel;
    }

    public void setBeforePriceLabel(int beforePriceLabel) {
        BeforePriceLabel = beforePriceLabel;
    }

    public int getAfterPriceLabel() {
        return AfterPriceLabel;
    }

    public void setAfterPriceLabel(int afterPriceLabel) {
        AfterPriceLabel = afterPriceLabel;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }
}
