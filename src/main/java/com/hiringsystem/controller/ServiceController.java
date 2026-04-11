package com.hiringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hiringsystem.model.Service;
import com.hiringsystem.repository.ServiceRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @PostMapping("/add")
    public Service addService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @GetMapping("/all")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/subcategory/{sub}")
    public List<Service> getBySubCategory(@PathVariable String sub) {
        return serviceRepository.findBySubCategory(sub);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteService(@PathVariable int id) {
        serviceRepository.deleteById(id);
        return "Service deleted successfully";
    }
}