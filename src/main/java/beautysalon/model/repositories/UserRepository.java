package beautysalon.model.repositories;

import beautysalon.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
    List<User> findAllByRole(String role);
    User findBySurnameEn(String surname);
}
