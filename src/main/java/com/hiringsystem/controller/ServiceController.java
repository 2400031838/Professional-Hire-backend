package com.hiringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hiringsystem.model.Service;
import com.hiringsystem.repository.ServiceRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://project-eight-theta-49.vercel.app"
})
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    /* ================= ADD SERVICE ================= */

    @PostMapping("/add")
    public Service addService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    /* ================= GET ALL SERVICES ================= */

    @GetMapping("/all")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    /* ================= GET BY SUBCATEGORY ================= */

    @GetMapping("/subcategory/{sub}")
    public List<Service> getBySubCategory(@PathVariable String sub) {
        return serviceRepository.findBySubCategory(sub);
    }

    /* ================= DELETE SERVICE ================= */

    @DeleteMapping("/delete/{id}")
    public String deleteService(@PathVariable int id) {
        serviceRepository.deleteById(id);
        return "Service deleted successfully";
    }
}