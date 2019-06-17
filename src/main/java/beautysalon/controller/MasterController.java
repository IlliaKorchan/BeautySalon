package beautysalon.controller;

import beautysalon.model.entities.Appointment;
import beautysalon.model.entities.User;
import beautysalon.model.services.AppointmentsService;
import beautysalon.model.services.ProceduresService;
import beautysalon.model.services.WorkingDayService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterController {
    private AppointmentsService appointmentsService;
    private ProceduresService proceduresService;
    private WorkingDayService workingDayService;

    public MasterController(AppointmentsService appointmentsService,
                            ProceduresService proceduresService,
                            WorkingDayService workingDayService) {
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
