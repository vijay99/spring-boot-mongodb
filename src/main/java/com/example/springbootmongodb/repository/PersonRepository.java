package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {

    public List<Person> findByFirstNameStartsWith(String name);

    @Query(value = "{ 'age': {$gt : ?0,$lt: ?1}}",fields = "{hobbies:0}")
    public List<Person> findPersonByAgeBetween(Integer min,Integer max);


}