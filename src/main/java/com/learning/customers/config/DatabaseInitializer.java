package com.learning.customers.config;

import com.learning.customers.models.CustomerEntity;
import com.learning.customers.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initializeDatabase(CustomerRepository repository) {

        return args -> {

            if (repository.count() == 0) {

                repository.save(
                        new CustomerEntity(
                                1,
                                "John Smith",
                                "johnsmith",
                                "john@example.com"
                        )
                );

                repository.save(
                        new CustomerEntity(
                                2,
                                "Jane Doe",
                                "janedoe",
                                "jane@example.com"
                        )
                );

                repository.save(
                        new CustomerEntity(
                                3,
                                "Robert Brown",
                                "robertbrown",
                                "robert@example.com"
                        )
                );

                repository.save(
                        new CustomerEntity(
                                4,
                                "Srinivasa Rao Imandi",
                                "srinivasaimandi",
                                "srinivasaimandi@yahoo.com"
                        )
                );

                System.out.println("Default customers inserted.");

            } else {

                System.out.println("Customers already exist. Skipping initialization.");
            }
        };
    }
}