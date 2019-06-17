package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.services.AppointmentsService;
import beautysalon.model.services.ProceduresService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master")
public class MasterController {
    private AppointmentsService appointmentsService;
    private ProceduresService proceduresService;

    public MasterController(AppointmentsService appointmentsService, ProceduresService proceduresService) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
    }

    @GetMapping("/menu")
    public String getMasterMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);

        return "/menu/master-menu";
    }

    @GetMapping("/procedures")
    public String getProcedures(Model model) {
        model.addAttribute("procedures", proceduresService.getAllProcedures());
        return "/procedures/master-procedures";
    }
}
