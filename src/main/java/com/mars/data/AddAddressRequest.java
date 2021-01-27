package com.mars.data;

import com.mars.model.Address;
import java.util.List;
import javax.validation.constraints.NotNull;

public class AddAddressRequest {

    @NotNull(message = "Person id is required")
    private Integer personId;

    @NotNull(message = "Person entity is required")
    private List<Address> addressList;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
