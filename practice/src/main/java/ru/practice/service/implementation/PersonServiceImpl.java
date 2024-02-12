package ru.practice.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practice.model.dto.PersonDto;
import ru.practice.repository.PersonRepository;
import ru.practice.service.PersonService;
import ru.practice.service.transform.PersonTransformService;

@Service
public class PersonServiceImpl implements PersonService{
    
    @Autowired
    private PersonRepository repository;
    
    @Autowired
    private PersonTransformService transformService;

    @Override
    public void create(PersonDto element) {
        if(element != null)
            repository.save(transformService.dtoToEntity(element));
    }

    @Override
    public void edit(PersonDto element) {
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
    public PersonDto findById(Integer id) {
        try{
            return transformService.entityToDto(repository.getReferenceById(id));
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PersonDto> findAll() {
        try{
            return transformService.entityToDtoList(repository.findAll());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
