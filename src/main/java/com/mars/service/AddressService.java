package com.mars.service;

import com.mars.model.Address;

public interface AddressService {
    Address save(Address address);

    boolean exists(Integer id);

    void delete(Integer id);

    Address findOne(Integer id);
}
