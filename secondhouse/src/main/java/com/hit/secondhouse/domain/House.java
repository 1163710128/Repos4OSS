package com.hit.secondhouse.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;

@Alias("house")
public class House {
    private int id;
    private String location;
    private int price;
    private String description;
    private String longitude;
    private String latitude;
    private boolean verification = false;

    public House(int id, String location, int price, String description, String longitude, String latitude) {
        this.id = id;
        this.location = location;
        this.price = price;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public boolean getVerification(){
        return this.verification;
    }

    public void setVerified(){
        this.verification = true;
    }


    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
