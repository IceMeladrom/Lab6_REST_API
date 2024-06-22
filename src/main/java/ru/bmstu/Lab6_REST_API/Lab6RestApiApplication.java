package ru.bmstu.Lab6_REST_API;

import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import repository.UserRepository;

@SpringBootApplication
public class Lab6RestApiApplication {

    private static final Logger log = LoggerFactory.getLogger(Lab6RestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab6RestApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return (args) -> {
            userRepository.save(new User("Robert", "Dzhioev", "IceMeladrom", "robertkryt@gmail.com"));
            userRepository.save(new User("Alexandra", "Sergeichik", "LaComte", "8aleka.serg@gmail.com"));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            userRepository.findAll().forEach(user -> {
                log.info(user.toString());
            });
            log.info("");

            // fetch an individual customer by ID
            User customer = userRepository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Robert'):");
            log.info("--------------------------------------------");
            userRepository.findByLastName("Robert").forEach(robert -> {
                log.info(robert.toString());
            });
            log.info("");
        };
    }
}