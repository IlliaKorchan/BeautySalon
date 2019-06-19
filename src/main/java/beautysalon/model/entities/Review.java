package beautysalon.model.entities;

import beautysalon.controller.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
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

    @Convert(converter = LocalDateConverter.class)
    @Column(name = "review_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "review_client_id")
    private User clientId;

    @ManyToOne
    @JoinColumn(name = "review_master_id", nullable = false)
    private User masterId;

    @Column(name = "review_text")
    private String text;
}

