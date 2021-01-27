package com.mars.data;

import com.mars.model.Person;
import javax.validation.constraints.NotNull;

public class UpdatePersonRequest {

    @NotNull(message = "Person entity is required")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
