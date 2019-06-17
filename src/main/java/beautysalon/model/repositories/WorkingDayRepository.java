package beautysalon.model.repositories;

import beautysalon.model.entities.User;
import beautysalon.model.entities.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkingDayRepository extends JpaRepository<WorkingDay, Integer> {
    List<WorkingDay> findAllByMasterId(User user);
}
