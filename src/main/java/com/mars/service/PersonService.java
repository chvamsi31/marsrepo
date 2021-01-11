package com.mars.service;

import com.mars.model.Person;
import java.util.List;

public interface PersonService {

    Person save(Person person);

    boolean exists(Integer id);

    void delete(Integer id);

    long count();

    List<Person> allPersons();

    Person findOne(Integer id);
}
