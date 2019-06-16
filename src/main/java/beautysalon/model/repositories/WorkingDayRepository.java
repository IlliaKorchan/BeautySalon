package beautysalon.model.repositories;

import beautysalon.model.entities.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingDayRepository extends JpaRepository<WorkingDay, Integer> {
}
