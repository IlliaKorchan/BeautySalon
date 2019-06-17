package beautysalon.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "working_days")
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_day_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "working_day_master_id", nullable = false)
    private User masterId;

    @Column(name = "working_day_date", nullable = false)
    private LocalDate date;
}
