package com.mars.controller;

import com.mars.data.AddAddressRequest;
import com.mars.data.AddAddressResponse;
import com.mars.data.AddPersonRequest;
import com.mars.data.AddPersonResponse;
import com.mars.data.UpdateAddressRequest;
import com.mars.data.UpdateAddressResponse;
import com.mars.data.UpdatePersonRequest;
import com.mars.data.UpdatePersonResponse;
import com.mars.exception.AddressNotFoundException;
import com.mars.exception.PersonNotFoundException;
import com.mars.model.Person;
import com.mars.service.AddressService;
import com.mars.service.PersonService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AddressService addressService;

    @PostMapping("/addperson")
    public ResponseEntity<AddPersonResponse> addPerson(@Valid @RequestBody AddPersonRequest request) {
        boolean flag = personService.save(request.getPerson());
        AddPersonResponse response = new AddPersonResponse();
        response.setStatus(flag);
        response.setMessage("Person has been added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateperson")
    public ResponseEntity<UpdatePersonResponse> updatePerson(@Valid @RequestBody UpdatePersonRequest request) {
        boolean flag = personService.save(request.getPerson());
        UpdatePersonResponse response = new UpdatePersonResponse();
        response.setStatus(flag);
        response.setMessage("Person has been updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/deleteperson")
    public ResponseEntity<Object> deletePerson(@PathVariable("id") String id) {
        if (!personService.exists(Integer.valueOf(id))) throw new PersonNotFoundException();
        personService.delete(Integer.valueOf(id));
        return new ResponseEntity<>("Person has been deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/addaddress")
    public ResponseEntity<AddAddressResponse> addAddress(@Valid @RequestBody AddAddressRequest request) {
        if (!personService.exists(request.getPersonId())) throw new PersonNotFoundException();
        boolean flag = personService.saveAddress(request.getPersonId(), request.getAddressList());
        AddAddressResponse response = new AddAddressResponse();
        response.setStatus(flag);
        response.setMessage("Address has been added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/updateaddress")
    public ResponseEntity<UpdateAddressResponse> updateAddress(@Valid @RequestBody UpdateAddressRequest request) {
        if (!personService.exists(request.getPersonId())) throw new PersonNotFoundException();
        if (!addressService.exists(request.getAddress().getId())) throw new AddressNotFoundException();
        boolean flag = personService.updateAddress(request.getPersonId(), request.getAddress());
        UpdateAddressResponse response = new UpdateAddressResponse();
        response.setStatus(flag);
        response.setMessage("Address has been updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/deleteaddress")
    public ResponseEntity<Object> deleteAddress(@PathVariable("id") String id) {
        if (!addressService.exists(Integer.valueOf(id))) throw new AddressNotFoundException();
        addressService.delete(Integer.valueOf(id));
        return new ResponseEntity<>("Address has been deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/personcount")
    public ResponseEntity<Object> getPersonCount() {
        return new ResponseEntity<>("Total persons count is : " + personService.allPersons().size(), HttpStatus.OK);
    }

    @GetMapping("/allpersons")
    public List<Person> personList() {
        return personService.allPersons();
    }

}
