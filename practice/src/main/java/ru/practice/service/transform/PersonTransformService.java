package ru.practice.service.transform;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practice.model.Person;
import ru.practice.model.dto.PersonDto;
import ru.practice.repository.DepartmentRepository;
import ru.practice.repository.PersonRepository;
import ru.practice.repository.ProfessionRepository;

@Service
public class PersonTransformService {
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private ProfessionRepository professionRepository;
    
    public PersonDto entityToDto(Person entity){
        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setFName(entity.getFName());
        dto.setLName(entity.getLName());
        dto.setMName(entity.getMName());
        dto.setNotes(entity.getNotes());
        dto.setDepartment("Нет подразделения");
        dto.setProfession("Нет профессии");
        if(entity.getDepartment() != null){
            dto.setDepartment(entity.getDepartment().getName());
            dto.setDepartmentId(entity.getDepartment().getId());
        }
        if(entity.getProfession() != null){
            dto.setProfession(entity.getProfession().getName());
            dto.setProfessionId(entity.getProfession().getId());
        }
        return dto;
    }
    
    public Person dtoToEntity(PersonDto dto){
        Person entity = new Person();
        entity.setFName(dto.getFName());
        entity.setLName(dto.getLName());
        entity.setMName(dto.getMName());
        entity.setNotes(dto.getNotes());
        if(dto.getId() != null)
            entity.setId(dto.getId());
        if(dto.getDepartmentId() != null)
            entity.setDepartment(departmentRepository.getReferenceById(dto.getDepartmentId()));
        if(dto.getProfessionId() != null)
            entity.setProfession(professionRepository.getReferenceById(dto.getProfessionId()));
        return entity;
    }
    
    public List<PersonDto> entityToDtoList(List<Person> entityList){
        List<PersonDto> dtoList = new ArrayList<>();
        entityList.forEach((entity) -> {
            dtoList.add(this.entityToDto(entity));
        });
        return dtoList;
    }
}
