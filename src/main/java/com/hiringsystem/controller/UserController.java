package com.hiringsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.hiringsystem.model.Professional;
import com.hiringsystem.model.User;
import com.hiringsystem.repository.ProfessionalRepository;
import com.hiringsystem.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserRepository repo;
    private final ProfessionalRepository professionalRepo;

    public UserController(UserRepository repo, ProfessionalRepository professionalRepo) {
        this.repo = repo;
        this.professionalRepo = professionalRepo;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        User savedUser = repo.save(user);

        if (user.getRole().equals("PROFESSIONAL")) {
            Professional p = new Professional();
            p.setName(user.getName());
            p.setAvailable(true);

            professionalRepo.save(p);
        }

        return savedUser;
    }

    @PostMapping("/login")
    public User login(@RequestBody User req) {
        return repo.findAll().stream()
                .filter(u -> u.getEmail().equals(req.getEmail()) &&
                             u.getPassword().equals(req.getPassword()))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @GetMapping("/professionals")
    public List<Professional> getAllProfessionals() {
        return professionalRepo.findAll();
    }
}