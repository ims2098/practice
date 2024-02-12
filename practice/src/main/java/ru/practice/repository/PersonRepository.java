package ru.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    
}
