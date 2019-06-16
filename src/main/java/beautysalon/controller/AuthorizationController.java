package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class AuthorizationController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    public AuthorizationController(BCryptPasswordEncoder bCryptPasswordEncoder,
                                   UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String signUp(User user) {

        if (Objects.nonNull(userRepository.findByLogin(user.getLogin()))) {
            return "registration";
        } else {
            user.setRole("client");
            user.setActive(true);
            String hashPassword =  bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);

            userRepository.save(user);
            return "redirect:/login";
        }
    }
}
