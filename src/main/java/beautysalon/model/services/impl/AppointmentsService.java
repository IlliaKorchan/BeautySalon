package beautysalon.model.services.impl;

import beautysalon.model.entities.Appointment;
import beautysalon.model.entities.User;
import beautysalon.model.repositories.AppointmentRepository;
import beautysalon.model.services.AppointmentsProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentsService implements AppointmentsProcessor {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentsService() {
    }

    @Override
    public List<Appointment> getClientAppointments (User client) {
        Map<Integer, Long> uniquePrices = new HashMap<>();
        List<Appointment> correctList = new ArrayList<>();

        Long price;

        for (Appointment appointment : appointmentRepository.findAllByClientId(client)) {
            price = appointment.getProcedureId().getPrice();

            uniquePrices.putIfAbsent(appointment.getProcedureId().getId(), price / 100);

            appointment.getProcedureId().setPrice(uniquePrices.get(appointment.getProcedureId().getId()));
            correctList.add(appointment);
        }
        return correctList;
    }

    @Override
    public List<Appointment> getMasterAppointments (User master, String date) {
        LocalDate selectedDate = LocalDate.parse(date);

        List<Appointment> list = appointmentRepository.findAllByMasterIdAndDate(master, selectedDate);
        System.out.println(list.size());
        return list;
    }
}
