package beautysalon.model.repositories;

import beautysalon.model.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}
