package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.services.AppointmentsService;
import beautysalon.model.services.ProceduresService;
import beautysalon.model.services.UserService;
import beautysalon.model.services.WorkingDayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AppointmentsService appointmentsService;
    private ProceduresService proceduresService;
    private UserService userService;
    private WorkingDayService workingDayService;

    public AdminController(AppointmentsService appointmentsService,
                           ProceduresService proceduresService,
                           UserService userService,
                           WorkingDayService workingDayService) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
        this.userService = userService;
        this.workingDayService = workingDayService;
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

    @GetMapping("/schedule")
    public String getAdminSchedulePage(Model model) {
        model.addAttribute("masters", userService.getUsersByRole("master"));
        return "/admin/master-schedule";
    }

    @PostMapping("/schedule")
    public String getMasterDates(Integer masterId, Model model) {
        User master = userService.findById(masterId);
        model.addAttribute("masterDates", workingDayService.getMasterWorkingDays(master));

        return "/admin/master-schedule";
    }

    @PostMapping("master-appointments")
    public String getMasterAppointments(String date,)

}
