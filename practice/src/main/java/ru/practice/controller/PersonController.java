package ru.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.model.dto.PersonDto;
import ru.practice.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService service;
    
    @GetMapping("/getAll")
    public Iterable<PersonDto> getAll(){
        return service.findAll();
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name="id") Integer id){
        return new ResponseEntity(service.findById(id),HttpStatus.OK);
    }
    
    @PostMapping("/")
    public void create(@RequestBody PersonDto element){
        service.create(element);
    }
    
    @PutMapping("/")
    public void edit(@RequestBody PersonDto element){
        service.edit(element);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name="id") Integer id){
        service.deleteById(id);
    }
}
