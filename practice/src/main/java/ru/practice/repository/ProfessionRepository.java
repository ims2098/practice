package ru.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practice.model.Profession;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Integer>{
    
}
