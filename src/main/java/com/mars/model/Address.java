package com.mars.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table
public class Address implements Serializable {

    private static final long SerialVersionUID = 10L;

    @Id
    @Column(name = "addressid")
    Integer id;

    @Column(name = "street")
    @NotBlank(message = "Street is mandatory")
    private String street;

    @Column(name = "city")
    @NotBlank(message = "City is mandatory")
    private String city;

    @Column(name = "state")
    @NotBlank(message = "State is mandatory")
    private String state;

    @Column(name = "postalcode")
    @NotBlank(message = "Postal code is mandatory")
    private String postalCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid", referencedColumnName = "personid")
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
