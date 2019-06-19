package beautysalon.model.services.impl;

import beautysalon.model.entities.User;
import beautysalon.model.entities.WorkingDay;
import beautysalon.model.repositories.WorkingDayRepository;
import beautysalon.model.services.WorkingDayProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDayService implements WorkingDayProcessor {
    @Autowired
    private WorkingDayRepository workingDayRepository;

    public List<WorkingDay> getMasterWorkingDays(User master) {
        return workingDayRepository.findAllByMasterId(master);
    }
}
