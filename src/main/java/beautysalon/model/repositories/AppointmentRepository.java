package beautysalon.model.repositories;

import beautysalon.model.entities.Appointment;
import beautysalon.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findAllByClientId(User clientId);
    List<Appointment> findAllByMasterIdAndDate(User masterId, LocalDate date);
}
