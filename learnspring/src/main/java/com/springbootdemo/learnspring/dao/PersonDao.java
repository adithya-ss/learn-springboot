package com.springbootdemo.learnspring.dao;

import com.springbootdemo.learnspring.model.Person;

import java.util.UUID;

public interface PersonDao {

    // Method to insert a person with given User ID
    int insertPerson(UUID id, Person person);

    // Method to insert a person with User ID randomly generated
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

}
