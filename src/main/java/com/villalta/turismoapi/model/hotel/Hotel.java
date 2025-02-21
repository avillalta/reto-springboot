package com.villalta.turismoapi.model.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "hotels")
public class Hotel {

    @Id
    private String id;

    private String name;
    private String description;
    private String location;
    private int stars; // Número de estrellas del hotel
    private Double pricePerNight; // Precio por noche

    public Hotel() {
    }

    // Constructor con todos los campos (excepto el ID)
    public Hotel(String name, String description, String location, int stars, Double pricePerNight) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.stars = stars;
        this.pricePerNight = pricePerNight;
    }

    // Getters y Setters manuales
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}