package beautysalon.model.services;

import beautysalon.model.entities.Procedure;
import beautysalon.model.repositories.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProceduresService {
    @Autowired
    private ProcedureRepository procedureRepository;

    public List<Procedure> getAllProcedures() {
        List<Procedure> procedures = procedureRepository.findAll();

        procedures.forEach(procedure -> procedure.setPrice(procedure.getPrice() / 100));

        return procedures;
    }
}
