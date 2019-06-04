package beautysalon.model.entities;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_login", unique = true, nullable = false)
    private String login;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_role", nullable = false)
    private String role;

    @Column(name = "user_active", nullable = false)
    private Boolean active;

    @Column(name = "user_amount_money")
    private Long amountOfMoney;
}
