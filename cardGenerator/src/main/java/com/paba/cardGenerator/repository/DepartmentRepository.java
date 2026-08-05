package com.paba.cardGenerator.repository;

import com.paba.cardGenerator.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsById(Long id);
    Optional<Department> findById(Long id);
}
