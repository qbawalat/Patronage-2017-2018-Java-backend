package org.kwalat.patronage;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository customerRepository, CarRepository carRepository) {
        return (args) -> {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String currentDate = dateFormat.format(cal.getTime());
            log.info(currentDate);
            customerRepository.save(new Customer("Jack", "Bauer", "male", "97123008537"));
            customerRepository.save(new Customer("Chloe", "O'Brian", "female", "97123002533"));
            customerRepository.save(new Customer("Kim", "Bauer", "female", "94120408535"));
            //            carRepository.save(new Car(600, "SKODA", 5, new Date().no, "1992-12-12", "AB60256323"));
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }


        };
    }
}
