package com.paba.cardGenerator.repository;

import com.paba.cardGenerator.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
