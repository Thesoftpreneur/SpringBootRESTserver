package com.example.springbootdemo.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import static java.time.Month.JANUARY;
import java.util.List;


@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
                Person mariam = new Person(
                        1L,
                        "Mariam",
                        "mariam.jamal@gmail.com",
                        LocalDate.of(2000, JANUARY, 5)
                );
            Person alex = new Person(
                    2L,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, JANUARY, 5)
            );
            repository.saveAll(List.of(mariam, alex));
        };
    }
}
