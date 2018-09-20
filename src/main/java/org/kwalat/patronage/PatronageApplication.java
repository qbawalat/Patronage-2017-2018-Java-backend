package org.kwalat.patronage;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.kwalat.patronage.car.Car;
import org.kwalat.patronage.car.CarRepository;
import org.kwalat.patronage.customer.Customer;
import org.kwalat.patronage.customer.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = {"org.kwalat.patronage"})
@EntityScan("org.kwalat.patronage")
@EnableJpaRepositories("org.kwalat.patronage")
public class PatronageApplication {

    private static final Logger log = LoggerFactory.getLogger(PatronageApplication.class);

    @Value("${H2_STORAGE_ENABLED}")
    private Boolean h2StorageEnabled;

    public static void main(String[] args) {
        SpringApplication.run(PatronageApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository customerRepository, CarRepository carRepository) {
        return (args) -> {
            logCurrentDateTime(ZonedDateTime.now());
            saveInitialDataToRepositories(customerRepository, carRepository);
            log.info("-------------------------------");
            customerRepository.findAll().forEach(customer -> log.info(customer.toString()));
            log.info("H2 enabled is set to " + h2StorageEnabled);
            log.info("\n\nSwagger urls:\n\tschema: \thttp://localhost:8080/v2/api-docs\n\tswagger ui: http://localhost:8080/swagger-ui.html\n");
        };
    }

    private void logCurrentDateTime(ZonedDateTime zonedDateTime) {
        log.info(zonedDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    }

    private void saveInitialDataToRepositories(CustomerRepository customerRepository, CarRepository carRepository) {
        saveCustomers(customerRepository);
        saveCars(carRepository);
    }

    private void saveCustomers(CustomerRepository customerRepository) {
        customerRepository.save(new Customer("Jack", "Bauer", Customer.Gender.MALE, "97123008537"));
        customerRepository.save(new Customer("Chloe", "O'Brian", Customer.Gender.FEMALE, "97123002533"));
        customerRepository.save(new Customer("Alex", "Bauer", Customer.Gender.OTHER, "94120408535"));
    }

    private void saveCars(CarRepository carRepository) {
        carRepository.save(new Car(640, (Car.Brand.HONDA), (byte) 5, new Date(-9000), new Date(1000), "AZ9205"));
        carRepository.save(new Car(1040, (Car.Brand.FIAT), (byte) 3, new Date(-10000), new Date(3005), "ZS52152055"));
        carRepository.save(new Car(6999, (Car.Brand.SKODA), (byte) 6, new Date(-8600), new Date(2000), "GP1666205"));
    }


}
