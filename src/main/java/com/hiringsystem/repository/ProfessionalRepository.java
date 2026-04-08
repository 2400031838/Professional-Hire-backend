package com.hiringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringsystem.model.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {
}