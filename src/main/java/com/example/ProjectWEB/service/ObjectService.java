package com.example.ProjectWEB.service;

import com.example.ProjectWEB.entity.Objects;
import com.example.ProjectWEB.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("objectService")
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    public Objects getById(long id){
        return objectRepository.findByid(id);
    }

    public Objects save(Objects object){
            object.setDate(Calendar.getInstance().getTime());
            return objectRepository.save(object);
    }

    public List<Objects>searchObject(String title){
        List<Objects> result=new ArrayList<>();
        List<Objects> all=objectRepository.findAll();
        for (int i=0; i<all.size();i++){
            if(all.get(i).getTitle().contains(title)){
                result.add(all.get(i));
            }
        }
        return result;
    }

    public List<Objects>getAll() {
        return objectRepository.findAll();
    }

    public String delete(Objects objects){
        objectRepository.delete(objects);
        return "Object with id "+objects.getId()+" deleted successfully!";
    }
}

