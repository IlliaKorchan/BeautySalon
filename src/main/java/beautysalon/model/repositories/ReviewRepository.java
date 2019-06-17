package beautysalon.model.repositories;

import beautysalon.model.entities.Review;
import beautysalon.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByClientId(User clientId);
}
