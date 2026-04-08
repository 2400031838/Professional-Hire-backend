package com.hiringsystem.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String service;
    private String price;
    private String date;
    private String time;

    private String professionalEmail; // ✅ KEY FIELD

    public Booking() {}

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getProfessionalEmail() { return professionalEmail; }
    public void setProfessionalEmail(String professionalEmail) {
        this.professionalEmail = professionalEmail;
    }
}