package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountProcessingController {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountProcessingController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/delete-account")
    public String deleteAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        userService.delete(user);
        return "/home-page";
    }

    @PostMapping("/change-password")
    public String changePassword(String oldPassword, String newPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        System.out.println(bCryptPasswordEncoder.matches(oldPassword, user.getPassword()));
        if (bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            userService.updatePassword(user, newPassword);
        }
        return "/home-page";
    }

    @GetMapping("/change-password")
    public String getChangePasswordPage() {
        return "/change-password";
    }
}
