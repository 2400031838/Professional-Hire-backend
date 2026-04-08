package com.hiringsystem.model;

import jakarta.persistence.*;

@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private boolean available;
    private String hiredBy;

    // GETTERS
    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isAvailable() { return available; }
    public String getHiredBy() { return hiredBy; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setHiredBy(String hiredBy) { this.hiredBy = hiredBy; }
}