package com.example.springbootmongodb.service;

import com.example.springbootmongodb.collection.Person;
import com.example.springbootmongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person save(Person person) {
      return personRepository.save(person);
    }

    @Override
    public List<Person> getPersonWithFirstName(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }

    @Override
    public String delete(String id) {
         personRepository.deleteById(id);
         return "Person with "+id+" delete successfully!";
    }

    @Override
    public List<Person> getPersonAgeBetween(Integer min, Integer max) {
        return personRepository.findPersonByAgeBetween(min,max);
    }
}
