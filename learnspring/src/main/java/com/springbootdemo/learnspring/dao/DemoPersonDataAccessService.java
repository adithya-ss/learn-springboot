package com.springbootdemo.learnspring.dao;

import com.springbootdemo.learnspring.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("demoDao")
public class DemoPersonDataAccessService implements PersonDao {

    private static List<Person> DATABASE = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        // Add Person data into the database
        DATABASE.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DATABASE;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DATABASE.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
