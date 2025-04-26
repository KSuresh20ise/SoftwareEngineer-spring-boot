package com.se.softwareengineer.repository;

import com.se.softwareengineer.model.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {
    boolean existsByEmail(String email);
}
