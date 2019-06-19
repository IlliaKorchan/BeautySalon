package beautysalon.model.services.impl;

import beautysalon.model.entities.Procedure;
import beautysalon.model.repositories.ProcedureRepository;
import beautysalon.model.services.ProceduresProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProceduresService implements ProceduresProcessor {
    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public List<Procedure> getAllProcedures() {
        List<Procedure> procedures = procedureRepository.findAll();

        procedures.forEach(procedure -> procedure.setPrice(procedure.getPrice() / 100));

        return procedures;
    }
}
