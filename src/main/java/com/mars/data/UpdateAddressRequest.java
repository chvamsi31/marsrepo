package com.mars.data;

import com.mars.model.Address;
import javax.validation.constraints.NotNull;

public class UpdateAddressRequest {

    @NotNull(message = "Person id is required")
    private Integer personId;

    @NotNull(message = "Address entity is required")
    private Address address;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
