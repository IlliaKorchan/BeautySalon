package beautysalon.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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

    @Column(name = "appointment_user_id", nullable = false)
    private Integer userId;

    @Column(name = "appointment_master_id", nullable = false)
    private Integer masterId;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime date;

    @Column(name = "appointment_procedure_id", nullable = false)
    private Integer procedureId;
}
