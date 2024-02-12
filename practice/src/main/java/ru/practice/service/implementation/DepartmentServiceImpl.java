package ru.practice.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practice.model.dto.DepartmentDto;
import ru.practice.repository.DepartmentRepository;
import ru.practice.service.DepartmentService;
import ru.practice.service.transform.DepartmentTransformService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private DepartmentTransformService transformService;
    
    @Override
    public void create(DepartmentDto element) {
        if(element != null)
            repository.save(transformService.dtoToEntity(element));
    }

    @Override
    public void edit(DepartmentDto element) {
        if(element != null)
            repository.save(transformService.dtoToEntity(element));
    }

    @Override
    public void deleteById(Integer id) {
        try{
            repository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public DepartmentDto findById(Integer id) {
        try{
            return transformService.entityToDto(repository.getReferenceById(id));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DepartmentDto> findAll() {
        try{
            return transformService.entityToDtoList(repository.findAll());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
