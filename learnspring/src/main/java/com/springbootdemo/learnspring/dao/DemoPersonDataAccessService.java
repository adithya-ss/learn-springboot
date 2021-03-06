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
        Optional<Person> thisPerson = selectPersonById(id);
        if (!thisPerson.isPresent()) {
            return 0;
        }
        DATABASE.remove(thisPerson.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person updateThisPerson) {
        return selectPersonById(id)
                .map(per -> {
                    int indexOfPersonToUpdate = DATABASE.indexOf(per);
                    if (indexOfPersonToUpdate >= 0) {
                        DATABASE.set(indexOfPersonToUpdate, new Person(id, updateThisPerson.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
