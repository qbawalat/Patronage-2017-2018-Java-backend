package org.kwalat.patronage.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Min(50)
    @Max(6999)
    private Integer engineSize;

    @NotNull
    @Pattern(regexp = "SKODA|HONDA|FIAT")
    private String brand;

    @Min(1)
    @Max(6)
    private Byte seats;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date firstRegistrationDate;

    @NotNull
    private Date registrationBookDateOfIssue;

    @NotNull
    private String licenceNumber;

    public Car(Integer engineSize, String brand, Byte seats, Date firstRegistrationDate, Date registrationBookDateOfIssue, String licenceNumber) {
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

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Byte getSeats() {
        return seats;
    }

    public void setSeats(Byte seats) {
        this.seats = seats;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Date getRegistrationBookDateOfIssue() {
        return registrationBookDateOfIssue;
    }

    public void setRegistrationBookDateOfIssue(Date registrationBookDateOfIssue) {
        this.registrationBookDateOfIssue = registrationBookDateOfIssue;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }


}
