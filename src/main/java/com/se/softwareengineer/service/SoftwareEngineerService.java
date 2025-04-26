package com.se.softwareengineer.service;

import com.se.softwareengineer.exception.SoftwareEngineerExistsException;
import com.se.softwareengineer.exception.SoftwareEngineerNotFound;
import com.se.softwareengineer.model.SoftwareEngineer;
import com.se.softwareengineer.repository.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;


    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }
    public List<SoftwareEngineer> getAll(){
        return softwareEngineerRepository.findAll();
    }

    public void insert(SoftwareEngineer softwareEngineer){
        if (softwareEngineerRepository.existsByEmail(softwareEngineer.getEmail())){
            throw new SoftwareEngineerExistsException("Software Engineer with email "+softwareEngineer.getEmail()+" already exists");
        }
        softwareEngineerRepository.save(softwareEngineer);
    }
    public void update(Integer id, SoftwareEngineer softwareEngineer){
      SoftwareEngineer updatedSoftwareEngineer = softwareEngineerRepository.findById(id).
              orElseThrow(()->new SoftwareEngineerNotFound("Software Engineer not found with ID :"+id));
        if (softwareEngineerRepository.existsByEmail(softwareEngineer.getEmail())){
            throw new SoftwareEngineerExistsException("Software Engineer with email "+softwareEngineer.getEmail()+" already exists");
        }
      updatedSoftwareEngineer.setName(softwareEngineer.getName());
      updatedSoftwareEngineer.setEmail(softwareEngineer.getEmail());
      updatedSoftwareEngineer.setTechStack(softwareEngineer.getTechStack());
        softwareEngineerRepository.save(updatedSoftwareEngineer);
    }
    public void delete(Integer id){
       softwareEngineerRepository.findById(id).
                orElseThrow(()->new SoftwareEngineerNotFound("Software Engineer not found with ID :"+id));
        softwareEngineerRepository.deleteById(id);
    }
}
