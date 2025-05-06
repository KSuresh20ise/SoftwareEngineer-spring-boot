package com.se.softwareengineer.controller;

import com.se.softwareengineer.model.SoftwareEngineer;
import com.se.softwareengineer.service.SoftwareEngineerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public ResponseEntity<List<SoftwareEngineer>> getEngineers() {
       List<SoftwareEngineer> softwareEngineers = softwareEngineerService.getAll();
        return new ResponseEntity<>(softwareEngineers, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SoftwareEngineer> addEngineers(@RequestBody SoftwareEngineer softwareEngineer) {
         softwareEngineerService.insert(softwareEngineer);
        return new ResponseEntity<>(softwareEngineer, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SoftwareEngineer> updateEngineers(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.update(id,softwareEngineer);
        return new ResponseEntity<>(softwareEngineer, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEngineers(@PathVariable Integer id) {
        softwareEngineerService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
