package com.example.springbootmongodb.service;

import com.example.springbootmongodb.collection.Person;

import java.util.List;

public interface PersonService {
    Person save(Person person);

    List<Person> getPersonWithFirstName(String name);

    String delete(String id);

    List<Person> getPersonAgeBetween(Integer max, Integer min);
}
