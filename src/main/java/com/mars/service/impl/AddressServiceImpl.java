package com.mars.service.impl;

import com.mars.model.Address;
import com.mars.repository.AddressRepository;
import com.mars.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean exists(Integer id) {
        return addressRepository.exists(id);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.delete(id);
    }

    @Override
    public Address findOne(Integer id) {
        return addressRepository.getOne(id);
    }
}
