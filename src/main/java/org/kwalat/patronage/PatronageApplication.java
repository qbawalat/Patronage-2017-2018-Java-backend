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
			carRepository.save(new Car("50-6999", "HONDA", 4,"1900-01-01", "1900-01-01", "ZS502525"));
			carRepository.save(new Car("50-3999", "SKODA", 6,"1901-01-01", "1901-01-01", "GZ502255"));
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}



		};
	}
}
