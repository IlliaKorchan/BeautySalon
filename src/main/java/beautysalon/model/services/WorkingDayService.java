package beautysalon.model.services;

import beautysalon.model.entities.User;
import beautysalon.model.entities.WorkingDay;
import beautysalon.model.repositories.WorkingDayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDayService {
    private WorkingDayRepository workingDayRepository;

    public WorkingDayService(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    public List<WorkingDay> getMasterWorkingDays(User master) {
        return workingDayRepository.findAllByMasterId(master);
    }
}
