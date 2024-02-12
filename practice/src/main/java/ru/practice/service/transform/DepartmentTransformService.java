package ru.practice.service.transform;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practice.model.Department;
import ru.practice.model.dto.DepartmentDto;
import ru.practice.repository.DepartmentRepository;

@Service
public class DepartmentTransformService {
    
    @Autowired
    private DepartmentRepository repository;
    
    public Department dtoToEntity(DepartmentDto dto){
        Department entity = new Department();
        if(dto.getId() != null)
            entity.setId(dto.getId());
        entity.setName(dto.getName());
        if(dto.getParentDepartmentId() != null)
            entity.setParentDepartment(repository.getReferenceById(dto.getParentDepartmentId()));
        return entity;
    }
    
    public DepartmentDto entityToDto(Department entity){
        DepartmentDto dto = new DepartmentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setParentDepartment("Нет родительского отдела");
        if(entity.getParentDepartment() != null){
            dto.setParentDepartment(entity.getParentDepartment().getName());
            dto.setParentDepartmentId(entity.getParentDepartment().getId());
        }
        return dto;
    }
    
    public List<DepartmentDto> entityToDtoList(List<Department> entityList){
        List<DepartmentDto> dtoList = new ArrayList<>();
        entityList.forEach((entity) ->{
            dtoList.add(this.entityToDto(entity));
        });
        return dtoList;
    }
    
}
