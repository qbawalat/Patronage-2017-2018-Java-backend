package org.kwalat.patronage.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String owner;
    private String licenceNumber;

    protected Car() {
    }

    public Car(String owner, String licenceNumber) {
        this.owner = owner;
        this.licenceNumber = licenceNumber;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Car[id=%d, owner='%s', licenceNumber='%s']", id,
                owner, licenceNumber);
    }



}
