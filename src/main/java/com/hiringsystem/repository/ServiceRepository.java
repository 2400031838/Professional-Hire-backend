package com.hiringsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiringsystem.model.Service;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findBySubCategory(String subCategory);
}