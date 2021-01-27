package com.mars.service;

import com.mars.model.Address;
import com.mars.model.Person;
import java.util.List;

public interface PersonService {

    boolean save(Person person);

    boolean exists(Integer id);

    void delete(Integer id);

    long count();

    List<Person> allPersons();

    Person findOne(Integer id);

    boolean saveAddress(Integer personId, List<Address> addressList);

    boolean updateAddress(Integer personId, Address address);
}
