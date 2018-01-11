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
    private String engineSize;
    private String brand;
    private Integer seats;
    private String firstRegistrationDate;
    private String registrationBookDateOfIssue;
    private String licenceNumber;


    public Car(String engineSize, String brand, Integer seats, String firstRegistrationDate, String registrationBookDateOfIssue, String licenceNumber) {
        this.engineSize = engineSize;
        this.brand = brand;
        this.seats = seats;
        this.firstRegistrationDate = firstRegistrationDate;
        this.registrationBookDateOfIssue = registrationBookDateOfIssue;
        this.licenceNumber = licenceNumber;
    }


    protected Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(String firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public String getRegistrationBookDateOfIssue() {
        return registrationBookDateOfIssue;
    }

    public void setRegistrationBookDateOfIssue(String registrationBookDateOfIssue) {
        this.registrationBookDateOfIssue = registrationBookDateOfIssue;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }


}
