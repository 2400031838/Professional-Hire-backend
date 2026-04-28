package com.hiringsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.hiringsystem.model.Professional;
import com.hiringsystem.model.User;
import com.hiringsystem.repository.ProfessionalRepository;
import com.hiringsystem.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://project-eight-theta-49.vercel.app"
})
public class UserController {

    private final UserRepository repo;
    private final ProfessionalRepository professionalRepo;

    public UserController(UserRepository repo, ProfessionalRepository professionalRepo) {
        this.repo = repo;
        this.professionalRepo = professionalRepo;
    }

    /* ================= REGISTER ================= */

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        User savedUser = repo.save(user);

        // If role is PROFESSIONAL, also save in Professional table
        if (user.getRole().equalsIgnoreCase("PROFESSIONAL")) {
            Professional p = new Professional();
            p.setName(user.getName());
            p.setAvailable(true);

            professionalRepo.save(p);
        }

        return savedUser;
    }

    /* ================= LOGIN ================= */

    @PostMapping("/login")
    public User login(@RequestBody User req) {
        return repo.findAll()
                .stream()
                .filter(u ->
                        u.getEmail().equals(req.getEmail()) &&
                        u.getPassword().equals(req.getPassword()))
                .findFirst()
                .orElse(null);
    }

    /* ================= GET ALL USERS ================= */

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /* ================= GET ALL PROFESSIONALS ================= */

    @GetMapping("/professionals")
    public List<Professional> getAllProfessionals() {
        return professionalRepo.findAll();
    }
}