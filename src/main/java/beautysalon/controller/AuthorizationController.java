package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import static beautysalon.StringContainer.PAGE_MAIN_BUTTON;

@Controller
public class AuthorizationController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    public AuthorizationController(BCryptPasswordEncoder bCryptPasswordEncoder,
                                   UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String homePage(Map<String, Object> model) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("uk", "UA"));
        model.put("bundle", bundle);
        model.put("main-button", PAGE_MAIN_BUTTON);
        return "home-page";
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

    @GetMapping("/delete-account")
    public String deleteAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        userRepository.delete(user);
        return "/home-page";
    }
}
