package com.hiringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiringsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}