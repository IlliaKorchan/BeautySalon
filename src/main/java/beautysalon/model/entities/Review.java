package beautysalon.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer id;

    @Column(name = "review_date")
    private LocalDate date;

    @Column(name = "review_client_id")
    private Integer clientId;

    @Column(name = "review_master_id", nullable = false)
    private Integer appointmentId;

    @Column(name = "review_text")
    private String text;
}

