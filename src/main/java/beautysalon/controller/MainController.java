package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.repositories.AppointmentRepository;
import beautysalon.model.services.AppointmentsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import static beautysalon.StringContainer.PAGE_MAIN_BUTTON;

@Controller
public class MainController {
    private AppointmentsService appointmentsService;
//    AppointmentRepository appointmentRepository;

    public MainController(AppointmentsService appointmentsService) {//,
//                          AppointmentRepository appointmentRepository) {
        this.appointmentsService = appointmentsService;
//        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/")
    public String homePage(Map<String, Object> model) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("uk", "UA"));
        model.put("bundle", bundle);
        model.put("main-button", PAGE_MAIN_BUTTON);
        return "home-page";
    }

    @RequestMapping("/menu")
    public String main() {
        return "menu";
    }

    @GetMapping("/client/menu")
    public String getClientMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);
        return "/menu/client-menu";
    }

    @GetMapping("/master/menu")
    public String getMasterMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);

        return "/menu/master-menu";
    }

    @GetMapping("/admin/menu")
    public String getAdminMenu() {
        return "/menu/admin-menu";
    }

    @GetMapping("/client/appointments")
    public String getClientAppointments (Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("clientAppointments", appointmentsService.getClientAppointments(user));
        return "client-appointments";
    }
}
