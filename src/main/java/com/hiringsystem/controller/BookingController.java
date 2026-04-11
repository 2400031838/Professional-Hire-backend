package com.hiringsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hiringsystem.model.Booking;
import com.hiringsystem.repository.BookingRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/add")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }
      //getmapping
    @GetMapping("/professional/{email}")
    public List<Booking> getByProfessional(@PathVariable String email) {
        return bookingRepository.findByProfessionalEmail(email);
    }
}