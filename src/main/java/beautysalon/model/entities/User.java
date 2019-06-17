package beautysalon.model.entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements UserDetails{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name_ukr")
    private String nameUkr;

    @Column(name = "user_name_en")
    private String nameEn;

    @Column(name = "user_surname_ukr")
    private String surnameUkr;

    @Column(name = "user_surname_en")
    private String surnameEn;

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

    @OneToMany(mappedBy = "clientId")
    private List<Appointment> clientAppointments;

    @OneToMany(mappedBy = "masterId")
    private List<Appointment> masterAppointments;

    @OneToMany(mappedBy = "masterId")
    private List<WorkingDay> workingDays;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  Collections.singletonList(this::getRole);
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getActive();
    }
}
