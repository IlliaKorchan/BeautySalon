package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String signUp(User user, Map<String, Object> model) {
        if (userRepository.findByLogin(user.getLogin()).isPresent()) {
            model.put("message", "User already exists!");
            return "registration";
        } else {
            user.setRole("Client");
            user.setActive(true);
            System.out.println(user.getLogin() + " " + user.getPassword() + " " + user.getActive());
            userRepository.save(user);
            return "redirect:/login";
        }
    }
}
