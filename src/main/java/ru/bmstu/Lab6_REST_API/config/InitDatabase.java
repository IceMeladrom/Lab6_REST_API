package ru.bmstu.Lab6_REST_API.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.bmstu.Lab6_REST_API.entity.AuthUser;
import ru.bmstu.Lab6_REST_API.entity.User;
import ru.bmstu.Lab6_REST_API.repository.AuthUserRepository;
import ru.bmstu.Lab6_REST_API.repository.PlayerRepository;
import ru.bmstu.Lab6_REST_API.repository.UserRepository;


@Configuration
public class InitDatabase {
    private final Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    @Bean
    CommandLineRunner init(UserRepository userRepository, AuthUserRepository authUserRepository) {
        return args -> {
            logger.info("Created new super user {}", authUserRepository.save(new AuthUser("admin", "$2y$04$qAFx3fdIfGEdoCmcs8kgXeebY63QpI/Rw9FCnXUBJ3HhGFsqNXUMG")));
            logger.info("Created new user: {}", userRepository.save(new User("Roberto", "Dzhioev", "IceMeladrom_TEST", "roberto@gmail.com")));
            logger.info("Created new user: {}", userRepository.save(new User("Sergio", "Perez", "Perez", "s.perez@gmail.com")));
            logger.info("Created new user: {}", userRepository.save(new User("Max", "Verstappen", "Mad Max", "verstappen@gmail.com")));
            logger.info("Created new user: {}", userRepository.save(new User("Gregory", "Dzhioev", "Goose", "goose@gmail.com")));

//            logger.info("Created new player: {}", userRepository.save(new User("Gregory", "Dzhioev", "Goose", "goose@gmail.com")));
//            logger.info("Created new player: {}", userRepository.save(new User("Gregory", "Dzhioev", "Goose", "goose@gmail.com")));
//            logger.info("Created new player: {}", userRepository.save(new User("Gregory", "Dzhioev", "Goose", "goose@gmail.com")));
        };
    }
}
