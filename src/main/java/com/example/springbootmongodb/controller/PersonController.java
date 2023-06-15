package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.collection.Person;
import com.example.springbootmongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<Person> save(@RequestBody Person person){
        return  ResponseEntity.ok(personService.save(person));
    }

    @GetMapping("/getByFirstName")
    public ResponseEntity<List<Person>> getPersonWithFirstName(@RequestParam(value = "name") String name){
        return ResponseEntity.ok(personService.getPersonWithFirstName(name));
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(value = "id") String id){
        return personService.delete(id);
    }

    @GetMapping("/getAgeBetween")
    public List<Person> getPersonAgeBetween(@RequestParam(value = "max") Integer max,@RequestParam(value = "min") Integer min){
             return personService.getPersonAgeBetween(min,max);
    }
}
