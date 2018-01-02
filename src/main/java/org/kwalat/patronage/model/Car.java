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

    private String licenceNumber;
    private String firstRegisterDate;
    private String licenceHolderLastName;
    private String licenceHolderPesel;
    private String licenceHolderAddress;
    private String ownerLastName;
    private String ownerPesel;
    private String ownerAddress;
    private String make;
    private String type;
    private String model;
    private String vin;
    private String mass;
    private String acceptableMass;
    private String deadweightLoad;
    private String licenceValidityPeriod;
    private String licenceDateOfIssue;
    private String category;
    private String engineSize;
    private String fuelType;

    public Car(String licenceNumber, String firstRegisterDate, String licenceHolderLastName, String licenceHolderPesel, String licenceHolderAddress, String ownerLastName, String ownerPesel, String ownerAddress, String make, String type, String model, String vin, String mass, String acceptableMass, String deadweightLoad, String licenceValidityPeriod, String licenceDateOfIssue, String category, String engineSize, String fuelType) {
        this.licenceNumber = licenceNumber;
        this.firstRegisterDate = firstRegisterDate;
        this.licenceHolderLastName = licenceHolderLastName;
        this.licenceHolderPesel = licenceHolderPesel;
        this.licenceHolderAddress = licenceHolderAddress;
        this.ownerLastName = ownerLastName;
        this.ownerPesel = ownerPesel;
        this.ownerAddress = ownerAddress;
        this.make = make;
        this.type = type;
        this.model = model;
        this.vin = vin;
        this.mass = mass;
        this.acceptableMass = acceptableMass;
        this.deadweightLoad = deadweightLoad;
        this.licenceValidityPeriod = licenceValidityPeriod;
        this.licenceDateOfIssue = licenceDateOfIssue;
        this.category = category;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
    }

    protected Car() {
    }




    public void setId(Long id) {
        this.id = id;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getFirstRegisterDate() {
        return firstRegisterDate;
    }

    public void setFirstRegisterDate(String firstRegisterDate) {
        this.firstRegisterDate = firstRegisterDate;
    }

    public String getLicenceHolderLastName() {
        return licenceHolderLastName;
    }

    public void setLicenceHolderLastName(String licenceHolderLastName) {
        this.licenceHolderLastName = licenceHolderLastName;
    }

    public String getHolderPesel() {
        return licenceHolderPesel;
    }

    public void setHolderPesel(String holderPesel) {
        this.licenceHolderPesel = holderPesel;
    }

    public String getLicenceHolderAddress() {
        return licenceHolderAddress;
    }

    public void setLicenceHolderAddress(String licenceHolderAddress) {
        this.licenceHolderAddress = licenceHolderAddress;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerPesel() {
        return ownerPesel;
    }

    public void setOwnerPesel(String ownerPesel) {
        this.ownerPesel = ownerPesel;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getAcceptableMass() {
        return acceptableMass;
    }

    public void setAcceptableMass(String acceptableMass) {
        this.acceptableMass = acceptableMass;
    }

    public String getDeadweightLoad() {
        return deadweightLoad;
    }

    public void setDeadweightLoad(String deadweightLoad) {
        this.deadweightLoad = deadweightLoad;
    }

    public String getLicenceValidityPeriod() {
        return licenceValidityPeriod;
    }

    public void setLicenceValidityPeriod(String licenceValidityPeriod) {
        this.licenceValidityPeriod = licenceValidityPeriod;
    }

    public String getLicenceDateOfIssue() {
        return licenceDateOfIssue;
    }

    public void setLicenceDateOfIssue(String licenceDateOfIssue) {
        this.licenceDateOfIssue = licenceDateOfIssue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


    public Long getId() {
        return id;
    }

/*    @Override
    public String toString() {
        return String.format("Car[id=%d, owner='%s', licenceNumber='%s']", id,
                owner, licenceNumber);
    }
*/


}
