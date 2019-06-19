package beautysalon.model.entities;

import beautysalon.controller.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "appointment_user_id", nullable = false)
    private User clientId;

    @ManyToOne
    @JoinColumn(name = "appointment_master_id", nullable = false)
    private User masterId;

    @Convert(converter = LocalDateConverter.class)
    @Column(name = "appointment_date", nullable = false)
    private LocalDate date;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "appointment_procedure_id", nullable = false)
    private Procedure procedureId;
}
