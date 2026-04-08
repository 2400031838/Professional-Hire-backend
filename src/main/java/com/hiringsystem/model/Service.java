package com.hiringsystem.model;

import jakarta.persistence.*;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mainCategory;
    private String subCategory;
    private String name;
    private String price;

    private String email; // ✅ PROFESSIONAL EMAIL

    public Service() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMainCategory() { return mainCategory; }
    public void setMainCategory(String mainCategory) { this.mainCategory = mainCategory; }

    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}