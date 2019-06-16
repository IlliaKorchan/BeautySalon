package beautysalon.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "procedures")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_id")
    private Integer id;

    @Column(name = "procedure_name_ukr")
    private String nameUkr;

    @Column(name = "procedure_name_en")
    private String nameEn;

    @Column(name = "procedure_price", nullable = false)
    private Long price;

    @OneToMany(mappedBy = "procedureId")
    private List<Appointment> appointment;
}
