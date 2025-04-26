package com.se.softwareengineer.controller;

import com.se.softwareengineer.model.SoftwareEngineer;
import com.se.softwareengineer.service.SoftwareEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public ResponseEntity<List<SoftwareEngineer>> getSoftwareEngineers() {
       List<SoftwareEngineer> softwareEngineers = softwareEngineerService.getAll();
        return new ResponseEntity<>(softwareEngineers, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SoftwareEngineer> addSoftwareEngineers(@RequestBody SoftwareEngineer softwareEngineer) {
         softwareEngineerService.insert(softwareEngineer);
        return new ResponseEntity<>(softwareEngineer, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SoftwareEngineer> getById(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.update(id,softwareEngineer);
        return new ResponseEntity<>(softwareEngineer, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        softwareEngineerService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
