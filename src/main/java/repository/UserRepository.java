package repository;

import entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User findById(long id);

    User findByUsername(String username);

    User findByEmail(String email);
}
