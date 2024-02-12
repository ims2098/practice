package ru.practice.service;

import java.util.List;
import ru.practice.model.dto.PersonDto;

public interface PersonService {
    
    public void create(PersonDto element);
    public void edit(PersonDto element);
    public void deleteById(Integer id);
    public PersonDto findById(Integer id);
    public List<PersonDto> findAll();
    
}
