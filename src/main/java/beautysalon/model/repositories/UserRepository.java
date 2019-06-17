package beautysalon.model.repositories;

import beautysalon.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
    List<User> findAllByRole(String role);
    User findBySurnameEn(String surname);

    @Modifying
    @Query(value = "UPDATE users AS u SET u.user_password =? WHERE u.user_id = ?", nativeQuery = true)
    void updatePassword(String password, Integer userId);

}
