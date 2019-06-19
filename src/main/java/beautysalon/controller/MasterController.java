package beautysalon.controller;

import beautysalon.model.entities.User;
import beautysalon.model.services.AppointmentsProcessor;
import beautysalon.model.services.ProceduresProcessor;
import beautysalon.model.services.WorkingDayProcessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master")
public class MasterController {
    private AppointmentsProcessor appointmentsService;
    private ProceduresProcessor proceduresService;
    private WorkingDayProcessor workingDayService;

    public MasterController(AppointmentsProcessor appointmentsService,
                            ProceduresProcessor proceduresService,
                            WorkingDayProcessor workingDayService) {
        this.appointmentsService = appointmentsService;
        this.proceduresService = proceduresService;
        this.workingDayService = workingDayService;
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

    @GetMapping("/schedule")
    public String masterSchedule(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("dates", workingDayService.getMasterWorkingDays(user));
        return "/schedule/master-schedule";
    }

    @PostMapping("/schedule")
    public String getMasterAppointments(String date, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        model.addAttribute("masterAppointments", appointmentsService.getMasterAppointments(user, date));
        return masterSchedule(model);
    }
}
