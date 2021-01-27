package com.mars.service.impl;

import com.mars.model.Address;
import com.mars.model.Person;
import com.mars.repository.AddressRepository;
import com.mars.repository.PersonRepository;
import com.mars.service.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public boolean save(Person person) {
        Person person1 = personRepository.saveAndFlush(person);
        return personRepository.exists(person1.getId());
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

    @Override
    public boolean saveAddress(Integer personId, List<Address> addressList) {
        Person person = personRepository.getOne(personId);
        for (Address address : addressList) {
            address.setPerson(person);
            addressRepository.save(address);
        }
        person.setAddresses(addressList);
        personRepository.saveAndFlush(person);
        return addressRepository.exists(addressList.get(0).getId());
    }

    @Override
    public boolean updateAddress(Integer personId, Address address) {
        Person person = personRepository.getOne(personId);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addressRepository.save(address);
        person.setAddresses(addresses);
        personRepository.saveAndFlush(person);
        return addressRepository.exists(address.getId());
    }
}
