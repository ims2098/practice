package ru.practice.service;

import java.util.List;
import ru.practice.model.dto.DepartmentDto;

public interface DepartmentService {

    public void create(DepartmentDto element);
    public void edit(DepartmentDto element);
    public void deleteById(Integer id);
    public DepartmentDto findById(Integer id);
    public List<DepartmentDto> findAll();
    
}
