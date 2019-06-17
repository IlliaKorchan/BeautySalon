package beautysalon.controller;

import beautysalon.model.services.AppointmentsService;
import beautysalon.model.services.ProceduresService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AppointmentsService appointmentsService;
    private ProceduresService proceduresService;

    public AdminController(AppointmentsService appointmentsService, ProceduresService proceduresService) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
    }

    @GetMapping("/menu")
    public String getAdminMenu() {
        return "/menu/admin-menu";
    }

    @GetMapping("/procedures")
    public String getProcedures(Model model) {
        model.addAttribute("procedures", proceduresService.getAllProcedures());
        return "/procedures/admin-procedures";
    }
}
