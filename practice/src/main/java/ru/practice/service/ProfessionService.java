package ru.practice.service;

import java.util.List;
import ru.practice.model.Profession;

public interface ProfessionService {

    public void create(Profession element);
    public void edit(Profession element);
    public void deleteById(Integer id);
    public Profession findById(Integer id);
    public List<Profession> findAll();
    
}
