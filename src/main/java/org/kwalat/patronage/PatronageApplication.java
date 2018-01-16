package org.kwalat.patronage;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.kwalat.patronage.model.Car;
import org.kwalat.patronage.model.Customer;
import org.kwalat.patronage.repository.CarRepository;
import org.kwalat.patronage.repository.CustomerRepository;
import org.kwalat.patronage.swagger.SwaggerConfig;
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
import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = {"org.kwalat.patronage"})
@EntityScan("org.kwalat.patronage")
@EnableJpaRepositories("org.kwalat.patronage")
public class PatronageApplication {

    private static final Logger log = LoggerFactory.getLogger(PatronageApplication.class);


    //    @Value("${H2_STORAGE_ENABLED}")
    //    private boolean h2StorageEnabled;

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
            SwaggerConfig swaggerConfig = new SwaggerConfig();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String currentDate = dateFormat.format(cal.getTime());
            log.info(currentDate);
            customerRepository.save(new Customer("Jack", "Bauer", Customer.Gender.MALE, "97123008537"));
            customerRepository.save(new Customer("Chloe", "O'Brian", Customer.Gender.FEMALE, "97123002533"));
            customerRepository.save(new Customer("Alex", "Bauer", Customer.Gender.OTHER, "94120408535"));
            carRepository.save(new Car(640, (Car.Brand.HONDA), (byte) 5, new Date(-5000), new Date(1000), "AZ9205"));
            carRepository.save(new Car(1040, (Car.Brand.FIAT), (byte) 3, new Date(-2000), new Date(100), "ZS52152055"));
            carRepository.save(new Car(6999, (Car.Brand.SKODA), (byte) 6, new Date(-1600), new Date(), "GP1666205"));

            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            //            try {
            //                if (h2StorageEnabled) {
            //                    log.info("\n\nEnvironment variables:\n\tH2_STORAGE_ENABLED = " + h2StorageEnabled + "\nUsing H2 implementation.");
            //                } else if (!h2StorageEnabled) {
            //                    log.info("\n\nEnvironment variables:\n\tH2_STORAGE_ENABLED = " + h2StorageEnabled + "\nUsing LocalList implementation.");
            //                }
            //            } catch (NullPointerException exception) {
            //                log.info("\n\nEnvironment variables:\n\tNone." + "\nUsing H2 implementation.");
            //            }
            log.info("\n\nSwagger urls:\n\tschema: \thttp://localhost:8080/v2/api-docs\n\tswagger ui: http://localhost:8080/swagger-ui.html\n");
        };
    }
}
