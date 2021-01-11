package com.mars.service.impl;

import com.mars.model.Person;
import com.mars.repository.PersonRepository;
import com.mars.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public boolean exists(Integer id) {
        return personRepository.exists(id);
    }

    @Override
    public void delete(Integer id) {
        personRepository.delete(id);
    }

    @Override
    public long count() {
        return personRepository.count();
    }

    @Override
    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findOne(Integer id) {
        return personRepository.findOne(id);
    }
}
