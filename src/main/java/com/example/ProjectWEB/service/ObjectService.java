package com.example.ProjectWEB.service;

import com.example.ProjectWEB.entity.Objects;
import com.example.ProjectWEB.enums.Status;
import com.example.ProjectWEB.repository.ObjectRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("objectService")
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private StorageService storageService;

    private final String FILE = "object_";


    public Objects getById(long id){
        return objectRepository.findById(id);
    }

    public Objects save(Objects object){
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

    public List<Objects> getAll() {
        return objectRepository.findAll();
    }

    public List<Objects> findByStatus(Status status) {
        return objectRepository.findByStatus(status);
    }

    public String delete(Objects objects){
        objectRepository.delete(objects);
        return "Object with id "+objects.getId()+" deleted successfully!";
    }

    public void save(Objects objects, MultipartFile file){
        objects.setDate(new Date());
        objects = objectRepository.save(objects);
        String fileName = FILE+ objects.getId()+ "." + FilenameUtils.getExtension(file.getOriginalFilename());
        storageService.store(file, fileName);
        objects.setFileName(fileName);
        objectRepository.save(objects);

    }
}

