package com.hiringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiringsystem.model.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByProfessionalEmail(String email);
}