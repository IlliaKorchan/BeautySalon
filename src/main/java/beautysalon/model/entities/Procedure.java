package beautysalon.model.entities;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "procedure_price", nullable = false)
    private Long price;

    @Column(name = "procedure_time", nullable = false)
    private Integer time;

}
