package ru.practice.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.practice.model.Profession;
import ru.practice.repository.ProfessionRepository;
import ru.practice.service.ProfessionService;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    private ProfessionRepository repository;
    
    @Override
    public void create(Profession element) {
        if(element != null)
            repository.save(element);
    }

    @Override
    public void edit(Profession element) {
        if(element != null)
            repository.save(element);
    }

    @Override
    public void deleteById(Integer id) {
        try{
            if(id != null)
                repository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }        
    }

    @Override
    public Profession findById(Integer id) {
        try{
            return repository.getReferenceById(id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }

    @Override
    public List<Profession> findAll() {
        try{
            return repository.findAll();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } 
    }
    
}
