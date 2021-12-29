package com.aman.controller;

import com.aman.model.Person;
import com.aman.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity save(@RequestBody Person user){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(user));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Person user){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity fetch(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.fetch(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.delete(id));
    }
}
