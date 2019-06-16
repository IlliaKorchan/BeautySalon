package beautysalon.model.services;

import beautysalon.model.entities.Appointment;
import beautysalon.model.entities.User;
import beautysalon.model.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentsService() {
    }

    public AppointmentsService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getClientAppointments (User client) {
        List<Appointment> appointments = appointmentRepository.findAllByClientId(client);

        for (Appointment appointment : appointments) {
            Long price = appointment.getProcedureId().getPrice() / 100;
            appointment.getProcedureId().setPrice(price);
        }
        return appointments;
    }
}
