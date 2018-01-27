package org.kwalat.patronage.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kwalat.patronage.validators.date.InDateRange;
import org.kwalat.patronage.validators.date.ValidCarRegistrationDate;
import org.kwalat.patronage.validators.licence.LegitLicence;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@ValidCarRegistrationDate
@Entity
@XmlRootElement

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents id of car entity", required = true)
    private Long id;
    @NotNull
    @Min(50)
    @Max(6999)
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents car's engine size", required = true)
    private Integer engineSize;
    @NotNull
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents car's brand", required = true)
    private Brand brand;
    @Min(1)
    @Max(6)
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents the number of seats in the car", required = true)
    private Byte seats;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @InDateRange("1900-01-01")
    @Past
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents the first registration date of car's registration book ", required = true)
    private Date firstRegistrationDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents the date of issue of registration book", required = true)
    private Date registrationBookDateOfIssue;
    @NotNull
    @Size(max = 10)
    @LegitLicence()
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents car's licence number", required = true)
    private String licenceNumber;

    public Car(Integer engineSize, Brand brand, Byte seats, Date firstRegistrationDate, Date registrationBookDateOfIssue, String licenceNumber) {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
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

    public enum Brand {
        HONDA, FIAT, SKODA
    }

}
