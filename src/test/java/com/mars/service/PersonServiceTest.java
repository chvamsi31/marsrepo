package com.mars.service;

import com.mars.model.Address;
import com.mars.model.Person;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private AddressService addressService;

    @Test
    public void testSavePerson() {

        Person person = new Person();
        person.setId(101);
        person.setFirstName("Toal");
        person.setLastName("Eric");

        Person person1 = personService.save(person);

        boolean flag = personService.exists(101);
        assertTrue(flag);
        assertEquals(person1.getFirstName(), person.getFirstName());
    }

    @Test
    public void testEditPerson() {

        Person person = new Person();
        person.setId(102);
        person.setFirstName("Eric");
        person.setLastName("Toal");

        Person person1 = personService.save(person);

        person1.setFirstName("Srinivas");

        Person person2 = personService.save(person1);

        boolean flag = personService.exists(102);
        assertTrue(flag);
        assertEquals(person2.getFirstName(), person1.getFirstName());
    }

    @Test
    public void testDeletePerson() {

        Person person = new Person();
        person.setId(102);
        person.setFirstName("Eric");
        person.setLastName("Toal");

        personService.save(person);
        personService.delete(102);

        boolean flag = personService.exists(102);
        assertFalse(flag);
    }

    @Test
    public void testPersonsCount() {

        Person person = new Person();
        person.setId(102);
        person.setFirstName("Eric");
        person.setLastName("Toal");

        Person person1 = new Person();
        person1.setId(103);
        person1.setFirstName("Malav");
        person1.setLastName("Patric");

        personService.save(person);
        personService.save(person1);

        long count = personService.count();

        assertEquals(2, count);
    }

    @Test
    public void testListPersons() {

        Person person = new Person();
        person.setId(102);
        person.setFirstName("Eric");
        person.setLastName("Toal");

        Person person1 = new Person();
        person1.setId(103);
        person1.setFirstName("Malav");
        person1.setLastName("Patric");

        personService.save(person);
        personService.save(person1);

        List<Person> personList = personService.allPersons();

        assertEquals(2, personList.size());
    }

    @Test
    public void testAddAddress() {
        Person person = new Person();
        person.setId(101);
        person.setFirstName("Toal");
        person.setLastName("Eric");
        personService.save(person);

        Address address = new Address();
        address.setId(201);
        address.setStreet("Jntu");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setPostalCode("500072");
        address.setPerson(person);
        Address address1 = addressService.save(address);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        person.setAddresses(addressList);
        personService.save(person);

        boolean flag = addressService.exists(201);
        assertTrue(flag);
        assertEquals(address1.getCity(), address.getCity());
        assertEquals(address1.getState(), address.getState());
        assertEquals(address1.getPostalCode(), address.getPostalCode());
    }

    @Test
    public void testMultipleAddAddresses() {
        Person person = new Person();
        person.setId(101);
        person.setFirstName("Toal");
        person.setLastName("Eric");
        personService.save(person);

        Address address = new Address();
        address.setId(201);
        address.setStreet("Jntu");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setPostalCode("500072");
        address.setPerson(person);

        Address address1 = new Address();
        address1.setId(202);
        address1.setStreet("Sr Nagar");
        address1.setCity("Hyderabad");
        address1.setState("Telangana");
        address1.setPostalCode("500087");
        address1.setPerson(person);

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);
        person.setAddresses(addressList);

        addressService.save(address);
        addressService.save(address1);

        personService.save(person);

        boolean flag = addressService.exists(201);
        assertTrue(flag);
        boolean flag1 = addressService.exists(202);
        assertTrue(flag1);
        assertEquals(2, personService.allPersons().get(0).getAddresses().size());
        assertEquals(2, personService.findOne(101).getAddresses().size());

    }

    @Test
    public void testEditAddress() {
        Person person = new Person();
        person.setId(101);
        person.setFirstName("Toal");
        person.setLastName("Eric");
        personService.save(person);

        Address address = new Address();
        address.setId(201);
        address.setStreet("Jntu");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setPostalCode("500072");
        address.setPerson(person);
        addressService.save(address);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        person.setAddresses(addressList);
        personService.save(person);

        Address address2 = addressService.findOne(201);
        address2.setPostalCode("500091");
        addressService.save(address2);

        assertEquals(addressService.findOne(201).getPostalCode(), "500091");
    }

    @Test
    public void testDeleteAddress() {
        Person person = new Person();
        person.setId(101);
        person.setFirstName("Toal");
        person.setLastName("Eric");
        personService.save(person);

        Address address = new Address();
        address.setId(201);
        address.setStreet("Jntu");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setPostalCode("500072");
        address.setPerson(person);
        addressService.save(address);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        person.setAddresses(addressList);
        personService.save(person);

        addressService.delete(201);

        boolean flag = addressService.exists(201);
        assertFalse(flag);
    }
}
