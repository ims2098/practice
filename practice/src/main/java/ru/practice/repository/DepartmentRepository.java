package ru.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practice.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
}
