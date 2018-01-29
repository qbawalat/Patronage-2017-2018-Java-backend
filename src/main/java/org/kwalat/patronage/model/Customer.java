package org.kwalat.patronage.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents id of customer entity", required = true)
    private Long id;
    @NotNull
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents customer's first name", required = true)
    private String firstName;
    @NotNull
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents customer's last name", required = true)
    private String lastName;
    @NotNull
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents customer's gender", required = true)
    private Gender gender;
    @NotNull
    @JsonProperty(required = true)
    @ApiModelProperty(value = "Represents customer's personal number", required = true)
    private String personalNumber;

    protected Customer() {
    }

    public Customer(String firstName, String lastName, Gender gender, String personalNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s', gender='%s', personalNumber='%s']", id, firstName, lastName, gender, personalNumber);
    }

    public enum Gender {
        MALE, FEMALE, OTHER
    }
}