package org.kwalat.patronage;


import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.repository.CarRepository;
import org.kwalat.patronage.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.kwalat.patronage"})
@EntityScan("org.kwalat.patronage")
@EnableJpaRepositories("org.kwalat.patronage")
public class PatronageApplication {
	private static final Logger log = LoggerFactory.getLogger(PatronageApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PatronageApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository customerRepository, CarRepository carRepository){
		return (args) -> {
			customerRepository.save(new Customer("Jack", "Bauer", "male", "97123008537"));
			customerRepository.save(new Customer("Chloe", "O'Brian", "female", "97123002533"));
			customerRepository.save(new Customer("Kim", "Bauer", "female", "94120408535"));
			carRepository.save(new Car("licenceNumber1", "firstRegisterDate1", "licenceHolderLastName1", "licenceHolderPesel1", "licenceHolderAddress1", "ownerLastName1", "ownerPesel","ownerAddress1", "make1", "type1", "model1", "vin1", "mass1", "acceptableMass1", "deadweightLoad1", "licenceValidityPeriod1", "licenceDateOfIssue1", "category1", "engineSize1", "fuelType1"));
			carRepository.save(new Car("licenceNumber2", "firstRegisterDate2", "licenceHolderLastName2", "licenceHolderPesel2", "licenceHolderAddress2", "ownerLastName2", "ownerPesel","ownerAddress2", "make2", "type2", "model2", "vin2", "mass2", "acceptableMass2", "deadweightLoad2", "licenceValidityPeriod2", "licenceDateOfIssue2", "category2", "engineSize2", "fuelType2"));
			carRepository.save(new Car("licenceNumber3", "firstRegisterDate3", "licenceHolderLastName3", "licenceHolderPesel3", "licenceHolderAddress3", "ownerLastName3", "ownerPesel","ownerAddress3", "make3", "type3", "model3", "vin3", "mass3", "acceptableMass3", "deadweightLoad3", "licenceValidityPeriod3", "licenceDateOfIssue3", "category3", "engineSize3", "fuelType3"));

			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			log.info("Cars found with findAll():");
			log.info("-------------------------------");
			for(Car car : carRepository.findAll()){
				log.info(car.toString());
			}


		};
	}
}
